package com.student.job.service.impl;

import com.student.job.mapper.StudentMapper;
import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private SqlSession session = SqlSessionUtil.openSession();
    private UserMapper userMapper = session.getMapper(UserMapper.class);

    //    private UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
    @Override
    public void register(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User login(String telephone, String u_pass) {
        return userMapper.selectByTelAndPass(telephone, u_pass);
    }

    @Override
    public User checkPwd(Integer u_id, String u_pass) {
        return userMapper.checkPwd(u_id, u_pass);
    }


    @Override
    public boolean changPwd(Integer u_id, String old_pass, String new_pass) {
        User user = checkPwd(u_id, old_pass);
        if (user != null && old_pass.equals(user.getU_pass())) {
            String sha1NewPass = null;
            try {
                sha1NewPass = getSHA1Hash(new_pass);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            userMapper.updatePwd(sha1NewPass);
            return true;
        }
        return false;
    }

    @Override
    public Boolean isHasEmail(String email) {
        if (session != null) {
            SqlSessionUtil.close(session);
            session = SqlSessionUtil.openSession();
            userMapper = session.getMapper(UserMapper.class);
        }
        User user = userMapper.isHasEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    private String getSHA1Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return bytesToHex(digest); // 将字节数组转换为十六进制字符串
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
/*    @Override
    public boolean checkTelephoneExits(String telephone) {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            return userMapper.checkTelephoneExits(telephone);
        }
    }*/
}
