package com.glearning.twitterapp.service;

import com.glearning.twitterapp.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> listAll();

    User findById(long id);

    void deleteUser(long userId);

    User updateUser(long userId, User user);
}
