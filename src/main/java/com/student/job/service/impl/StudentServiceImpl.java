package com.student.job.service.impl;

import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.service.StudentService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper= SqlSessionUtil.openSession().getMapper(StudentMapper.class);

    private SqlSession session = SqlSessionUtil.openSession();
    @Override
    public List<Student> getStuList() {
        List<Student> students=studentMapper.getStuList();
        return students;
    }
    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

//    @Override
//    public boolean updateStudent(Student student){
//        if (session == null) {
//            SqlSessionUtil.close(session);
//            SqlSession session = SqlSessionUtil.openSession();
//             studentMapper = session.getMapper(StudentMapper.class);
//        }
//        boolean res =studentMapper.updateStudent(student);
//        session.commit();
//        return res;
//    }



}
