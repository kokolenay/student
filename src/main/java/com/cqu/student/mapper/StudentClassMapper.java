package com.cqu.student.mapper;


import com.cqu.student.pojo.StudentClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentClassMapper {
    int classSuccess(int stuId, int classId);

    List<Integer> ifChosen(Integer stuId);
}
