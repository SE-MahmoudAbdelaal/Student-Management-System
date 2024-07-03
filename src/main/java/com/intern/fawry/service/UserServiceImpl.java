package com.intern.fawry.service;

import com.intern.fawry.dao.UserDAO;
import com.intern.fawry.exception.BaseResponse;
import com.intern.fawry.exception.UserException;
import com.intern.fawry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public BaseResponse<List<User>> getAllUsers() throws UserException {
        return userDAO.findAll();
    }

    public BaseResponse<User> getUserById(int id)throws UserException {
        return userDAO.findById(id);
    }

    public BaseResponse<Void> createUser(User user)throws UserException {

        return userDAO.save(user);
    }

    public BaseResponse<Void> updateUser(int id, User user)throws UserException {
        return userDAO.update(id,user);
    }

    public BaseResponse<Void> deleteUser(int id)throws UserException {
        return userDAO.delete(id);
    }
}
