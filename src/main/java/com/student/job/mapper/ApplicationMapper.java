package com.student.job.mapper;

import com.student.job.pojo.Application;
import com.student.job.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApplicationMapper {
    int addApplication(Application application);
    int checkDuplicate(@Param("u_id")Integer u_id,@Param("j_id")Integer j_id);
//    int checkStudentExists(@Param("u_id") String u_id);
//        int checkDuplicate(u_id,j_id);
    List<Application> getApplicationList();

    List<Integer> getJobIdsByUserId(Integer u_id);



}
