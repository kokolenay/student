package com.cqu.student.controller;

import com.cqu.student.pojo.Student;
import com.cqu.student.service.DomitoriesService;
import com.cqu.student.service.StudentService;
import com.cqu.student.pojo.Clazz;
import com.cqu.student.service.ClassesService;
import com.cqu.student.service.impl.StudentServiceImpl;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/*接受请求，调用业务层接口*/
@RestController
@CrossOrigin
@RequestMapping("user")
public class LoginController {

    //注入业务逻辑接口层对象
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentServiceImpl studentServiceImpl;

    //账户激活
    @PostMapping("/register")
    public R register(@RequestBody Student student){
        int register=studentService.register(student);
        return register>0? R.success(register) :R.fail("操作失败");
    }

    //注入业务逻辑接口层对象
    @Autowired
    private ClassesService classesService;

    @Autowired
    private DomitoriesService domitoriesService;

    @GetMapping("/findClasses")
    public R findClasses(@RequestBody Clazz clazz) {
        String time = clazz.getTime();
        String place = clazz.getPlace();
        String classesTeacher = clazz.getClassTeacher();
        List<Clazz> classes = classesService.findClasses(classesTeacher,time,place);
        return !classes.isEmpty() ? R.success(classes) : R.fail("没有找到符合条件的课程");
    }

    /*获得现场和线上报道人数*/
    @GetMapping("/countOnline")
    public R countOnline() {
        int count = studentService.countOnline();
        return count>0? R.success(count) :R.fail("操作失败");
    }

    @GetMapping("/countOnsite")
    public R countOnsite() {
        int count = studentService.countOnsite();
        return count>0? R.success(count) :R.fail("操作失败");
    }

    /*获得每个系的人数*/
    @GetMapping("/countDepartment")
    public R countDepartment() {
        List<Map<String, Object>> count = studentService.countDepartment();
        return !count.isEmpty()? R.success(count) :R.fail("操作失败");
    }

    /*获得每个系的人数*/
    @GetMapping("/countTime")
    public R countTime() {
        List<Map<LocalDate, Object>> count = studentService.countTime();
        return !count.isEmpty()? R.success(count) :R.fail("操作失败");
    }

    /*获得各个环节已完成的人数*/
    @GetMapping("/countProcess")
    public R countProcess() {
        List<Map<Integer, Object>> count = studentService.countProcess();
        return !count.isEmpty()? R.success(count) :R.fail("操作失败");
    }

    /*获得生源地的人数*/
    @GetMapping("/countPlace")
    public R countPlace() {
        List<Map<String, Object>> count = studentService.countPlace();
        return !count.isEmpty()? R.success(count) :R.fail("操作失败");
    }

    /*获得楼栋的人数*/
    @GetMapping("/countBuilding")
    public R countBuilding() {
        List<Map<Integer, Object>> count = domitoriesService.countBuilding();
        return !count.isEmpty()? R.success(count) :R.fail("操作失败");
    }

    /*查询学生*/
    @PostMapping("/countBuilding")
    public R findStudent(@RequestBody Student student) {
        List<Student> students = studentService.findStudent(student.getStu_id(),student.getStu_name());
        return !students.isEmpty()? R.success(students) :R.fail("操作失败");
    }
}

