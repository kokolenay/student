package com.cqu.student.controller;

import com.cqu.student.pojo.EmailRequest;
import com.cqu.student.pojo.Student;
import com.cqu.student.service.StudentService;
import com.cqu.student.utils.MailUtils;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.*;

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
        Student login = studentService.login(student);
        return login!=null?R.success(login):R.fail("手机号或密码错误");

    }

    @PostMapping("email")
    public R email(@RequestBody EmailRequest emailRequest) throws Exception {

        Set<String> set = emailRequest.getEmails();
        boolean res = MailUtils.sendEmail(set, emailRequest.getTitle(), emailRequest.getContent());
//        System.out.println(res);
        return res ? R.success("发送邮件成功") : R.fail("发送邮件失败");
    }

}

