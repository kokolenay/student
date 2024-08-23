package com.cqu.student.service;

import com.cqu.student.pojo.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface StudentService {
    public int register(Student student);

    public int countOnline();

    public int countOnsite();

    public List<Map<String, Object>> countDepartment();

    public List<Map<LocalDate, Object>> countTime();

    public List<Map<Integer, Object>> countProcess();

    public List<Map<String, Object>> countPlace();
}

