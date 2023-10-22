package com.student.job.servlet;

import com.student.job.mapper.StudentMapper;
import com.student.job.mapper.UserMapper;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
import com.student.job.service.StudentService;
import com.student.job.service.impl.StudentServiceImpl;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StuListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            List<Student> stuList = studentMapper.getStuList();
            request.setAttribute("stuList",stuList);
            System.out.println(stuList);
            session.commit();
        } catch (Exception e) {
            // 处理异常，返回错误页面和错误信息给用户
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }
        request.getRequestDispatcher("showStudent.jsp").forward(request,response);
    }
}
