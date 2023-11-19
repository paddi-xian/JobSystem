package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Job;
import com.student.job.pojo.Student;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
    public Job SelectJobByJid(Integer jId) {
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


}
