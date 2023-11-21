package com.student.job.controller;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PasswordController {
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/resetPass")
    public void resetPass(String telephone,String newPass){
        //根据手机号查用户信息
        User user = userMapper.selectByTelephone(telephone);
        if(user != null){
            userMapper.resetPass(telephone,newPass);
        }
    }
}
