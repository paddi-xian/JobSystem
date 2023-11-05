package com.student.job.servlet;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import com.student.job.service.impl.UserServiceImpl;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
/*    @Autowired
    private UserMapper userMapper;
    @PostMapping("/checkTelephone")
    public ResponseEntity<String> checkPhoneExists(@RequestParam String telephone) {
        boolean exists = userMapper.checkTelephoneExits(telephone); // 调用MyBatis查询方法检查手机号是否存在
        if (exists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("手机号已存在"); // 返回手机号已存在的错误信息（HTTP状态码为409）
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("手机号不存在"); // 返回手机号不存在的错误信息（HTTP状态码为200）或其他适当的响应信息（如成功消息）
        }
    }*/
private UserMapper userMapper = SqlSessionUtil.openSession().getMapper(UserMapper.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取用户提交的注册信息
        String u_name = request.getParameter("u_name");
        String u_pass = request.getParameter("u_pass");
        String telephone = request.getParameter("telephone");
        String role = request.getParameter("role");

        boolean phoneExists = userMapper.checkTelephoneExits(telephone); // 调用MyBatis查询方法检查手机号是否存在
        if (phoneExists) {
            //手机号已存在，返回错误页面
            request.setAttribute("telephoneError", "手机号已存在");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }

        //创建用户对象
        User user = new User();
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
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            //注册失败，返回错误页面
            //response.sendRedirect("register.jsp");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

}
