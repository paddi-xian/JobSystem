package com.student.job.test;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1001,"张松","123","13456278901","1111.qq.com","发布者");
        int count = mapper.insertUser(user);
        System.out.println("插入"+count);
        sqlSession.commit();
        sqlSession.close();
    }

//    @Test
//    public void testSelectByNameAndPass(){
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        User user = mapper.selectByNameAndPass("张三","123");
//        System.out.println(user);
//        sqlSession.close();
//    }

    @Test
    public void testSelectAllUser(){
        UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
        List<User> user = userMapper.selectAllUser();
        System.out.println(user);
    }

    @Test
    public void testSelectByTelAndPass(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByTelAndPass("13456876598","12345");
        System.out.println(user);
        sqlSession.close();
    }
}
