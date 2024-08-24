package com.cqu.student.service;

import com.cqu.student.pojo.Domitories;

import java.util.List;
import java.util.Map;

public interface DomitoriesService {
    public List<Map<Integer, Object>> countBuilding();

    //内部查询宿舍信息
    public Domitories getDormitoryById(int doId);

    //显示宿舍信息
    public List<Domitories> getALLDormitories();
}
