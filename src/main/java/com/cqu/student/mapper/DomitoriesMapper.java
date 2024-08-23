package com.cqu.student.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DomitoriesMapper {
    public List<Map<Integer, Object>> countBuilding();
}
