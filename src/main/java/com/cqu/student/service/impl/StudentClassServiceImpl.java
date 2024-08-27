package com.cqu.student.service.impl;

import com.cqu.student.mapper.ClassesMapper;
import com.cqu.student.mapper.StudentClassMapper;
import com.cqu.student.pojo.Classes;
import com.cqu.student.pojo.StudentClass;
import com.cqu.student.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    private StudentClassMapper studentclassMapper;
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public int classIfSuccess(int stuId, int classId) {
        Classes classes =classesMapper.getClassesById(classId);
        int capacity=classes.getCapacity();
        int chosen=classes.getChosen();
        if(chosen>=capacity){
            return 0;
        }

        classesMapper.updateChosen(classId);
        return studentclassMapper.classSuccess(stuId,classId);
    }

    @Override
    public List<Integer> ifChosen(Integer stuId) {
        return this.studentclassMapper.ifChosen(stuId);
    }


}
