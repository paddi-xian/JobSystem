package com.student.job.servlet;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取用户提交的注册信息
        String u_id = request.getParameter("u_id");
        String u_name = request.getParameter("u_name");
        String u_pass = request.getParameter("u_pass");
        String telephone = request.getParameter("telephone");
        String role = request.getParameter("role");

        //创建用户对象
        User user = new User();
        user.setU_id(u_id);
        user.setU_name(u_name);
        user.setU_pass(u_pass);
        user.setTelephone(telephone);
        user.setRole(role);

        //调用Mybatis的Mapper接口插入用户数据
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.insertUser(user);
            session.commit();
        }
        //注册成功后跳转到登陆页面
        response.sendRedirect("login.jsp");
    }
}
