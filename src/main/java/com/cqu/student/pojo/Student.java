package com.cqu.student.pojo;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class Student {
    private Integer stu_id;
    private String stu_name;
    private int age;
    private String gender;
    private String phone;
    private String password;
    private String id_card;
    private String address;
    private String image;
    private int status;
    private String registerMethod;
    private String department;
    private LocalDate registerTime;
    private String stuPlace;
}
