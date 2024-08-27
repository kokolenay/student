package com.cqu.student.controller;

import com.cqu.student.pojo.Student;
import com.cqu.student.service.StudentClassService;
import com.cqu.student.service.StudentService;
import com.cqu.student.utils.ParamsPojo;
import com.cqu.student.utils.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("user")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentClassService studentClassService;

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

    @GetMapping("/countGender")
    public R countGender() {
        List<Map<String, Object>> count = studentService.countGender();
        return !count.isEmpty()? R.success(count) :R.fail("操作失败");
    }

    /*查询学生*/
    @PostMapping("/findStudent")
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

    @DeleteMapping("/stuDelete")
    public R stuDelete(@RequestBody ParamsPojo paramsPojo) {
        HashMap maps=paramsPojo.getMaps();
        int stuId= (int) maps.get("stuId");
        boolean isDeleted = studentService.stuDelete(stuId);
        return isDeleted ?R.success(true):R.fail("手机号或密码错误");

    }

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

    @RequestMapping("/classSuccess")
    public R classSuccess(@RequestBody ParamsPojo paramsPojo) {
        HashMap maps=paramsPojo.getMaps();
        int stuId= (int) maps.get("stuId");
        int classId= (int) maps.get("classId");

        int stu= studentClassService.classIfSuccess(stuId, classId);
        return stu >0 ? R.success(stu):R.fail("操作失败");
    }

    @GetMapping("/studentPage")
    public R studentPage(Integer currentPage, Integer pageSize) {
        Page page = studentService.findAllStudents(currentPage, pageSize);
        PageInfo info = new PageInfo<>(page);
        return info!=null ?R.success(info):R.fail("操作失败");
    }

    @PostMapping("/getStudentByPhone")
    public R getStudentByPhone(@RequestBody Student student) {
        int res = studentService.getStudentByPhone(student);
        return res>=0?R.success(res):R.fail("操作失败");
    }
}
