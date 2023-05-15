package com.sgr.service;

import java.util.List;

import com.sgr.entity.User;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void deleteById(int id);
}