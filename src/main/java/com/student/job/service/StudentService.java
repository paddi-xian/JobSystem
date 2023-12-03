package com.student.job.service;

import com.student.job.pojo.Resume;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;

import javax.servlet.http.HttpSessionBindingEvent;
import java.util.List;

public interface StudentService {
    List<Student> getStuList();

    int addStudent(Student student);

    Student selectStudentByUid(Integer uId);

    int updateStudent(Student student);
    int updateUser(User user);

    Long selectTotalStudent(HttpSessionBindingEvent event);

}

