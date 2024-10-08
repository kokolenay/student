package com.cqu.student.service.impl;

import com.cqu.student.mapper.DomitoriesMapper;
import com.cqu.student.pojo.Domitories;
import com.cqu.student.service.DomitoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DomitoriesServiceImpl implements DomitoriesService {

    @Autowired
    private DomitoriesMapper domitoriesMapper;

    @Override
    public List<Map<Integer, Object>> countBuilding() {
        return domitoriesMapper.countBuilding();
    }

    @Override
    public Domitories getDormitoryById(int doId) {
        return domitoriesMapper.getDormitoryById(doId);
    }

    @Override
    public List<Domitories> getALLDormitories() {
        return domitoriesMapper.getALLDormitories();
    }
}


