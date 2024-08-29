package com.cqu.student.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    public void upload(String url, Integer stuId);

    public void uploadClasses(String url, Integer classId);
}
