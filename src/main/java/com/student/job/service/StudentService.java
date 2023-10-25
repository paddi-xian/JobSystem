package com.student.job.service;

import com.student.job.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStuList();
    int updateStudent(String s_name,String s_gender,Integer s_age,String s_phone,String s_email,String s_intro);
}

