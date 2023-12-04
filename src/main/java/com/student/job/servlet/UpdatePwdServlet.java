package com.student.job.servlet;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import com.student.job.service.impl.UserServiceImpl;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/updatePwd")
public class UpdatePwdServlet extends HttpServlet {
    private SqlSession session = SqlSessionUtil.openSession();
    private UserMapper userMapper = session.getMapper(UserMapper.class);
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        Integer uid = user.getU_id();
//        Integer uid = (Integer) request.getSession().getAttribute("u_id");

        String oldPwd = request.getParameter("old_pass");
        String newPwd = request.getParameter("new_pass");
        String confirmPwd = request.getParameter("confirmPwd");

//        // 检查新密码和确认密码是否匹配
//        if (!newPwd.equals(confirmPwd)) {
//            // 返回错误消息，密码不匹配
//            response.getWriter().write("新密码和确认密码不匹配");
//            return;
//        }

        user.setU_pass(oldPwd);
        // 验证旧密码是否正确
        User checkUser = userMapper.checkPwd(uid, oldPwd);
        if (checkUser == null) {
            // 返回错误消息，旧密码不正确
            response.getWriter().write("旧密码不正确");
            return;
        }
        user.setU_id(uid);
        user.setU_pass(newPwd);

        // 更新密码
        int i = userMapper.updatePwd(uid, newPwd);
        session.commit();
        if (i > 0) {
            // 更新成功，重定向或返回成功消息
            response.sendRedirect("/login.jsp"); // 您可以替换为实际的成功页面路径
        } else {
            // 更新失败，返回错误消息
            response.getWriter().write("fail");
        }
    }
}
