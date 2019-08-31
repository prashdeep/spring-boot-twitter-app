package com.glearning.twitterapp.service;

import com.glearning.twitterapp.model.User;
import com.glearning.twitterapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> listAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void deleteUser(long userId) {
        User retrievedUser = this.userRepository.findById(userId);
        if(retrievedUser != null){
            this.userRepository.delete(retrievedUser);
        }
    }

    @Override
    public User updateUser(long userId, User user) {
        User retrievedUser = this.userRepository.findById(userId);
        if(retrievedUser != null){
            this.userRepository.save(user);
        }
        return user;
    }
}
