package com.cqu.student.service;

import com.cqu.student.pojo.Classes;

import java.util.List;

public interface ClassesService {
    public List<Classes> findClasses(String classTeacher, String time, String places);
}
