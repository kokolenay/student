package com.cqu.student.mapper;

import com.cqu.student.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassesMapper {
    //查询课程
    public List<Clazz> findClasses(String classTeacher, String time, String place);
}
