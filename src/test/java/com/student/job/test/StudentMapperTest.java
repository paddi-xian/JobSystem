package com.student.job.test;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.utils.SqlSessionUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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

    @Test
    public void testSelectTotalStudent(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Long total = mapper.selectTotalStudent();
        System.out.println("总记录条数："+total);
        sqlSession.close();
    }

    @Test
    public  void testUpdateStudent(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(2021101,"敖丽丽","女",19,"14356789076","alii@qq.com","我是张丽丽",1005);
        int count = mapper.updateStudent(student);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testCheckStudentUid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = mapper.getStudentByUid("1017");
        System.out.println(mapper.checkU_idExits("1017"));
        sqlSession.close();
    }
}
