package com.student.job.service;

import com.student.job.pojo.Job;

import java.util.List;

public interface JobService {


    List<Job> selectJobByUid(Integer uId);

}
