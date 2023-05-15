package com.sgr.dao;

import com.sgr.entity.Usuario;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserDAOImpl implements UserDAO{

    private final EntityManager entityManager;

    @Override
    public List<Usuario> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("from Usuario", Usuario.class);

        return theQuery.getResultList();

    }

    @Override
    public Usuario findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(Usuario.class, id);
    }

    @Override
    public void save(Usuario usuario) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(usuario);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("delete from Usuario where id=:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();

    }

    @Override
    @Transactional
    public void update(Long id, Usuario usuario) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Usuario> theQuery = currentSession.createQuery("update Usuario u set u.email=:email, u.password=:password, u.rol=:rol where u.id=:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.setParameter("email", usuario.getEmail());
        theQuery.setParameter("password", usuario.getPassword());
        theQuery.setParameter("rol", usuario.getRol());

        theQuery.executeUpdate();
    }


}