package com.glearning.twitterapp.service;

import com.glearning.twitterapp.model.Tweet;
import com.glearning.twitterapp.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User saveUser(User user);

    Set<Tweet> getAllTweetsByUserId(long userId);

    void addTweet(long userId, Tweet tweet);

    Set<User> getFollowersByUserId(long userId);

    Set<User> getFollowingByUserId(long userId);

    Set<Tweet> getTweetsByFollowerId(long follwerId);

    List<User> getAllUsers();

    List<User> listAll();

    User findById(long id);
}

