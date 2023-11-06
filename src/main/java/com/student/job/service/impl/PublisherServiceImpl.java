package com.student.job.service.impl;
import com.student.job.pojo.Publisher;
import com.student.job.service.PublisherService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    private SqlSessionFactory sqlSessionFactory;

    public PublisherServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Publisher getPublisherById(int p_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            return sqlSession.selectOne("com.student.job.mapper.PublisherMapper.selectPublisherById", p_id);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void insertPublisher(Publisher publisher) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("com.student.job.mapper.PublisherMapper.insertPublisher", publisher);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("com.student.job.mapper.PublisherMapper.updatePublisher", publisher);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void deletePublisher(int p_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("com.example.mapper.PublisherMapper.deletePublisher", p_id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
