package com.ljp.history.controller;

import com.ljp.history.entity.User;
import com.ljp.history.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/register")
    public String login(User user){
        return userService.save(user).toString();
    }

    //测试
    @PostMapping("/test")
    public String test(User user){
        System.out.println(user.toString());
        return user.toString();
    }
}