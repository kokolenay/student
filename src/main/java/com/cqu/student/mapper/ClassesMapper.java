package com.cqu.student.mapper;

import com.cqu.student.pojo.Classes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassesMapper {
    //查询课程
    public List<Classes> findClasses(Classes classes);

    public Classes getClassesById(int classId);

    public void updateChosen(int classId);

    public List<Classes> getAllClasses();
}
