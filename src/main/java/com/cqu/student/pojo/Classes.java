package com.cqu.student.pojo;

import lombok.Data;

@Data
public class Classes {
    private Integer classId;
    private String className;
    private String classTeacher;
    private String time;
    private String place;
    private int credits;
    private int capacity;
    private int chosen;
    private String department;
    private String type;
}
