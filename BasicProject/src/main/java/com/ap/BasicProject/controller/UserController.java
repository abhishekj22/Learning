package com.ap.BasicProject.controller;

import com.ap.BasicProject.entity.User;
import com.ap.BasicProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent())
            return user.get();
        throw new RuntimeException("Invalid User");
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public User createOrUpdate(@RequestBody User user){
        return userService.createOrUpdateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
