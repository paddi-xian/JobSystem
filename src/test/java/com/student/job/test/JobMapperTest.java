package com.student.job.test;

import com.student.job.mapper.JobMapper;
import com.student.job.pojo.Job;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class JobMapperTest {
    @Test
    public void testInsertJob(){
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        JobMapper mapper = sqlSession.getMapper(JobMapper.class);
//        Job job = new Job(null,"架构师","主要干xxxx",12000.00,"6小时",null);
//        int count = mapper.insertJob(job);
//        System.out.println("插入"+count);
//        sqlSession.commit();
//        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
//        SqlSession sqlSession = SqlSessionUtil.openSession();
//        JobMapper mapper = sqlSession.getMapper(JobMapper.class);
//        List<Job> jobs = mapper.selectAll(new Job());
//        jobs.forEach(car -> System.out.println(jobs));
//        sqlSession.close();
    }
    @Test
    public void testSelectJobByUid(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        JobMapper mapper = sqlSession.getMapper(JobMapper.class);
        List<Job> jobs = mapper.selectJobByUid(2);
        jobs.forEach(car -> System.out.println(jobs));
        sqlSession.close();
    }

}
