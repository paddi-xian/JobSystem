package com.student.job.service;

import com.student.job.pojo.Job;

import java.util.List;

public interface JobService {


    List<Job> selectJobByUid(Integer uId);

    boolean addJob(Job job);

    int deleteJobByJID(Integer jId);

    boolean editJob(Job job);

    List<Job> selectAllJob();

    Job SelectJobByJid(Integer jId);

    List<Job> SelectJobByLikeName(Job job);

    List<Job> SelectJob_user();
}
