package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.Record;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobServiceImpl implements JobService {
    //打开SqlSession，创建会话
    private SqlSession session = SqlSessionUtil.openSession();
    //获取JobMapper的代理对象
    private JobMapper jobMapper = session.getMapper(JobMapper.class);
    @Override
    public int updateStatusByJob(Integer j_id, String j_status) {
        // 创建一个Map来保存参数值
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("j_id", j_id);
        parameterMap.put("j_status", j_status);

        // 执行更新操作
        int result = session.update("JobMapper.updateStatusByJob", parameterMap);
        return 1;
    }
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
    public boolean editJob(Job_Publisher job) {
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
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        return jobMapper.selectAllJob();
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
    public List<Job_Publisher> SelectJobByLikeName(String str,Integer uId) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        return jobMapper.SelectJobByLikeName(str,uId);
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
    public Job_Publisher isRecord(Integer uId,Integer jId) {
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        System.out.println("jid="+jId+"---uid="+uId);
        return jobMapper.isRecord(uId,jId);
    }

    @Override
    public List<Job_Publisher> selectRecord(Integer uId) {
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        List<Job_Publisher>records = jobMapper.selectRecord(uId);
        return records;
    }

    @Override
    public int removeRecord(Integer uId, Integer jId) {
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        int i = jobMapper.removeRecord(uId, jId);
        session.commit();
        return i;
    }

    @Override
    public List<Job> selectJobByStuUid(Integer uId) {
        if(session != null){
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            jobMapper = session.getMapper(JobMapper.class);
        }
        List<Job>Jobs = jobMapper.selectJobByStuUid(uId);
        return Jobs;
    }


}
