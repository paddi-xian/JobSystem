package com.student.job.service;

import com.student.job.pojo.Student;

import javax.servlet.http.HttpSessionBindingEvent;
import java.util.List;

public interface StudentService {
    List<Student> getStuList();

    int addStudent(Student student);

    Student selectStudentByUid(Integer uId);

    int updateStudent(Student student);

    Long selectTotalStudent(HttpSessionBindingEvent event);

}

