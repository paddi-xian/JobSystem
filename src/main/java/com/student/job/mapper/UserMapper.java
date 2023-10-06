package com.student.job.mapper;

import com.student.job.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 插入用户
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 查询用户id和密码
     * @param u_id
     * @param u_pass
     * @return
     */
    public List<User> selectByIdAndPass(String u_id, String u_pass);

    public User getUserById(String u_id);
}
