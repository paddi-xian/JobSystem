package com.student.job.service.impl;

import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Job;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class JobServiceImpl implements JobService {
    private JobMapper jobMapper = SqlSessionUtil.openSession().getMapper(JobMapper.class);
    @Override
    public List<Job> selectJobByUid(Integer uId) {
         return jobMapper.selectJobByUid(uId);
    }


}
