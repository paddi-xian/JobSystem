package com.student.job.service;

import com.student.job.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStuList();

    int addStudent(Student student);

    Student selectStudentByUid(Integer uId);

    boolean updateStudent(Student student);

}

