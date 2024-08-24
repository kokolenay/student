package com.cqu.student.service.impl;

import com.cqu.student.mapper.DomitoriesMapper;
import com.cqu.student.mapper.StudentMapper;
import com.cqu.student.pojo.Domitories;
import com.cqu.student.pojo.Student;
import com.cqu.student.service.StudentService;
import com.cqu.student.utils.AESEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private SecretKey key;
    private IvParameterSpec iv;

    public StudentServiceImpl() throws Exception {
        // 初始化密钥和IV
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        this.key = keyGen.generateKey();

        byte[] ivBytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(ivBytes);
        this.iv = new IvParameterSpec(ivBytes);
    }

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

    @Override
    public int updateStudent(Student student) throws Exception{
        if(student.getIdCard()!=null) {
            String encryptedIdCard = AESEncryption.encrypt(student.getIdCard(), key, iv);
            student.setIdCard(encryptedIdCard);
        }
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student login(String phone, String password) {
        return studentMapper.login(phone,password);
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

    public int addStudent(Student student){
        //设置状态码为0
        student.setStatus(0);
        return studentMapper.addStudent(student);

    }
}