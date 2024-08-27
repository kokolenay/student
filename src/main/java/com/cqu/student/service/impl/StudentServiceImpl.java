package com.cqu.student.service.impl;

import com.cqu.student.mapper.DomitoriesMapper;
import com.cqu.student.mapper.StudentMapper;
import com.cqu.student.pojo.Domitories;
import com.cqu.student.pojo.Notice;
import com.cqu.student.pojo.Student;
import com.cqu.student.service.StudentService;
import com.cqu.student.utils.AESEncryption;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public int register(Student student) throws  Exception{
        if(student != null && student.getPassword() != null) {
            String encryptedPassword = AESEncryption.encryptByAES(student.getPassword());
            student.setPassword(encryptedPassword);
        }
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
    public  List<Student> findStudent(Integer stuId, String stuName) throws Exception {
        List<Student> students = studentMapper.findStudent(stuId,stuName);
        for(Student student : students) {
            if (student != null && student.getIdCard() != null) {
                String decryptedIdCard = AESEncryption.decryptByAES(student.getIdCard());
                student.setIdCard(decryptedIdCard);  // 将解密后的数据设置回去
            }
            if(student != null && student.getPassword() != null) {
                String decryptedPassword = AESEncryption.decryptByAES(student.getPassword());
                student.setPassword(decryptedPassword);
            }
        }
        return students;
    }

    @Override
    public int updateStudent(Student student) throws Exception{
        if(student.getIdCard()!=null) {
            String encryptedIdCard = AESEncryption.encryptByAES(student.getIdCard());
            student.setIdCard(encryptedIdCard);
        }
        if(student.getPassword()!=null) {
            String encryptedPassword = AESEncryption.encryptByAES(student.getPassword());
            student.setPassword(encryptedPassword);
        }
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student login(String phone, String password) throws  Exception{
        String encryptedPassword = AESEncryption.encryptByAES(password);
        Student student = studentMapper.login(phone,encryptedPassword);
        if (student != null && student.getIdCard() != null) {
            String decryptedIdCard = AESEncryption.decryptByAES(student.getIdCard());
            student.setIdCard(decryptedIdCard);  // 将解密后的数据设置回去
        }
        if(student!=null && student.getPassword()!=null) {
            String decryptedPassword = AESEncryption.decryptByAES(student.getPassword());
            student.setPassword(decryptedPassword);
        }
        return student;
    }

    @Override
    public boolean stuDelete(int stuId) {
        int rowsAffected = studentMapper.stuDelete(stuId);
        return rowsAffected > 0; // 如果删除成功，返回 true
    }

    @Override
    public Student getStudentById(int stuId) {
        return studentMapper.getStudentById(stuId);
    }


    @Override
    public void updateStudentDormitory(int stuId, int doId) {
        studentMapper.updateStudentDormitory(stuId,doId);
    }


    @Autowired
    private DomitoriesMapper dormitoriesMapper;


    public String assignDormitory(int stuId, int doId) {

        Domitories dormitory = dormitoriesMapper.getDormitoryById(doId);
        if (dormitory.getNum() >= dormitory.getCapacity()) {
            return "Dormitory is full!";
        }
        // 更新学生的宿舍信息
        studentMapper.updateStudentDormitory(stuId, doId);
        // 更新宿舍的已入住人数
        dormitoriesMapper.incrementOccupied(doId);
        return "Student assigned to dormitory successfully!";
    }

    public int addStudent(Student student) throws Exception{
        if(student.getIdCard()!=null) {
            String encryptedIdCard = AESEncryption.encryptByAES(student.getIdCard());
            student.setIdCard(encryptedIdCard);
        }
        if(student.getPassword()!=null) {
            String encryptedPassword = AESEncryption.encryptByAES(student.getPassword());
            student.setPassword(encryptedPassword);
        }
        //设置状态码为0
        student.setStatus(0);
        return studentMapper.addStudent(student);
    }

    @Override
    public List<Map<String, Object>> countGender(){
        return studentMapper.countGender();
    }

    @Override
    public List<Student> findAllStudent() throws Exception{
        List<Student> students = studentMapper.findAllStudent();
        for(Student student : students) {
            if (student != null && student.getIdCard() != null) {
                String decryptedIdCard = AESEncryption.decryptByAES(student.getIdCard());
                student.setIdCard(decryptedIdCard);  // 将解密后的数据设置回去
            }
            if(student != null && student.getPassword() != null) {
                String decryptedPassword = AESEncryption.decryptByAES(student.getPassword());
                student.setPassword(decryptedPassword);
            }
        }
        return students;
    }

    @Override
    public Page findAllStudents(Integer currentPage, Integer pageSize){
        Page<Notice> page = PageHelper.startPage(currentPage, pageSize);
        List<Notice> infos = studentMapper.findAllStudents();
        return page;
    }

    @Override
    public int getStudentByPhone(Student student) {
        return studentMapper.getStudentByPhone(student);
    }
}