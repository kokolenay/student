package com.cqu.student.mapper;

import com.cqu.student.pojo.Domitories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DomitoriesMapper {
    public List<Map<Integer, Object>> countBuilding();

    //宿舍查询
    public Domitories getDormitoryById(int doId);

    //修改宿舍信息：更新宿舍已入住人数
    public void incrementOccupied(int doId);

    //宿舍显示
    public List<Domitories> getALLDormitories();
}
