package com.student.job.service;

import com.student.job.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void register(User user);

    /**
     * 登录用户
     * @param u_id
     * @param u_pass
     * @return
     */
    public List<User> login(String u_id, String u_pass);
}