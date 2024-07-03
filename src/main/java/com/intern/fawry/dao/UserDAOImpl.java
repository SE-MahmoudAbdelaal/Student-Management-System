package com.intern.fawry.dao;

import com.intern.fawry.exception.BaseResponse;
import com.intern.fawry.exception.UserException;
import com.intern.fawry.exception.UserNotFoundException;
import com.intern.fawry.model.Course;
import com.intern.fawry.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class UserDAOImpl implements UserDAO{
    private final List<User> users = new ArrayList<>();

    @Override
    public BaseResponse<List<User>> findAll()throws UserException {
        BaseResponse<List<User>> listBaseResponse=new BaseResponse<>();
        listBaseResponse.setData(users);
        return listBaseResponse;
    }

    @Override
    public BaseResponse<User> findById(int id) throws UserException{
       User usert= users.stream()
                .filter(user -> user.getId()==id)
                .findFirst()
                .orElseThrow(()->new UserException("User with id " + id + " not found"));
       BaseResponse<User> userBaseResponse=new BaseResponse<>();
       userBaseResponse.setData(usert);
       return userBaseResponse;
    }

    @Override
    public BaseResponse<Void> save(User user) throws UserException{
        try {
            user.setId(users.size());
            IntStream.range(0,user.getCourses().size())
                    .forEach(courseId ->user.getCourses().get(courseId).setId(courseId));
            users.add(user);
            return new BaseResponse<>();
//        for (int i = 0; i < user.getCourses().size(); i++) {
//            Course course=user.getCourses().get(i);
//            course.setId(i);
//
//        }
        }catch (Exception e){
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public BaseResponse<Void> update(int id,User user) throws UserException{

            int index = IntStream.range(0, users.size())
                    .filter(i -> users.get(i).getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new UserException("User with id " + id + " not found"));

            user.setId(index);
            IntStream.range(0, user.getCourses().size())
                    .forEach(courseId -> user.getCourses().get(courseId).setId(courseId));

            users.set(index, user);
            return new BaseResponse<>();

    }

    @Override
    public BaseResponse<Void> delete(int id) throws UserException {
            int index = IntStream.range(0, users.size())
                    .filter(i -> users.get(i).getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new UserException("User with id " + id + " not found"));
            users.remove(index);
            return new BaseResponse<>();
    }
}
