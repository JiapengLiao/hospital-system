package com.ljp.hospital.service;

import com.ljp.hospital.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
    public String getToken(User user);
}
