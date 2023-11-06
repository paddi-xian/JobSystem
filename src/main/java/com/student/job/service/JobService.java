package com.student.job.service;

import com.student.job.pojo.Job;

import java.util.List;

public interface JobService {


    List<Job> selectJobByUid(Integer uId);

    boolean addJob(Job job);

    int deleteJobByJID(Integer jId);

//    int JobTotal(Integer uId);

    List<Job> selectAllJob();
}
