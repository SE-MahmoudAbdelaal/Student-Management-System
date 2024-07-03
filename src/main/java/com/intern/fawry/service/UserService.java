package com.intern.fawry.service;

import com.intern.fawry.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void createUser(User user);
    void updateUser(int id,User user);
    void deleteUser(int id);
}
