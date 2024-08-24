package com.cqu.student.mapper;


import com.cqu.student.pojo.StudentClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentClassMapper {
    void classSuccess(int stu_id, int class_id);
}
