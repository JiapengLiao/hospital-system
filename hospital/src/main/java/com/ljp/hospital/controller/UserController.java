package com.ljp.hospital.controller;

import com.ljp.hospital.entity.User;
import com.ljp.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    /**
     * @param user 要插入的用户
     * @return 插入的条数
     * */
    @PostMapping("/register")
    public String register(@RequestBody User user){
        return Integer.toString(userService.save(user));
    }

    //登录
    /**
     * @param username 用户名
     * @param password 密码
     * @return 插入的条数
     * */
    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        if(0 == userService.login(username, password)){
            return "登陆成功";
        }
        return "用户名或密码错误";
    }

    //测试
    @PostMapping("/test")
    public String test(User user){
        System.out.println(user.toString());
        return "user.toString()";
    }
}