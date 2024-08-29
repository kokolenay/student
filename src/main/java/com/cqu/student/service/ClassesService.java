package com.cqu.student.service;

import com.cqu.student.pojo.Classes;
import com.cqu.student.pojo.Notice;
import com.github.pagehelper.Page;

import java.util.List;

public interface ClassesService {
    public List<Classes> findClasses(Classes classes);

    public List<Classes> getAllClasses();

    int insertClass(Classes classes);
    int updateClass(Classes classes);
    int deleteClass(Integer id);

    public Page queryAll(Integer currentPage, Integer pageSize);
}
