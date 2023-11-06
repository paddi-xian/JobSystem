package com.student.job.servlet;

import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Student;
import com.student.job.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = (StudentService) BeanFactory.getBean("studentService");
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer u_id = Integer.parseInt(request.getParameter("u_id"));
        System.out.println(u_id);
        List<Student>student=studentService.selectStudentByUid(u_id);
        System.out.println(student);
        request.getSession().removeAttribute("student");
        request.getSession().setAttribute("student",student);
        request.getRequestDispatcher("studentPerson.jsp").forward(request,response);
    }
}
