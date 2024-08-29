package com.cqu.student.service.impl;

import com.cqu.student.mapper.UserMapper;
import com.cqu.student.pojo.User;
import com.cqu.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User userLogin(String username, String password) {
        return userMapper.userLogin(username,password);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
