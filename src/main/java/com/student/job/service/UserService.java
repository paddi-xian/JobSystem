package com.student.job.service;

import com.student.job.pojo.User;
import org.apache.ibatis.annotations.Param;

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

    //public boolean checkTelephoneExits(@Param("telephone") String telephone);
    User checkPwd(@Param("u_id") Integer u_id,@Param("u_pass") String u_pass);

    /**
     * 修改密码
     * @param u_id
     * @param old_pass
     * @param new_pass
     * @return
     */
    public boolean changPwd(@Param("u_id") Integer u_id,@Param("old_pass") String old_pass,@Param("new_pass") String new_pass);

    Boolean isHasEmail(String email);
}
