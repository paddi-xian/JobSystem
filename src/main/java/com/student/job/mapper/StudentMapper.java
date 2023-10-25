package com.student.job.mapper;

import com.student.job.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStuList();
//    Student findById(String s_id);
    int insertStudent(String s_name,String s_gender,Integer s_age,String s_phone,String s_email,String s_intro);
    int updateStudent(String s_name,String s_gender,Integer s_age,String s_phone,String s_email,String s_intro);

    int insertStudent(Student student);
}
