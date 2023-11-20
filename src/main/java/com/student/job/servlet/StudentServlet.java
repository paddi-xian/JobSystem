package com.student.job.servlet;

import com.alibaba.fastjson.JSON;
import com.student.job.mapper.StudentMapper;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/student","/updateStudent"})
public class StudentServlet extends HttpServlet {
    private final StudentService studentService= new StudentServiceImpl();
    @Override
    protected  void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/student".equals(servletPath)) {
            doGet(request,response);
        }
        if ("/updateStudent".equals(servletPath)) {
            doPost(request,response);
        }
    }
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer u_id = Integer.parseInt(request.getParameter( "u_id"));
        System.out.println(u_id);
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try(SqlSession session =sqlSessionFactory.openSession()){
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student student=studentMapper.selectStudentByUid(u_id);
            System.out.println(student);
            request.getSession().removeAttribute("student");
            request.getSession().setAttribute("student",student);
            request.getRequestDispatcher("studentPerson.jsp").forward(request,response);
        }
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getU_id());

        String s_name = request.getParameter("s_name");
        String s_gender = request.getParameter("s_gender");
        Integer s_age = Integer.valueOf(request.getParameter("s_age"));
        String s_phone = request.getParameter("s_phone");
        String s_email = request.getParameter("s_email");
        String s_intro = request.getParameter("s_intro");

        Student student = new Student();
        student.setS_name(s_name);
        student.setS_gender(s_gender);
        student.setS_age(Integer.valueOf(s_age));
        student.setS_phone(s_phone);
        student.setS_email(s_email);
        student.setS_intro(s_intro);
        student.setU_id(user.getU_id());

        System.out.println(student);
        int rowsAffected = studentService.updateStudent(student);
        if (rowsAffected > 0) {
            out.println("<p>Student information updated successfully.</p>");
        } else {
            out.println("<p>Failed to update student information.</p>");
        }
    }


}
