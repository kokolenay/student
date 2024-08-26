package com.cqu.student.controller;


import com.cqu.student.pojo.Domitories;
import com.cqu.student.service.DomitoriesService;
import com.cqu.student.pojo.Student;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("user")
public class DormitoriesController {

    @Autowired
    private DomitoriesService dormitoriesService;

    @GetMapping("getALLDormitories")
    public R getALLDormitories(){
        List<Domitories> dormitories =dormitoriesService.getALLDormitories();
        return dormitories!=null ?R.success(dormitories) :R.fail("操作失败");
    }

    /*获得楼栋的人数*/
    @GetMapping("/countBuilding")
    public R countBuilding() {
        List<Map<Integer, Object>> count = dormitoriesService.countBuilding();
        return !count.isEmpty()? R.success(count) :R.fail("操作失败");
    }

    @GetMapping("/dorm/{id}")
    public R getDormitoryById(@PathVariable Integer id){
        System.out.println("123121312232");
        Domitories dormitories1= dormitoriesService.getDormitoryById(id);
        return dormitories1!=null ? R.success(dormitories1) :R.fail("操作失败");
    }

}
