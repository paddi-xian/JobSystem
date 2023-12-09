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

    boolean editJob(Job_Publisher job);

    List<Job> selectAllJob();

    Job_Publisher SelectJobByJid(Integer jId);

    List<Job_Publisher> SelectJobByLikeName(String str,Integer uId);

    List<Job_Publisher> SelectJob_publish();
    int updateStatusByJob(@Param("j_id")Integer jId, @Param("j_status")String j_status);

    int addRecord(Integer jId, Integer uId);

    Job_Publisher isRecord(Integer uId, Integer jId);

    List<Job_Publisher> selectRecord(Integer uId);

    int removeRecord(Integer uId, Integer jId);

//    selectJobByStuUid
    List<Job> selectJobByStuUid(Integer uId);
}
