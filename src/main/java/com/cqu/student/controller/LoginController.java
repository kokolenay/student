package com.cqu.student.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
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

    //账户激活
    @PostMapping("/register")
    public R register(@RequestBody Student student) throws  Exception{
        int register=studentService.register(student);
        return register>0? R.success(register) :R.fail("操作失败");
    }

    @RequestMapping("/login")
    public R login(@RequestBody  Student student)throws  Exception {
        String phone=student.getPhone();
        String password=student.getPassword();
        Student login = studentService.login(phone, password);
        return login!=null?R.success(login):R.fail("手机号或密码错误");

    }

}

