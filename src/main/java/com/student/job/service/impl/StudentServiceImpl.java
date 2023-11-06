package com.student.job.service.impl;

import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.service.StudentService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private SqlSession session = SqlSessionUtil.openSession();
    private StudentMapper studentMapper= SqlSessionUtil.openSession().getMapper(StudentMapper.class);

    @Override
    public List<Student> getStuList() {
        List<Student> students=studentMapper.getStuList();
        return students;
    }

    @Override
    public boolean addStudent(Student student) {
        SqlSession session = SqlSessionUtil.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        boolean res =  studentMapper.addStudent(student);
        session.commit();
        return res;
    }

    @Override
    public Student selectStudentByUid(Integer uId) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            studentMapper =session.getMapper(StudentMapper.class);
        }
       Student student=studentMapper.selectStudentByUid(uId);
        return student;
    }


}
