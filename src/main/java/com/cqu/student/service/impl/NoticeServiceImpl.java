package com.cqu.student.service.impl;

import cn.hutool.db.Page;
import com.cqu.student.mapper.NoticeMapper;
import com.cqu.student.pojo.Notice;
import com.cqu.student.service.NoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.MidiDevice;
import javax.sound.sampled.Line;
import javax.sound.sampled.Port;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl  implements NoticeService {
    //注入NoticeMapper实例
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int insert(Notice notice) {
        //设置发布公告时间为当前系统时间
        Date date=new Date();
        notice.setDate(date);
        return noticeMapper.insert(notice);
    }

    @Override
    public int update(Notice notice) {
        Date date=new Date();
        notice.setDate(date);
        return noticeMapper.update(notice);
    }

    @Override
    public int delete(Integer id) {
        return noticeMapper.delete(id);
    }

    @Override
    public List<Notice> query() {
        return noticeMapper.query();
    }

    @Override
    public  List<Notice> findNotice(Notice notice){
        return noticeMapper.findNotice(notice);
    }

//    @Override
//    public Page queryAll(Integer currentPage, Integer pageSize){
//        Page<Notice> page = PageHelper.startPage(currentPage, pageSize);
//        List<Notice> infos = NoticeMapper.queryAll();
//        return page;
//    }
}
