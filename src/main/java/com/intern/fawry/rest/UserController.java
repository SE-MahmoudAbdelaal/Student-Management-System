package com.intern.fawry.rest;

import com.intern.fawry.repository.entity.User;
import com.intern.fawry.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") int userId,
            @RequestBody User updatedUser) {

        Optional<User> existingUser = userService.getUserById(userId);

        if (existingUser.isPresent()) {
            updatedUser.setId(userId);
            User savedUser = userService.saveUser(updatedUser);
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{userId}/courses/{selected}")
    public ResponseEntity<?> addUserCourses(
            @PathVariable("userId") int userId,
            @PathVariable("selected") List<Integer> selectedCourseIds) {

        try {
            userService.addUserCourses(userId, selectedCourseIds);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
