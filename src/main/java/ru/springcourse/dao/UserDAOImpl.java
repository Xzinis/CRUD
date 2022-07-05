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

    public List<User> index() {
        Session em = entityManager.unwrap(Session.class);

        return em.createQuery("select p from User p", User.class)
                .getResultList();
    }

    public User show(int id) {
        Session em = entityManager.unwrap(Session.class);
        return em.get(User.class, id);
    }

    public void save(User user) {
        Session em = entityManager.unwrap(Session.class);
        em.persist(user);
    }

    public void update(int id, User updatedUser) {
        Session em = entityManager.unwrap(Session.class);
        User userToBeUpdated = em.get(User.class, id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        Session em = entityManager.unwrap(Session.class);
        em.remove(em.get(User.class, id));
    }
}