package com.hms.controller;

import com.hms.entity.User;
import com.hms.repo.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class Usercontroller {
    private UserRepository userRepository;

    public Usercontroller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //show all user
    @GetMapping("/get")
    private List<User> getUser(){
        List<User> users = userRepository.findAll();
        return users;
    }
    //create user
    @PostMapping("/create")
    private User createUser(User user){
        return userRepository.save(user);
    }
}
