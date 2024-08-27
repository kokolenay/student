package com.cqu.student.service;

import com.cqu.student.pojo.User;

public interface UserService {
    public User userLogin(String username, String password);

    public int insertUser(User user);
    public int updateUser(User user);
}
