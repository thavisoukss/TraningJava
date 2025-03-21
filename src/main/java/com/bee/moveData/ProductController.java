package com.bee.moveData;


import com.bee.moveData.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

     @Autowired
    UserService userService;

     @Autowired
    TokenService tokenService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Spring Boot REST API!";
    }


    @GetMapping("/user")
    public String user() {

           userService.GetUser();

        return "Welcome to the Spring Boot REST API!";
    }



}
