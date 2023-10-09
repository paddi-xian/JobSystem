package com.student.job.mapper;

import com.student.job.pojo.Job;

public interface JobMapper {
    public int insertJob(Job job);

    public int update(Job job);

}
