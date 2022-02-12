package com.ap.BasicProject.controller;

import com.ap.BasicProject.entity.User;
import com.ap.BasicProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public User getUser(){
        return userService.getUser();
    }
}
