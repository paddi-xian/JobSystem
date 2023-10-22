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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取用户提交的登录信息
        //String u_name = request.getParameter("u_name");
        String telephone = request.getParameter("telephone");
        String u_pass = request.getParameter("u_pass");
        System.out.println(telephone+"+++++"+u_pass);


        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectByTelAndPass(telephone,u_pass);
            if (user == null) {
                // 如果没有找到用户或用户名或密码错误，则重定向到错误页面
                System.out.println("登陆失败");
                request.getRequestDispatcher("error.jsp").forward(request,response);
            } else {
                // 获取用户的角色类型
                String role = user.getRole();
                if ("系统管理员".equals(role)) {
                    // 如果用户角色是管理员，则重定向到管理员页面
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                } else if ("发布者".equals(role)) {
                    // 如果用户角色是发布者，则重定向到发布者页面
                    request.getSession().setAttribute("u_name",user);
                    request.getRequestDispatcher("publisher.jsp").forward(request,response);
                } else if ("学生".equals(role)) {
                    // 如果用户角色是学生，则重定向到学生页面
                    request.setAttribute("u_name",user);
                    request.getRequestDispatcher("student.jsp").forward(request,response);
                }
                else {
                    // 如果角色类型未知，则重定向到错误页面
                    request.setAttribute("u_name",user);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
            }
            session.commit();
        } catch (Exception e) {
            // 处理异常，返回错误页面和错误信息给用户
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

}
