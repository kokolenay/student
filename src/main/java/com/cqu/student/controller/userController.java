package com.cqu.student.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.cqu.student.pojo.Student;
import com.cqu.student.pojo.User;
import com.cqu.student.service.UserService;
import com.cqu.student.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("user")
public class userController {

    private LineCaptcha lineCaptcha;

    @GetMapping("/api/captcha")
    //后台管理系统的登录接口
    //在LoginController类中能够定义生成验证码的方法
    public void  captcha(HttpServletResponse response){
        //定义图形验证码的长和宽
        lineCaptcha  = CaptchaUtil.createLineCaptcha(125, 45);
        //设置验证码的背景颜色
        lineCaptcha.setBackground(new Color(181,238,218));

        //通过流写出数据到浏览器
        try{
            ServletOutputStream os = response.getOutputStream();
            lineCaptcha.write(os);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Autowired
    private UserService userService;

    @PostMapping("userLogin")
    public R assignDormitory(@RequestBody Map<String,String> map){
        boolean check =  lineCaptcha.verify(map.get("code"));
        if(check){
            User user =  userService.userLogin(map.get("username"),map.get("password"));
            return user!=null? R.success(user):R.err(1001,"用户名或者密码错误");
        }else{
            return R.err(1001,"验证码错误");
        }
    }

    @PostMapping("/updateUser")
    public R updateUser(@RequestBody User user) {
        int res = userService.updateUser(user);
        return res>0? R.success(res) :R.fail("操作失败");
    }

    @PostMapping("/insertUser")
    public R insertUser(@RequestBody User user) {
        int res = userService.insertUser(user);
        return res>0? R.success(res) :R.fail("操作失败");
    }
}
