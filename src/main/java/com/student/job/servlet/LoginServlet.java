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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户提交的登录信息
        String u_name = request.getParameter("u_name");
        String u_pass = request.getParameter("u_pass");

        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
//        List<User> users = new ArrayList<>();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // 调用 mapper 方法查询用户信息
            List<User> users  = userMapper.selectByNameAndPass(u_name, u_pass);

            if (users.isEmpty()) {
                // 如果没有找到用户或用户名或密码错误，则重定向到错误页面
                response.sendRedirect("error.jsp");
            } else {
                // 获取用户的角色类型
                String role = users.get(0).getRole();

                if ("系统管理员".equals(role)) {
                    // 如果用户角色是管理员，则重定向到管理员页面
                    response.sendRedirect("index.jsp");
                } else if ("发布者".equals(role)) {
                    // 如果用户角色是普通用户，则重定向到用户页面
                    response.sendRedirect("publisher.jsp");
                } else if ("学生".equals(role)) {
                    // 如果用户角色是普通用户，则重定向到用户页面
                    response.sendRedirect("student.jsp");
                }
                else {
                    // 如果角色类型未知，则重定向到错误页面
                    response.sendRedirect("error.jsp");
                }


                //根据用户类型跳转到相应页面
                response.sendRedirect("index.jsp");
            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
