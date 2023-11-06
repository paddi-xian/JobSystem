package com.student.job.test;

import com.student.job.mapper.PublisherMapper;
import com.student.job.mapper.UserMapper;
import com.student.job.pojo.Publisher;
import com.student.job.pojo.User;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PublisherMapperTest {

        @Test
        //查询所有 测试
        public void testSelectAllPublisher(){
            PublisherMapper publisherMapper = SqlSessionUtil.openSession().getMapper(PublisherMapper.class);
            List<Publisher> publisher = publisherMapper.getAllPublishers();
            System.out.println(publisher);
        }
        @Test
        //用id查询
        public void testGetPublisherById() {
            PublisherMapper publisherMapper = SqlSessionUtil.openSession().getMapper(PublisherMapper.class);
           Publisher publisher = publisherMapper.getPublisherById(22);
            System.out.println(publisher);
            }

     @Test
    //插入测试
    public void testInsertPublisher(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        PublisherMapper mapper = sqlSession.getMapper(PublisherMapper.class);
        Publisher publisher = new Publisher(1999,"李四","123","415","1234","hh");
        int count = mapper.insertPublisher(publisher);
        System.out.println("插入"+count);
        sqlSession.commit();
        sqlSession.close();
    }

//    @Test
//    //删除测试
//    public void testDeletePublisherById() {
//        PublisherMapper publisherMapper = SqlSessionUtil.openSession().getMapper(PublisherMapper.class);
//        Publisher publisher = new Publisher(20,"ds","sfs",415,"666","sdf");
//        int count = publisherMapper.insertPublisher(publisher);
//        System.out.println("插入"+count);
//        assertEquals("1", publisherMapper.getPublisherById(20));
//        publisherMapper.deletePublisherById(20);
//        assertNull(publisherMapper.getPublisherById(20));
//
//    }

}
