package com.student.job.service.impl;

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
        return studentMapper.getStuList();
    }
}
