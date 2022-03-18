package com.ljp.hospital.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TokenUtil {
    public static String getTokenString(String username){
        return JWT.create()
                //.withExpiresAt(Date.parse("2000"))//设置过期时间
                .withAudience(username)
                .sign(Algorithm.HMAC256("Woshi42010"));//使用HMAC算法
    }

    public static String getTokenUser(){
        String token = getRequest().getHeader("token");
        String username = JWT.decode(token).getAudience().get(0);
        return username;
    }

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
