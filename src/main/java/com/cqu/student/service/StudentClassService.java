package com.cqu.student.service;

import com.cqu.student.pojo.StudentClass;

public interface StudentClassService {
    public int classIfSuccess(int stuId, int classId);
    public StudentClass ifChosen(int stuId, int classId);
}
