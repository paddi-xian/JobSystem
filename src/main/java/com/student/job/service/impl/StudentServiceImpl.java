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
        List<Student> students=studentMapper.getStuList();
        return students;
    }



    @Override
    public int updateStudent(String s_name,String s_gender,Integer s_age,String s_phone,String s_email,String s_intro) {
        return studentMapper.updateStudent( s_name, s_gender, s_age, s_phone, s_email, s_intro);
    }


}
