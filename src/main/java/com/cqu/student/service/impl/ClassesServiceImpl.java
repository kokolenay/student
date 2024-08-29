package com.cqu.student.service.impl;

import com.cqu.student.mapper.ClassesMapper;
import com.cqu.student.pojo.Classes;
import com.cqu.student.pojo.Notice;
import com.cqu.student.service.ClassesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> findClasses(Classes classes) {
        return classesMapper.findClasses(classes);
    }

    @Override
    public List<Classes> getAllClasses(){
        return classesMapper.getAllClasses();
    }

    @Override
    public int insertClass(Classes notice){
        notice.setChosen(0);
        return classesMapper.insertClass(notice);
    }
    @Override
    public int updateClass(Classes notice){
        return classesMapper.updateClass(notice);
    }
    @Override
    public int deleteClass(Integer id){
        return classesMapper.deleteClass(id);
    }

    @Override
    public Page queryAll(Integer currentPage, Integer pageSize){
        Page<Classes> page = PageHelper.startPage(currentPage, pageSize);
        List<Classes> infos = classesMapper.queryAll();
        return page;
    }
}