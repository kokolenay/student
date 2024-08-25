package com.cqu.student.mapper;

import com.cqu.student.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    int insert(Notice notice);
    int update(Notice notice);
    int delete(Integer id);
    List<Notice> query();
}