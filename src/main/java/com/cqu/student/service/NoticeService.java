package com.cqu.student.service;

import cn.hutool.db.Page;
import com.cqu.student.pojo.Notice;

import java.util.List;

public interface NoticeService {
    int insert(Notice notice);
    int update(Notice notice);
    int delete(Integer id);
    List<Notice> query();

    List<Notice> findNotice(Notice notice);

//    public Page queryAll(Integer currentPage, Integer pageSize);
}
