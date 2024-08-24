package com.cqu.student.controller;

import com.cqu.student.pojo.Student;
import com.cqu.student.service.DomitoriesService;
import com.cqu.student.service.StudentClassService;
import com.cqu.student.service.StudentService;
import com.cqu.student.pojo.Classes;
import com.cqu.student.service.ClassesService;
import com.cqu.student.service.impl.StudentServiceImpl;
import com.cqu.student.utils.ParamsPojo;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
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

    @Autowired
    private StudentClassService studentClassService;

    @GetMapping("/findClasses")
    public R findClasses(@RequestBody Classes clazz) {
        String time = clazz.getTime();
        String place = clazz.getPlace();
        String classesTeacher = clazz.getClassTeacher();
        List<Classes> classes = classesService.findClasses(classesTeacher,time,place);
        return !classes.isEmpty() ? R.success(classes) : R.fail("没有找到符合条件的课程");
    }

    /*获得现场和线上报道人数*/
    @GetMapping("/countOnline")
    public R countOnline() {
        int count = studentService.countOnline();
        return count>=0? R.success(count) :R.fail("操作失败");
    }

    @GetMapping("/countOnsite")
    public R countOnsite() {
        int count = studentService.countOnsite();
        return count>=0? R.success(count) :R.fail("操作失败");
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
    @GetMapping("/findStudent")
    public R findStudent(@RequestBody Student student) throws Exception {
        List<Student> students = studentService.findStudent(student.getStuId(),student.getStuName());
        return !students.isEmpty()? R.success(students) :R.fail("操作失败");
    }

    /*修改学生*/
    @PostMapping("/updateStudent")
    public R updateStudent(@RequestBody Student student) throws Exception{
        int result = studentService.updateStudent(student);
        return result > 0 ? R.success(result) : R.fail("操作失败");
    }

    @RequestMapping("/login")
    public R login(@RequestBody  Student student)throws  Exception {
        String phone=student.getPhone();
        String password=student.getPassword();
        Student login = studentService.login(phone, password);
        return login!=null?R.success(login):R.fail("手机号或密码错误");

    }

    @DeleteMapping("/stuDelete")
    public R stuDelete(@RequestBody ParamsPojo paramsPojo) {
        HashMap maps=paramsPojo.getMaps();
        int stuId= (int) maps.get("stuId");
        boolean isDeleted = studentService.stuDelete(stuId);
        return isDeleted ?R.success(true):R.fail("手机号或密码错误");

    }

    @RequestMapping("/classSuccess")
    public R classSuccess(@RequestBody ParamsPojo paramsPojo) {
        HashMap maps=paramsPojo.getMaps();
        int stuId= (int) maps.get("stuId");
        int classId= (int) maps.get("classId");

        String stu= studentClassService.classIfSuccess(stuId, classId);
        return stu !=null ? R.success(stu):R.fail("操作失败");
    }

}

