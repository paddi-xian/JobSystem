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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private boolean isUserNameExists(String u_name) {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User existUser = userMapper.getUserByName(u_name);
            return existUser != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取用户提交的注册信息
        String u_name = request.getParameter("u_name");
        String u_pass = request.getParameter("u_pass");
        String telephone = request.getParameter("telephone");
        String role = request.getParameter("role");

        //创建用户对象
        User user = new User();
        user.setU_name(u_name);
        user.setU_pass(u_pass);
        user.setTelephone(telephone);
        user.setRole(role);

        //检查用户名是否已存在
        boolean isUserNameExists = isUserNameExists(u_name);
        //响应到结果集

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (isUserNameExists) {
            //用户名已存在，不可用
            out.print("<font color='red'>对不起，用户名已存在</font>");
        } else {
            //用户名不存在，可用
            out.print("<font color='green'>用户名可以使用</font>");
            //调用Mybatis的Mapper接口插入用户数据
            SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
            try (SqlSession session = sqlSessionFactory.openSession()) {
                UserMapper userMapper = session.getMapper(UserMapper.class);
                userMapper.insertUser(user);
                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                //注册失败，返回错误页面
                response.sendRedirect("register.jsp");
            }
            //注册成功后跳转到登陆页面
            response.sendRedirect("login.jsp");
        }
    }
}
