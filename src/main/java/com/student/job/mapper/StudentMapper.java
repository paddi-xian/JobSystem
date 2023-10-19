package com.student.job.mapper;

import com.student.job.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStuList();
    Student findById(String s_id);

}
