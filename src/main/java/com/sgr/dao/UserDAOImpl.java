package com.sgr.dao;

import com.sgr.entity.User;
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
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        return theQuery.getResultList();

    }

    @Override
    public User findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);  

    }

    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("delete from User where id=:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();

    }


}