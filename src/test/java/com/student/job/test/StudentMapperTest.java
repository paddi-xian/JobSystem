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
//            List<Student> students = studentMapper.getStuList();
//            // 将结果转换为数组并输出
//            Student[] studentArray = students.toArray(new Student[students.size()]);
//            System.out.println(Arrays.toString(studentArray));
            //调用StudentMapper的插入方法
            Student student = new Student();
//            student.setS_id(null);
            student.setS_name("amy");
            student.setS_gender("女");
            student.setS_age(10);
            student.setS_phone("18888");
            student.setS_email("15555@");
            student.setS_intro("我是一个大傻瓜");
            int result = studentMapper.insertStudent(student);
            sqlSession.commit();
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
