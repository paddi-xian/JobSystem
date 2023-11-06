package com.student.job.test;

import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.mapper.UserMapper;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentMapperTest {
    @Test
    public  void testSelectStudentByUid() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student=mapper.selectStudentByUid(1002);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void testAddStudent(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(2021103,"敖嗷嗷","男",20,"14356789076","zs@qq.com","我是嗷嗷",1005);
        int count = mapper.addStudent(student);
        System.out.println("插入"+count);
        sqlSession.commit();
        sqlSession.close();
    }

}
