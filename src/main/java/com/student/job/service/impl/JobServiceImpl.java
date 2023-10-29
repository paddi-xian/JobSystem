package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Job;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class JobServiceImpl implements JobService {
//    private SqlSession session = SqlSessionUtil.openSession();
//    private JobMapper jobMapper = session.getMapper(JobMapper.class);

    @Override
    public List<Job> selectJobByUid(Integer uId) {
        SqlSession session = SqlSessionUtil.openSession();
        JobMapper jobMapper = session.getMapper(JobMapper.class);
        List<Job> jobs = jobMapper.selectJobByUid(uId);
        return jobs;
    }

    @Override
    public boolean addJob(Job job) {
        SqlSession session = SqlSessionUtil.openSession();
        JobMapper jobMapper = session.getMapper(JobMapper.class);
        return jobMapper.addJob(job);
    }

    @Override
    public int deleteJobByJID(Integer jId) {
        SqlSession session = SqlSessionUtil.openSession();
        JobMapper jobMapper = session.getMapper(JobMapper.class);
        int i = jobMapper.deleteJobByJID(jId);
        session.commit();
        return i;
    }


}
