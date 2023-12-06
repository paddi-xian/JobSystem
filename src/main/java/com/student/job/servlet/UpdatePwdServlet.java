package com.student.job.servlet;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import com.student.job.service.impl.UserServiceImpl;
import com.student.job.utils.SqlSessionUtil;
import lombok.SneakyThrows;
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

import static com.student.job.service.impl.UserServiceImpl.bytesToHex;

@WebServlet("/updatePwd")
public class UpdatePwdServlet extends HttpServlet {
    private SqlSession session = SqlSessionUtil.openSession();
    private UserMapper userMapper = session.getMapper(UserMapper.class);
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        User users = (User) request.getSession().getAttribute("user");
        Integer u_id = users.getU_id();

        String old_pass = request.getParameter("old_pass");
        String new_pass = request.getParameter("new_pass");


        User user = new User();
        user.setU_id(u_id);
        user.setU_pass(new_pass);

        //从前端获取的密码进行SHA1加密
        String shA1Password = null;
        try {
            shA1Password = getSHA1Hash(old_pass);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User checkUser = userMapper.checkPwd(u_id,shA1Password);
        if (checkUser == null || !checkUser.getU_pass().equals(shA1Password)) {
            // 如果没有找到用户或用户名或密码错误，则重定向到错误页面
            String message = "原密码错误";
            request.setAttribute("message", message);
            request.getRequestDispatcher("updatePwd.jsp").forward(request, response);
        } else {
            // 更新密码
            int result = userMapper.updatePwd(u_id, new_pass);
            session.commit();
            if (result == 1) {
                // 可以重定向到成功页面或以其他方式提示用户密码更新成功
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                System.out.println("Failed to update password");
                response.getWriter().write("修改失败");
                // 可以返回错误页面或以其他方式提示用户密码更新失败
            }
        }
        session.close();
    }
    private String getSHA1Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return bytesToHex(digest); // 将字节数组转换为十六进制字符串
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}