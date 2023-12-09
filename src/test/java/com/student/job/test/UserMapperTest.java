package com.student.job.test;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void testUpdatePwd(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updatePwd(1035, "1234");
        System.out.println(i);
        sqlSession.commit();
    }

    @Test
    public void testCheckPwd(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkPwd(1035, "40bd001563085fc35165329ea1ff5c5ecbdbbeef");
        System.out.println(user);
        sqlSession.commit();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //用例1
        User user1 = new User(null,"小松当嘉","123","13456278901","1111.qq.com","发布者");
        int count = mapper.insertUser(user1);
        System.out.println("插入"+count);
        assertEquals(1,count);
        sqlSession.commit();
        //用例2
        User user2 = new User(1015,"AAA","123","13456278901","1111.qq.com","学生");
        int count1 = mapper.insertUser(user2);
        sqlSession.commit();
        // 验证插入的数据是否正确
        User dbUser = mapper.selectById(1015); // 假设你有一个通过ID获取用户的方法
        assertNotNull(dbUser);
        //assertEquals(user2.getU_name(), dbUser.getU_name()); // 验证u_name是否匹配
        sqlSession.close();
    }


    @Test
    public void testSelectAllUser(){
        UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
        List<User> user = userMapper.selectAllUser();
        System.out.println(user);
    }

    @Test
    public void testSelectByTelAndPass(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //用例1
        String telephone = "18934567653";
        String u_pass = "40bd001563085fc35165329ea1ff5c5ecbdbbeef";
        User user = mapper.selectByTelAndPass(telephone, u_pass);
        assertNotNull(user);
        assertEquals(telephone, user.getTelephone());
        assertEquals(u_pass, user.getU_pass());
        //User user = mapper.selectByTelAndPass("14567856790","8cb2237d0679ca88db6464eac60da96345513964");
        System.out.println("用例1查询到的用户是"+user.getU_name()+user.getTelephone());

        //用例2
//        String telephone2 = "18934567653";
//        String u_pass2 = "1111";
//        User user2 = mapper.selectByTelAndPass(telephone2, u_pass2);
//        assertNotNull(user);
//        assertEquals(telephone2, user.getTelephone());
//        assertEquals(u_pass2, user.getU_pass());
//        System.out.println("查询到的用户是"+user.getU_name()+user.getTelephone());
//        sqlSession.close();
    }

    @Test
    public void testResetPass(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //用例1
        int result = mapper.resetPass("13546789032@11", "1234");
        System.out.println("用例1结果"+result+"重置成功");
        sqlSession.commit();
        assertEquals(1, result);
        //用例2
        int result2 = mapper.resetPass("12345@11", "1111");
        sqlSession.commit();
        System.out.println("用例2结果"+result2+"重置失败");
        assertEquals(0, result2);
        sqlSession.close();
    }


}
