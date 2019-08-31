package com.glearning.twitterapp.controller;

import com.glearning.twitterapp.model.User;
import com.glearning.twitterapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        return this.userService.listAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id")long id){
        return this.userService.findById(id);
    }

    @PostMapping(value = "/", consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        User saveUser = this.userService.saveUser(user);
        return saveUser;
    }



}
