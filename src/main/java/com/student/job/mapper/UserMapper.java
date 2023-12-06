package com.student.job.mapper;

import com.student.job.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 插入用户
     * @param user
     * @return
     */
   int insertUser(User user);

    User selectById(@Param("u_id") Integer u_id);
    User selectByTelAndPass(@Param("telephone") String telephone, @Param("u_pass") String u_pass);
    User getUserByName(String u_name);

    List<User> selectAllUser();
    User selectByTelephone(@Param("telephone") String telephone);

    boolean checkTelephoneExits(@Param("telephone") String telephone);

    int updatePwd(@Param("u_id") Integer u_id,@Param("new_pass") String u_pass);

    User checkPwd(@Param("u_id") Integer u_id,@Param("old_pass") String u_pass);

    int resetPass(@Param("email")String email,@Param("newPass") String u_pass);

     @Select("select * from user where email = #{email}")
     User isHasEmail(String email);
}
