package com.ljp.hospital.service;

import com.ljp.hospital.entity.User;
import com.ljp.hospital.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getUserInfo(String username);

    int deleteById(int id);

    int Update(User user);

    int save(User user);

    int login(String username, String password);

    List<User> selectAll();
}