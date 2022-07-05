package ru.springcourse.dao;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.springcourse.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    public List<User> index() {
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Transactional
    public void save(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        Session session = entityManager.unwrap(Session.class);
        User userToBeUpdated = session.get(User.class, id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(User.class, id));
    }
}