package com.student.job.mapper;

import com.student.job.pojo.Job;

import java.util.List;

public interface JobMapper {
    int insertJob(Job job);

    int update(Job job);

    int delete(Job job);

    List<Job> selectById(String j_id);

    List<Job> selectAll(Job job);

}
