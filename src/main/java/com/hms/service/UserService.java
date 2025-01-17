package com.hms.service;

import com.hms.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
