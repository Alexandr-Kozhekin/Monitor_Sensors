package com.monitor_sensors.core.database;

import com.monitor_sensors.core.domain.User;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserRepositoryImpl implements UserRepository{

    @Autowired private SessionFactory sessionFactory;

    public void registrationUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User authorizationUser(String email, char[] password) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE email = :email and password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.getResultList();

        return (User) query.getResultList().get(0);
    }

    public List<User> fiendAllUsers() {

        return sessionFactory
                .getCurrentSession()
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();

    }

    public User findUserByEmail(String email){

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT u FROM User u WHERE email = :email", User.class);

        query.setParameter("email", email);

        return (User) query.getResultList().get(0);
    }

}
