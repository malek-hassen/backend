//package com.billcom.drools.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.billcom.drools.model.User;
//import com.billcom.drools.repository.UserRepository;
//
//@RestController
//public class UserController {
//
//    @Autowired
//     UserRepository userRepo;
//
//
//    @PostMapping("/addUser")
//    public User addUser(@RequestBody User user) {
//        System.out.println("add user" + user.toString());
//        return userRepo.save(user);
//    }
//
//
//
//    @GetMapping("/getAllUser")
//    public List<User> getAllUser(){
//        return userRepo.findAll();
//    }
//}