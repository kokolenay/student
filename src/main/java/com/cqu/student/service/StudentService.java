package com.cqu.student.service;

import com.cqu.student.pojo.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface StudentService {

    public int register(Student student) throws  Exception;

    public int countOnline();

    public int countOnsite();

    public List<Map<String, Object>> countDepartment();

    public List<Map<LocalDate, Object>> countTime();

    public List<Map<Integer, Object>> countProcess();

    public List<Map<String, Object>> countPlace();

    public  List<Student> findStudent(Integer stuId, String stuName) throws Exception;

    public  int updateStudent(Student student)throws Exception;

    //学生登录
    public Student login(String phone, String password)throws  Exception;
    public boolean stuDelete(int stuId);

    //学生选宿舍
    public Student getStudentById(int stuId);

    public void updateStudentDormitory(int stuId, int doId);

    public String assignDormitory(int stuId, int doId);

    public int addStudent(Student student)throws Exception;

    public List<Map<String, Object>> countGender();

    public List<Student> findAllStudent()throws Exception;
}

