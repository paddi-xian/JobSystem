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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户提交的登录信息
        String u_id = request.getParameter("u_id");
        String u_pass = request.getParameter("u_pass");

        //调用MyBatis的Mapper接口查询用户数据
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(u_id);
            //验证用户密码
            if(user != null && user.getU_pass().equals(u_pass)){
                // 登录成功，将用户信息保存到Session中
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("user", user);

                // 根据用户角色进行跳转
                if ("学生".equals(user.getRole())) {
                    response.sendRedirect("student.jsp");
                } else if ("发布者".equals(user.getRole())) {
                    response.sendRedirect("publisher.jsp");
                } else if ("管理员".equals(user.getRole())) {
                    response.sendRedirect("admin.jsp");
                }
            } else {
                // 登录失败，返回登录页面
                response.sendRedirect("login.jsp?error=1");
            }
        }
    }
}
