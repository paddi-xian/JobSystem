package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
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
        if (student.getS_phone() != null || student.getS_email() != null) {
            // 如果电话号码或电子邮件被修改，则同时更新Student和User表
            return updateStudentAndUser(student);
        } else {
            // 如果电话号码和电子邮件都没有被修改，只更新Student表
            return studentMapper.updateStudent(student);
        }
    }

    @Override
    public int updateUser(User user) {
        return studentMapper.updateUser(user);
    }
    private int updateStudentAndUser(Student student) {
        int studentRowsAffected = studentMapper.updateStudent(student);
        int userRowsAffected = studentMapper.updateUser(new User());
        return Math.max(studentRowsAffected, userRowsAffected);
    }
}
