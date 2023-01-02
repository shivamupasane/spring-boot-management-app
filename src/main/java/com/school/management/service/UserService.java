package com.school.management.service;

import com.school.management.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User getUser(Long id);
    User getUser(String id);
}
