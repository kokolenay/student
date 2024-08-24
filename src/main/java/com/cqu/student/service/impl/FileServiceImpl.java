package com.cqu.student.service.impl;

import com.cqu.student.mapper.FileMapper;
import com.cqu.student.mapper.StudentMapper;
import com.cqu.student.pojo.Student;
import com.cqu.student.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public void upload(String url, Integer stuId) {
        fileMapper.upload(url,stuId);
    }
}
