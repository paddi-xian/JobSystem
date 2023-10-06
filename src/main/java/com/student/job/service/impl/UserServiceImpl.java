package com.student.job.service.impl;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import com.student.job.utils.SqlSessionUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
    @Override
    public void register(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public List<User> login(String u_id, String u_pass) {
        return userMapper.selectByIdAndPass(u_id,u_pass);
    }
}
