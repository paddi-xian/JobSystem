package com.student.job.mapper;

import com.student.job.pojo.Job;

import java.util.List;

public interface JobMapper {
    int insertJob(Job job);

    int updateJob(String j_id,String j_name,String j_description,Double j_salary,String j_hours);

    int deleteById(String j_id);

    List<Job> selectById(String j_id);

    List<Job> selectAll(Job job);

}
