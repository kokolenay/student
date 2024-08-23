package com.cqu.student.mapper;

import com.cqu.student.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //账户激活
    public int register(Student student);

    public int countOnline();

    public int countOnsite();

    public List<Map<String, Object>> countDepartment();

    public List<Map<LocalDate, Object>> countTime();

    public List<Map<Integer, Object>> countProcess();

    public List<Map<String, Object>> countPlace();
}