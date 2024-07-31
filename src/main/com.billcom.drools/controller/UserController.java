package com.billcom.drools.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.billcom.drools.model.User;
import com.billcom.drools.repository.UserRepository;

@RestController
public class UserController {
    
    @Autowired 
     UserRepository userRepo;
    
    // Save method is predefine method in Mongo Repository
    // with this method we will save user in our database
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
    	Systeme.out.println("user added"+ user.toString());
        return userRepo.save(user);
    }
    
}