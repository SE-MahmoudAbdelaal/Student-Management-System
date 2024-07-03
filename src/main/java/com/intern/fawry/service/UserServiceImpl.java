package com.intern.fawry.service;

import com.intern.fawry.dao.UserDAO;
import com.intern.fawry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUserById(int id) {
        return userDAO.findById(id);
    }

    public void createUser(User user) {
        userDAO.save(user);
    }

    public void updateUser(int id, User user) {
        userDAO.update(id,user);
    }

    public void deleteUser(int id) {
        userDAO.delete(id);
    }
}
