package com.student.job.mapper;

import com.student.job.pojo.Job;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> getStuList();
    Student selectStudentByUid(@Param("u_id") Integer uId);
    int addStudent(Student student);

    Long selectTotalStudent();
    List<Student> selectStudentByName(@Param("s_name") String sName);

    int updateStudent(Student student);
    int updateUser(User user);
//    boolean checkU_idExits(@Param("u_id") Integer u_id);


    int checkStudentExists(@Param("u_id") String u_id);
//    Student getStudentByUid(String u_id);

}
