package com.student.job.service.impl;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
    @Override
    public void register(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User login(String telephone, String u_pass) {
        return userMapper.selectByTelAndPass(telephone,u_pass);
    }

/*    @Override
    public boolean checkTelephoneExits(String telephone) {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            return userMapper.checkTelephoneExits(telephone);
        }
    }*/
}
