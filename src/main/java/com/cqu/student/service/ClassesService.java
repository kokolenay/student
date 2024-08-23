package com.cqu.student.service;

import com.cqu.student.pojo.Clazz;

import java.util.List;

public interface ClassesService {
    public List<Clazz> findClasses(String classTeacher, String time, String places);
}
