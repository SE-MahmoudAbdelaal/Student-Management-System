package com.intern.fawry.dao;

import com.intern.fawry.model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(int id);
    void save(User user);
    void update(int id,User user);
    void delete(int id);
}

