package com.ap.BasicProject.service;

import com.ap.BasicProject.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    public User getUser() {
        return new User(1, "Abhi", new Date());
    }
}
