package com.cqu.student.service;

import com.cqu.student.pojo.Student;

public interface FileService {
    public void upload(String url, Integer stuId);

    public void uploadClasses(String url, Integer classId);
}
