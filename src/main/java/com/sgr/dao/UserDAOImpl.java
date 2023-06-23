package com.sgr.dao;

import com.sgr.entity.Usuario;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
//import org.springframework.transaction.annotation.Transactional;
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
    public Usuario findById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        
        return currentSession.get(Usuario.class, id);
    }
    
    List<Usuario> findUsersByUsername() {
		return null;
	}

    @Override
    @Transactional
    public String save(Usuario usuario) {
    	String response;
        Session currentSession = entityManager.unwrap(Session.class);
        System.out.println("UserDAOImpl - usuario a crear: "+usuario.toString());
        if(!userExistsWithUsername(currentSession, usuario.getUsername())) {
        	currentSession.save(usuario);
        	System.out.println("UserDAOImpl - usuario creado");
        	response = "Usuario creado exitosamente: "+usuario.toString();
        }else {
        	System.out.println("UserDAOImpl - ya existe un usuario con ese nombre");
        	response = "Ya existe un usuario con ese nombre";
        }
        return response;
    }
    
    private boolean userExistsWithUsername(Session currentSession, String username) {
    	Query<Usuario> theQuery = currentSession.createQuery("select id from Usuario where username=:username");
    	theQuery.setParameter("username", username);
		return !theQuery.getResultList().isEmpty();
	}
    
	@Override
    @Transactional
    public void deleteById(Long id) {
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