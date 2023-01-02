package com.school.management.service;

import com.school.management.entity.User;
import com.school.management.exception.UserNotFoundException;
import com.school.management.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> users = userRepository.findById(id);
        if(users.isPresent()){
            return users.get();
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public User getUser(String userName) {
        Optional<User> users = userRepository.findByUsername(userName);
        if(users.isPresent()){
            return users.get();
        } else {
            throw new UserNotFoundException(404L);
        }
    }
}
