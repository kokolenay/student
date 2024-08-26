package com.cqu.student.pojo;


import lombok.Data;

import java.util.Set;

@Data
public class EmailRequest {
    Set<String> emails;
    String title;
    String content;
}