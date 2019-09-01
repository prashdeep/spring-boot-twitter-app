package com.glearning.twitterapp.service;

import com.glearning.twitterapp.model.Tweet;
import com.glearning.twitterapp.model.User;
import com.glearning.twitterapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Set<Tweet> getAllTweetsByUserId(long userId) {
       User user = this.userRepository.findById(userId);
       return user.getTweets();
    }

    public void updateUser(User user){
        this.userRepository.save(user);
    }


    @Override
    public void addTweet(long userId, Tweet tweet) {
        User user = this.userRepository.findById(userId);
        user.addTweet(tweet);

    }

    @Override
    public Set<User> getFollowersByUserId(long userId) {
        User user = this.userRepository.findById(userId);
            return user.getFollowers();
    }

    @Override
    public Set<User> getFollowingByUserId(long userId) {
        User user = this.userRepository.findById(userId);
       return user.getFollowing();
    }

    @Override
    public Set<Tweet> getTweetsByFollowerId(long followerId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> listAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findById(id);
    }
}