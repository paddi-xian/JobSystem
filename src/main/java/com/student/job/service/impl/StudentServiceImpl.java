package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.service.StudentService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper= SqlSessionUtil.openSession().getMapper(StudentMapper.class);

    @Override
    public List<Student> getStuList() {
        List<Student> students=studentMapper.getStuList();
        return students;
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public boolean updateStudent(Student student){
        SqlSession session = SqlSessionUtil.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        boolean res =studentMapper.updateStudent(student);
        session.commit();
        return res;
    }

    @Override
    public Student selectStudentByUid(Integer uId) {
        Student student = studentMapper.selectStudentByUid(uId);
        return student;
    }


}
