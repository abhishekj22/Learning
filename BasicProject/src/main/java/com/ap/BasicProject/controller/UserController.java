package com.ap.BasicProject.controller;

import com.ap.BasicProject.entity.User;
import com.ap.BasicProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Object> createOrUpdate(@RequestBody User user){
        User updatedUser = userService.createOrUpdateUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(updatedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
