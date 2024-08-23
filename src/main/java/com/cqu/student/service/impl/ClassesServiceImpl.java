package com.cqu.student.service.impl;

import com.cqu.student.mapper.ClassesMapper;
import com.cqu.student.pojo.Clazz;
import com.cqu.student.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Clazz> findClasses(String classTeacher, String time, String place) {
        return classesMapper.findClasses(classTeacher, time, place);
    }
}