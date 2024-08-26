package com.cqu.student.controller;

import com.cqu.student.pojo.Classes;
import com.cqu.student.service.ClassesService;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*接受请求，调用业务层接口*/
@RestController
@CrossOrigin
@RequestMapping("user")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

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
}
