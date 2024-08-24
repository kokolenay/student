package com.cqu.student.service.impl;

import com.cqu.student.mapper.ClassesMapper;
import com.cqu.student.mapper.StudentClassMapper;
import com.cqu.student.pojo.Classes;
import com.cqu.student.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    private StudentClassMapper studentclassMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public String classIfSuccess(int stuId, int classId) {
        Classes classes =classesMapper.getClassesById(classId);
        int capacity=classes.getCapacity();
        int chosen=classes.getChosen();
        if(chosen>=capacity){
            return "Courses is full";
        }

        classesMapper.updateChosen(classId);
        studentclassMapper.classSuccess(stuId,classId);
        return "Student added to class successfully";
    }





}
