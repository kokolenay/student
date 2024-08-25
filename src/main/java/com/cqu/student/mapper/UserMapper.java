package com.cqu.student.mapper;

import com.cqu.student.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User userLogin(String username, String password);
}
