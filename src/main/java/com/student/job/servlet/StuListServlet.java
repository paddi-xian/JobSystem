package com.student.job.servlet;

import com.student.job.pojo.Student;
import com.student.job.service.StudentService;
import com.student.job.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StuListServlet extends HttpServlet {
    StudentService Service = new StudentServiceImpl();
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student>studentList = Service.getStuList();
        req.setAttribute("stuList",studentList);
        req.getRequestDispatcher("student.jsp").forward(req,resp);
    }
}
