package com.cqu.student.mapper;

import com.cqu.student.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    public void upload(String url, Integer stuId);
}
