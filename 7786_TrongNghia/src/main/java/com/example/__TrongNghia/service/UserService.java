package com.example.__TrongNghia.service;

import com.example.__TrongNghia.entity.User;
import com.example.__TrongNghia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
