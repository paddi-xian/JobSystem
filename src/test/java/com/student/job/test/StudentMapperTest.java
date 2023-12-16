package com.student.job.test;
import com.student.job.mapper.ApplicationMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Application;
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
        Application application = new Application();
//        application.setA_id(null);
        application.setU_id(101);
        application.setJ_id(1);
//        application.setA_time(null);
        application.setA_status("101");
        System.out.println(application);
        ApplicationMapper mapper= sqlSession.getMapper(ApplicationMapper.class);
        mapper.addApplication(application);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void testUpdateStudent(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    }

}
