package com.student.job.mapper;

import com.student.job.pojo.Job;
import com.student.job.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> getStuList();
//    Student findById(String u_id);
    List<Student>selectStudentByUid(@Param("u_id") Integer uId);
    boolean addStudent(Student student);
//    List<Job> selectJobByUid(@Param("u_id") Integer uId);
}
