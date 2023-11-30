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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/student","/updateStudent"})
public class StudentServlet extends HttpServlet {
    private final StudentService studentService= new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/student".equals(servletPath)) {
            doPerson(request,response);
        }else if ("/updateStudent".equals(servletPath)){
            doUpdate(request,response);
        }
    }
    private void doPerson(HttpServletRequest request, HttpServletResponse response)
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

    private void doUpdate(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        User user = (User) request.getSession().getAttribute("user");

        Integer u_id = user.getU_id();
        System.out.println(user.getU_id());
        String s_name = request.getParameter("s_name");
        String s_gender = request.getParameter("s_gender");
        Integer s_age = Integer.parseInt(request.getParameter( "s_age"));
        String s_phone = request.getParameter("s_phone");
        String s_email = request.getParameter("s_email");
        String s_intro = request.getParameter("s_intro");
        String s_college = request.getParameter("s_college");
        String s_prize = request.getParameter("s_prize");
        String s_experience = request.getParameter("s_experience");
        String s_job = request.getParameter("s_job");

        Student student = new Student();
        student.setS_name(s_name);
        student.setS_gender(s_gender);
        student.setS_age(s_age);
        student.setS_phone(user.getTelephone());
        student.setS_email(user.getEmail());
        student.setS_intro(s_intro);
        student.setU_id(user.getU_id());
        student.setS_college(s_college);
        student.setS_prize(s_prize);
        student.setS_experience(s_experience);
        student.setS_job(s_job);
        // 检查电话号码和邮箱是否需要更新
        if (!s_phone.equals(user.getTelephone()) || !s_email.equals(user.getEmail())) {
            // 更新User表的电话和邮箱信息
            user.setTelephone(s_phone);
            user.setEmail(s_email);
            SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
            try (SqlSession session = sqlSessionFactory.openSession()) {
                StudentMapper studentMapper = session.getMapper(StudentMapper.class);
                int rowsAffected = studentMapper.updateUser(user);
                System.out.println("User table rows affected: " + rowsAffected);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 更新Student表的信息
        student.setS_phone(user.getTelephone()); // 使用更新后的电话号码或原始电话号码（如果没有更改）
        student.setS_email(user.getEmail()); // 使用更新后的邮箱或原始邮箱（如果没有更改）

        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            int rowsAffected = studentMapper.updateStudent(student);
            System.out.println(rowsAffected);
            System.out.println(student);
            if (rowsAffected > 0) {
                session.commit();// 提交事务，保存更改
                session.close();
                request.setCharacterEncoding("UTF-8");
                out.println("<p>Student information updated successfully.</p>");
            }
            else {
                request.setCharacterEncoding("UTF-8");
                out.println("<p>failed</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(student);
        }
    }
}
