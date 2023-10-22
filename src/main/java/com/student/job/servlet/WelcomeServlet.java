package com.student.job.servlet;

import com.student.job.pojo.User;
import com.student.job.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String telephone = null;
        String u_pass = null;
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("telephone".equals(name)) {
                    telephone = cookie.getValue();
                }else if("u_pass".equals(name)){
                    u_pass = cookie.getValue();
                }
            }
        }

        //使用telephoned和u_pass变量
        if (telephone != null && u_pass != null) {
            //验证用户名和密码是否正确
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            boolean success = false;
            try {
                conn = DBUtil.getConnection();
                String sql = "select * from user where telephone = ? and u_pass = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,telephone);
                ps.setString(2,u_pass);
                rs = ps.executeQuery();
                if(rs.next()){
                    //登录成功
                    success = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtil.close(conn,ps,rs);
            }

            if (success) {
                //获取session
                HttpSession session = request.getSession();
                User user = new User();
                session.setAttribute("user",user);
                //正确表示登录成功
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                //错误，表示登录失败
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        }else {
            //跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }

    }
}
