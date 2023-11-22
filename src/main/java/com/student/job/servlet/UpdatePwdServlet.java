package com.student.job.servlet;

import com.student.job.mapper.UserMapper;
import com.student.job.pojo.User;
import com.student.job.service.UserService;
import com.student.job.service.impl.UserServiceImpl;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePwd")
public class UpdatePwdServlet extends HttpServlet {
    private SqlSession session = SqlSessionUtil.openSession();
    private UserMapper userMapper = session.getMapper(UserMapper.class);
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer u_id = Integer.parseInt(request.getParameter("u_id"));
        String old_pass = request.getParameter("old_pass");
        String new_pass = request.getParameter("new_pass");

        User user = new User();
        user.setU_id(u_id);
        user.setU_pass(old_pass);
        user.setU_pass(new_pass);

        boolean result = userService.changPwd(u_id, old_pass, new_pass);
        if(result){
            response.getWriter().write("修改成功");
            System.out.println("修改成功");
        }else {
            response.getWriter().write("原密码错误");
            System.out.println("修改失败");
        }

    }
}
