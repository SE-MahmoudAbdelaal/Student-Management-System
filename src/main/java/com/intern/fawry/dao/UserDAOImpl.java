package com.intern.fawry.dao;

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
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
       return users.stream()
                .filter(user -> user.getId()==id)
                .findFirst()
                .orElseThrow(()->new UserNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public void save(User user) {
        user.setId(users.size());
        IntStream.range(0,user.getCourses().size())
                .forEach(courseId ->user.getCourses().get(courseId).setId(courseId));

//        for (int i = 0; i < user.getCourses().size(); i++) {
//            Course course=user.getCourses().get(i);
//            course.setId(i);
//
//        }
        users.add(user);
    }

    @Override
    public void update(int id,User user) {

        int index= IntStream.range(0, users.size())
                .filter(i -> users.get(i).getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

        user.setId(index);
        IntStream.range(0,user.getCourses().size())
                .forEach(courseId ->user.getCourses().get(courseId).setId(courseId));

        users.set(index, user);

    }

    @Override
    public void delete(int id) {
        users.remove(id);
    }
}
