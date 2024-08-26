package com.cqu.student.mapper;


import com.cqu.student.pojo.StudentClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentClassMapper {
    int classSuccess(int stuId, int classId);

    StudentClass ifChosen(int stuId, int classId);
}
