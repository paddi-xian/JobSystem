package com.student.job.mapper;

import com.student.job.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 插入用户
     * @param user
     * @return
     */
   int insertUser(User user);

    /**
     * 查询用户id和密码
     * @param u_id
     * @param u_pass
     * @return
     */
    List<User> selectByIdAndPass(String u_id, String u_pass);

    User getUserById(String u_id);
}
