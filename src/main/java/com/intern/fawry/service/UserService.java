package com.intern.fawry.service;

import com.intern.fawry.exception.BaseResponse;
import com.intern.fawry.exception.UserException;
import com.intern.fawry.model.User;

import java.util.List;

public interface UserService {
    BaseResponse<List<User>> getAllUsers()throws UserException;
    BaseResponse<User> getUserById(int id)throws UserException;
    BaseResponse<Void> createUser(User user)throws UserException;
    BaseResponse<Void> updateUser(int id,User user)throws UserException;
    BaseResponse<Void> deleteUser(int id)throws UserException;
}
