package ru.springcourse.dao;

import ru.springcourse.models.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();
    User show(int id);
    void save(User user);
    void update(User user);
    void delete(int id);


}
