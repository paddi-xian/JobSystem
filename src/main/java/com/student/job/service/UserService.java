package com.student.job.service;

import com.student.job.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void register(User user);

    /**
     * 登录用户
     * @param telephone
     * @param u_pass
     * @return
     */
    public User login(String telephone, String u_pass);
    int updatePwd(@Param("u_id") Integer u_id,@Param("u_pass") String u_pass);

    Boolean isHasEmail(String email);
    void resetPass(String email, String newPass);

}
