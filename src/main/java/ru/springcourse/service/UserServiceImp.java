package ru.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.springcourse.dao.UserDAO;
import ru.springcourse.models.User;


import java.util.List;


@Service
public class UserServiceImp implements UserService {

   private UserDAO userDAO;

   @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
     public List<User> findAll() {
        return userDAO.findAll();
    }

    @Transactional
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
