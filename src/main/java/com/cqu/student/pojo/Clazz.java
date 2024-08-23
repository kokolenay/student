package com.cqu.student.pojo;

import lombok.Data;

@Data
public class Clazz {
    private Integer classId;
    private String className;
    private String classTeacher;
    private String time;
    private String place;
    private int credits;
    private int capacity;

}
