package com.student.job.test;

import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.utils.SqlSessionUtil;
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
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            // 加载配置文件
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 创建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 获取SqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 执行数据库操作
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            // 调用StudentMapper的查找方法
            List<Student> students = studentMapper.getStuList();
            // 将结果转换为数组并输出
            Student[] studentArray = students.toArray(new Student[students.size()]);

            System.out.println(Arrays.toString(studentArray));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
