package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.pojo.Job;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;

import java.util.List;

public class JobServiceImpl implements JobService {
    private JobMapper jobMapper = SqlSessionUtil.openSession().getMapper(JobMapper.class);

    public JobServiceImpl(JobMapper jobMapper) {
        this.jobMapper = jobMapper;
    }

    @Override
    public void addJob(String j_id, String j_name, String j_description, Double j_salary, String j_hours) {
        jobMapper.insertJob(new Job());
    }


    @Override
    public void deleteJob(String j_id) {
        jobMapper.deleteById(j_id);
    }

    @Override
    public void updateJob(String j_id,String j_name,String j_description,Double j_salary,String j_hours) {
        jobMapper.updateJob(j_id,j_name,j_description,j_salary,j_hours);
    }

    @Override
    public List<Job> selectById(String j_id) {
        return null;
    }

    @Override
    public List<Job> selectAll(Job job) {
        return null;
    }


}
