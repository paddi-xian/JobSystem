package com.student.job.servlet;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resetPass")
public class PasswordServlet extends HttpServlet {
    private SqlSession session = SqlSessionUtil.openSession();
    private UserMapper userMapper = session.getMapper(UserMapper.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = (String)request.getSession().getAttribute("email");
        String newPass = request.getParameter("newPass");

        User user = new User();
        user.setEmail(email);
        user.setU_pass(newPass);

        System.out.println(email);
        System.out.println(newPass);
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            User users = userMapper.isHasEmail(email);
            UserMapper userMapper = session.getMapper(UserMapper.class);
            if (users != null) {
                int result = userMapper.resetPass(email, newPass);
                session.commit();
                if(result>0){

                    response.sendRedirect("login.jsp"); // Or some other redirect.
                }else {
                    response.getWriter().write("密码重置失败");
                }
            } else {
                System.out.println(newPass);
                request.setAttribute("errorMessage", "No user with that email found.");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // 处理异常，返回错误页面和错误信息给用户
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
}
