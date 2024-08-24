package com.cqu.student.mapper;

import com.cqu.student.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassesMapper {
    //查询课程
    public List<Classes> findClasses(String classTeacher, String time, String place);

    public Classes getClassesById(int class_id);
}
