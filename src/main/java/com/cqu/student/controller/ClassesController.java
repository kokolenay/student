package com.cqu.student.controller;

import com.cqu.student.mapper.StudentClassMapper;
import com.cqu.student.pojo.Classes;
import com.cqu.student.pojo.Notice;
import com.cqu.student.pojo.Student;
import com.cqu.student.pojo.StudentClass;
import com.cqu.student.service.ClassesService;
import com.cqu.student.service.StudentClassService;
import com.cqu.student.utils.ParamsPojo;
import com.cqu.student.utils.R;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/*接受请求，调用业务层接口*/
@RestController
@CrossOrigin
@RequestMapping("user")
public class ClassesController {

    @Autowired
    private ClassesService classesService;
    @Autowired
    private StudentClassService studentClassService;

    @PostMapping("/findClasses")
    public R findClasses(@RequestBody Classes clazz) {
        List<Classes> classes = classesService.findClasses(clazz);
        return !classes.isEmpty() ? R.success(classes) : R.fail("没有找到符合条件的课程");
    }

    @GetMapping("/getAllClasses")
    public R getAllClasses() {
        List<Classes> classes = classesService.getAllClasses();
        return !classes.isEmpty() ? R.success(classes) : R.fail("没有找到符合条件的课程");
    }
    @GetMapping({"/ifChosen/{stuId}"})
    public R ifChosen(@PathVariable Integer stuId) {
        List<Integer> ifChosen = this.studentClassService.ifChosen(stuId);
        return !ifChosen.isEmpty() ? R.success(ifChosen) : R.fail("没有已选择的课程");
    }

    @PostMapping("/insertClass")
    public R addNotice(@RequestBody Classes classes){

        int row=classesService.insertClass(classes);
        return row >0?R.success(row):R.fail("操作失败");
    }

    @PutMapping("/updateClass")
    public R updateNotice(@RequestBody Classes classes) {

        int row = classesService.updateClass(classes);
        return row > 0 ? R.success(row) : R.fail("操作失败");
    }

    @DeleteMapping("/deleteClass/{id}")
    public R deleteNotice(@PathVariable Integer id) {
        int row = classesService.deleteClass(id);
        System.out.println(row);
        return row > 0 ? R.success(row) : R.fail("操作失败");
    }

    @GetMapping("/classesPage")
    public R queryAll(Integer currentPage, Integer pageSize) {
        Page page = classesService.queryAll(currentPage, pageSize);
        PageInfo info = new PageInfo<>(page);
        return info!=null ?R.success(info):R.fail("操作失败");
    }
}
