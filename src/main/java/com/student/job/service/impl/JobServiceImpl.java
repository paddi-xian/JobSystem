package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.Record;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class JobServiceImpl implements JobService {
    //打开SqlSession，创建会话
    private SqlSession session = SqlSessionUtil.openSession();
    //获取JobMapper的代理对象
    private JobMapper jobMapper = session.getMapper(JobMapper.class);

    @Override
    public List<Job> selectJobByUid(Integer uId) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        List<Job> jobs = jobMapper.selectJobByUid(uId);
        return jobs;
    }

    @Override
    public boolean addJob(Job job) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        boolean res =  jobMapper.addJob(job);
        session.commit();
        return res;
    }

    @Override
    public int deleteJobByJID(Integer jId) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        int i = jobMapper.deleteJobByJID(jId);
        session.commit();
        return i;
    }

    @Override
    public boolean editJob(Job job) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        boolean res =  jobMapper.editJob(job);
        session.commit();
        return res;
    }


    @Override
    public List<Job> selectAllJob() {
        SqlSessionUtil.close(session);
        session = SqlSessionUtil.openSession();
        jobMapper = session.getMapper(JobMapper.class);
        List<Job> AllJob=jobMapper.selectAllJob();
        return AllJob;
    }

    @Override
    public Job_Publisher SelectJobByJid(Integer jId) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        return jobMapper.SelectJobByJid(jId);
    }

    @Override
    public List<Job> SelectJobByLikeName(Job job) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        return jobMapper.SelectJobByLikeName(job);
    }

    @Override
    public List<Job_Publisher> SelectJob_publish() {
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        return jobMapper.SelectJob_publish();
    }

    @Override
    public int addRecord(Integer jId, Integer uId) {
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        int i = jobMapper.AddRecord(jId,uId);
        session.commit();
        return i;
    }

    @Override
    public Job_Publisher isRecord(Integer jId, Integer uId) {
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        List<Integer> jids = jobMapper.selectjids(jId);
        return jobMapper.isRecord(jids,jId,uId);
    }


}
