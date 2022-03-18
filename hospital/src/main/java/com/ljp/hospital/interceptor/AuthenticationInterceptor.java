package com.ljp.hospital.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.ljp.hospital.annotation.PassToken;
import com.ljp.hospital.annotation.UserLoginToken;
import com.ljp.hospital.entity.User;
import com.ljp.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("收到请求：" + request.getRemoteHost() + request.getRequestURI() + ":" + request.getRemotePort());
        return true;
    }
}
