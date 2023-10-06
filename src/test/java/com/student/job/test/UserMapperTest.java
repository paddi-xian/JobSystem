package com.student.job.test;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("1004","张松","123","发布者","1234");
        int count = mapper.insertUser(user);
        System.out.println("插入"+count);
        sqlSession.commit();
        sqlSession.close();
    }
}
