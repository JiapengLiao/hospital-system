package com.ljp.hospital.controller;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.ljp.hospital.annotation.UserLoginToken;
import com.ljp.hospital.entity.Result;
import com.ljp.hospital.entity.User;
import com.ljp.hospital.service.TokenService;
import com.ljp.hospital.service.UserService;
import com.ljp.hospital.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

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
    public Result login(HttpServletResponse response, @RequestParam String username, @RequestParam String password){
        //登陆成功，然后生成token并返回给前端
        if(0 == userService.login(username, password)){
            String token = TokenUtil.getTokenString(username);
            response.setHeader("token", token);
            return new Result("登录成功", null);
        }

        return new Result("用户名或密码错误", null);
    }

    //测试
    @PostMapping("/test")
    public String test(HttpServletRequest request){
        String token = request.getHeader("token");
        String username = "";
        try {
            username = TokenUtil.getTokenUser();
        }catch (IllegalArgumentException e){
            return "身份信息出错";
        }catch (JWTDecodeException e){
            return "身份信息出错";
        }
        return username;
    }
}