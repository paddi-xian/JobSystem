package com.student.job.service.impl;

import com.student.job.mapper.ApplicationMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Application;
import com.student.job.service.ApplicationService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class ApplicationServiceImpl implements ApplicationService {
    private SqlSession session = SqlSessionUtil.openSession();
    private ApplicationMapper applicationMapper=session.getMapper(ApplicationMapper.class);
    @Override
    public int addApplication(Application application) {
       return applicationMapper.addApplication(application);
    }
}
