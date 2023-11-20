package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.service.StudentService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private SqlSession session = SqlSessionUtil.openSession();
    private StudentMapper studentMapper= session.getMapper(StudentMapper.class);

    @Override
    public List<Student> getStuList() {
        List<Student> students=studentMapper.getStuList();
        return students;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

//    public boolean updateStudent(Student student){
//        SqlSession session = SqlSessionUtil.openSession();
//        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
//        boolean res =studentMapper.updateStudent(student);
//        session.commit();
//        return res;
//    }

    @Override
    public Long selectTotalStudent(HttpSessionBindingEvent event) {
        ServletContext application = event.getSession().getServletContext();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Long totalStudent = studentMapper.selectTotalStudent();
        System.out.println("总记录条数："+totalStudent);
        session.commit();
        session.close();
        return totalStudent;
    }

    @Override
    public Student selectStudentByUid(Integer uId) {
        Student student = studentMapper.selectStudentByUid(uId);
        return student;
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
}
