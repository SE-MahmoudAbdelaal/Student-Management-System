package com.intern.fawry.controller;

import com.intern.fawry.exception.BaseResponse;
import com.intern.fawry.exception.UserException;
import com.intern.fawry.model.User;
import com.intern.fawry.service.UserService;
import jakarta.validation.Valid;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public BaseResponse<List<User>> getAllUsers() throws UserException {
       return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public BaseResponse<User> getUserById(@PathVariable @Valid int id) throws UserException {
        return userService.getUserById(id);
    }

    @PostMapping
    public BaseResponse<Void> createUser(@RequestBody @Valid User user) throws UserException{
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public BaseResponse<Void> updateUser(@PathVariable @Valid int  id, @RequestBody @Valid User user) throws UserException{
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<Void> deleteUser(@PathVariable @Valid int id) throws UserException{
        return userService.deleteUser(id);
    }
}
