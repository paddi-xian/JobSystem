package com.student.job.servlet;

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
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/student".equals(servletPath)) {
            doPerson(request,response);
        }else if ("/updateStudent".equals(servletPath)){
            try {
                doUpdate(request,response);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void doPerson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer u_id = Integer.parseInt(request.getParameter( "u_id"));
//        Integer u_id = 1010;
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
            throws ServletException, IOException, CloneNotSupportedException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        User user = (User) request.getSession().getAttribute("user");

        // 创建一个临时的Student对象，从request中获取所有参数
        Student tempStudent = new Student();

        tempStudent.setS_name(request.getParameter("s_name"));
        tempStudent.setS_gender(request.getParameter("s_gender"));
        tempStudent.setS_age(Integer.parseInt(request.getParameter("s_age")));
        tempStudent.setS_intro(request.getParameter("s_intro"));
        tempStudent.setS_college(request.getParameter("s_college"));
        tempStudent.setS_prize(request.getParameter("s_prize"));
        tempStudent.setS_experience(request.getParameter("s_experience"));
        tempStudent.setS_job(request.getParameter("s_job"));

        // 使用克隆方法复制临时对象的属性到新的Student对象
        Student student = (Student) tempStudent.clone();
        //根据需要修改新对象的某些属性
        student.setU_id(user.getU_id()); // 假设这是需要单独设置的属性
        student.setS_phone(user.getTelephone());
        student.setS_email(user.getEmail());

        // 获取请求中的电话和电子邮件
        String s_phone = request.getParameter("s_phone");
        String s_email = request.getParameter("s_email");
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
         //更新Student表的信息
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
