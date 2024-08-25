package com.cqu.student.service.impl;

import com.cqu.student.mapper.ClassesMapper;
import com.cqu.student.pojo.Classes;
import com.cqu.student.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> findClasses(Classes classes) {
        return classesMapper.findClasses(classes);
    }
}