package com.student.job.mapper;

import com.student.job.pojo.User;
import org.apache.ibatis.annotations.Param;

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
     * @param u_name
     * @param u_pass
     * @return
     */
    User selectByNameAndPass(@Param("u_name") String u_name, @Param("u_pass") String u_pass);

    User selectByTelAndPass(@Param("telephone") String telephone, @Param("u_pass") String u_pass);
    User getUserByName(String u_name);

    List<User> selectAllUser();
}
