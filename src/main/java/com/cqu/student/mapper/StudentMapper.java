package com.cqu.student.mapper;

import com.cqu.student.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //账户激活
    public int register(Student student) throws  Exception;

    public int countOnline();

    public int countOnsite();

    public List<Map<String, Object>> countDepartment();

    public List<Map<LocalDate, Object>> countTime();

    public List<Map<Integer, Object>> countProcess();

    public List<Map<String, Object>> countPlace();

    public  List<Student> findStudent(Integer stuId, String stuName);

    public int updateStudent(Student student);

    public Student login(String phone,String password);

    public int stuDelete(int stuId);

    //数据库中通过id查询学生
    public Student getStudentById(int stuId);

    //学生选择宿舍
    public void updateStudentDormitory(int stuId, int doId);

    public int addStudent(Student student);

    public List<Map<String, Object>> countGender();

    public List<Student> findAllStudent() throws Exception;
}
