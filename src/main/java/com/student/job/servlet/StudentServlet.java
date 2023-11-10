package com.student.job.servlet;

import com.alibaba.fastjson.JSON;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
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

@WebServlet({"/student","/updateStudent"})
public class StudentServlet extends HttpServlet {
    private final StudentService studentService= new StudentServiceImpl();
    @Override
    protected  void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/student".equals(servletPath)) {
            doGet(request,response);
        }else if ("/updateStudent".equals(servletPath)){
            doUpdate(request, response);
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

    protected void doUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String s = request.getReader().readLine();
       Student student=JSON.parseObject(s,Student.class);
       Student student1=(Student)request.getSession().getAttribute("student");
//        Integer u_id = Integer.parseInt(request.getParameter( "u_id"));
        student.setS_id(student1.getS_id());
//        System.out.println(u_id);

        if (student.getS_id() != null) {
            if (studentService.updateStudent(student)) {
                response.getWriter().println(student.getU_id());
            }else {
                response.getWriter().println(false);
            }
            response.getWriter().println(false);
        }
//
    }
}
