package com.bee.moveData.controller;



import com.bee.moveData.model.User;
import com.bee.moveData.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

     @Autowired
     UserService userService;


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Spring Boot REST API!";
    }

    @GetMapping("/getAllUer")
    public List<User> getAllUer() {
        return userService.getAllUser();
    }









}
