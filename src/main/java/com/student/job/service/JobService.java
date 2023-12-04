package com.student.job.service;

import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.Record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobService {


    List<Job> selectJobByUid(Integer uId);

    boolean addJob(Job job);

    int deleteJobByJID(Integer jId);

    boolean editJob(Job job);

    List<Job> selectAllJob();

    Job_Publisher SelectJobByJid(Integer jId);

    List<Job> SelectJobByLikeName(Job job);

    List<Job_Publisher> SelectJob_publish();
    int updateStatusByJob(@Param("j_id")Integer jId, @Param("j_status")String j_status);

    int addRecord(Integer jId, Integer uId);

    Job_Publisher isRecord(Integer uId, Integer jId);
}
