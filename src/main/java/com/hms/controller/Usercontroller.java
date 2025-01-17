package com.hms.controller;

import com.hms.ThirdpartyService.JwtService;
import com.hms.entity.User;
import com.hms.repo.UserRepository;
import com.hms.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class Usercontroller {
    private UserRepository userRepository;
    private JwtService jwtService;
    private UserService userService;

    public Usercontroller(UserRepository userRepository, JwtService jwtService, UserService userService) {
        this.userRepository = userRepository;
        this.jwtService=jwtService;
        this.userService=userService;
    }

    //show all user
    @GetMapping("/get")
    private List<User> getUser(){
        List<User> users = userRepository.findAll();
        return users;
    }
    //create user
    @PostMapping("/create")
    private User createUser(@RequestBody User user){
        String hashpw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5));
        user.setPassword(hashpw);
        return userRepository.save(user);
    }
    @GetMapping("/login")
    public String veryfytoken(@RequestBody User user){
        User user1 = userRepository.getByName(user.getName()).get();
        boolean checkpw = BCrypt.checkpw(user.getPassword(), user1.getPassword());
        if(checkpw){
            String token = jwtService.generateToken(user1.getName());
            return token;
        }
        return "Invalid User";

    }

}
