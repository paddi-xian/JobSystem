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

        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            UserMapper userMapper = session.getMapper(UserMapper.class);
            // 调用 mapper 方法查询用户信息
            User user = userMapper.getUserById(u_id);
            // 验证用户信息是否正确
            if (user != null && user.getU_pass().equals(u_pass)) {
                // 登录成功，可以存取 user 对象中的数据，或者重定向到其他页面
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            } else {
                // 登录失败，可以返回错误信息给用户
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
