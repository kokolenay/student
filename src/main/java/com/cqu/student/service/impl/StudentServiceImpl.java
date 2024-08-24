package com.cqu.student.service.impl;

import com.cqu.student.mapper.StudentMapper;
import com.cqu.student.pojo.Student;
import com.cqu.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int register(Student student) {
        student.setStatus(1);
        return studentMapper.register(student);
    }

    @Override
    public int countOnline() {
        return studentMapper.countOnline();
    }

    @Override
    public int countOnsite() {
        return studentMapper.countOnsite();
    }

    @Override
    public List<Map<String, Object>> countDepartment() {
        return studentMapper.countDepartment();
    }

    @Override
    public List<Map<LocalDate, Object>> countTime() {
        return studentMapper.countTime();
    }

    @Override
    public List<Map<Integer, Object>> countProcess() {
        return studentMapper.countProcess();
    }

    @Override
    public List<Map<String, Object>> countPlace() {
        return studentMapper.countPlace();
    }

    @Override
    public  List<Student> findStudent(Integer stuId, String stuName){return studentMapper.findStudent(stuId, stuName);}

}