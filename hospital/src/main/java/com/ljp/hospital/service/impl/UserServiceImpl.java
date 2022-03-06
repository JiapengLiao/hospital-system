package com.ljp.hospital.service.impl;

import com.ljp.hospital.entity.User;
import com.ljp.hospital.mapper.UserMapper;
import com.ljp.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfo(String username) {
        return userMapper.getUserInfo(username);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int Update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int save(User user) {
        int save = 0;
        if(userMapper.isExistUser(user.getUsername())==0) {
            save = userMapper.save(user);
        }
        return save;
    }

    @Override
    public int login(String username, String password) {
        if (userMapper.isExistUser(username)==0){
            return 1;//用户名不存在
        }
        User user = userMapper.getUserInfo(username);
        if (password.equals(user.getPassword())){
            return 0;//登陆成功
        }
        return 2;//密码错误
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
