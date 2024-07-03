package com.intern.fawry.dao;

import com.intern.fawry.exception.BaseResponse;
import com.intern.fawry.exception.UserException;
import com.intern.fawry.model.User;

import java.util.List;

public interface UserDAO {
    BaseResponse<List<User>> findAll()throws UserException;
    BaseResponse<User> findById(int id)throws UserException;
    BaseResponse<Void> save(User user)throws UserException;
    BaseResponse<Void> update(int id,User user)throws UserException;
    BaseResponse<Void> delete(int id)throws UserException;
}

