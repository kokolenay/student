package com.cqu.student.controller;

import com.cqu.student.pojo.Notice;
import com.cqu.student.service.NoticeService;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Notice")
public class NoticeController {
    //注入NoticeService实例

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/notice")
    public R addNotice(@RequestBody Notice notice){

        int row=noticeService.insert(notice);
        return row >0?R.success(row):R.fail("操作失败");
    }

    @PostMapping("/update")
    public R updateNotice(@RequestBody Notice notice) {

        int row = noticeService.update(notice);
        return row > 0 ? R.success(row) : R.fail("操作失败");
    }

    @DeleteMapping("/delete/{id}")
    public R deleteNotice(@PathVariable Integer id) {

        int row = noticeService.delete(id);
        return row > 0 ? R.success(row) : R.fail("操作失败");
    }

    @GetMapping("/query")
    public R queryALL() {
        List<Notice> noticelist =noticeService.query();
        return noticelist.size()>0?R.success(noticelist):R.fail("操作失败");


    }
}