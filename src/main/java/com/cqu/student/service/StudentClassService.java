package com.cqu.student.service;

import com.cqu.student.pojo.StudentClass;

import java.util.List;

public interface StudentClassService {
    public int classIfSuccess(int stuId, int classId);
    List<Integer> ifChosen(Integer stuId);
}
