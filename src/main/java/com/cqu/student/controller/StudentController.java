package com.cqu.student.controller;

import com.cqu.student.pojo.Domitories;
import com.cqu.student.pojo.Student;
import com.cqu.student.service.DomitoriesService;
import com.cqu.student.service.StudentService;
import com.cqu.student.utils.ParamsPojo;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DomitoriesService dormitoriesService;


    @PostMapping("assignDormitory")
    public R assignDormitory(@RequestBody ParamsPojo paramsPojo){
        HashMap maps = paramsPojo.getMaps();
        Integer stuId= (Integer) maps.get("stuId");
        Integer doId= (Integer) maps.get("doId");
        if(stuId  <= 0 ){
            return R.fail("用户id无效！");
        }
        if(doId <= 0 ){
            return R.fail("寝室id无效！");
        }
        String aaa = studentService.assignDormitory(stuId, doId);

        return aaa!=null ? R.success(aaa) :R.fail("操作失败");
    }

    @PostMapping("addStudent")
    public R addStudent(@RequestBody Student student)throws Exception{
        int student1=studentService.addStudent(student);
        return student1 > 0 ? R.success(student1): R.fail("操作失败");
    }

    @GetMapping("findAllStudent")
    public R findAllStudent() throws Exception{
        List<Student> student1=studentService.findAllStudent();
        return !student1.isEmpty() ? R.success(student1): R.fail("操作失败");
    }
}
