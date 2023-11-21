package com.student.job.servlet;

import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
import com.student.job.service.JobService;
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

@WebServlet("/addStudServlet")
public class AddStuServlet extends HttpServlet {
    private StudentMapper studentMapper =SqlSessionUtil.openSession().getMapper(StudentMapper.class);
    private final StudentService studentService = new StudentServiceImpl();
    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       //从session里面获取user的ID
       User user = (User) request.getSession().getAttribute("user");
       System.out.println(user.getU_id());
       request.setCharacterEncoding("UTF-8");
       String s_name = request.getParameter("s_name");
       String s_gender = request.getParameter("s_gender");
       String s_age = request.getParameter("s_age");
       String s_phone = request.getParameter("s_phone");
       String s_email = request.getParameter("s_email");
       String s_intro = request.getParameter("s_intro");
       String u_id = request.getParameter("u_id");

       Student student = new Student();
       student.setS_name(s_name);
       student.setS_gender(s_gender);
       student.setS_age(Integer.valueOf(s_age));
       student.setS_phone(s_phone);
       student.setS_email(s_email);
       student.setS_intro(s_intro);
       student.setU_id(user.getU_id());

       //调用Mybatis的Mapper接口插入用户数据
       SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
       try (SqlSession session = sqlSessionFactory.openSession()) {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
           int result = studentMapper.checkStudentExists(String.valueOf(student.getU_id()));
           if (result > 0) {
               String uidError = "请勿重复添加信息";
               request.setAttribute("uidError", uidError);
               request.getRequestDispatcher("addStudent.jsp").forward(request, response);

           }else{
               studentMapper.addStudent(student);
               request.getSession().setAttribute("student",student);
               request.getRequestDispatcher("studentPerson.jsp").forward(request,response);
               session.commit();
           }

       } catch (Exception e) {
        e.printStackTrace();
        request.getRequestDispatcher("studentPerson.jsp").forward(request,response);
       }
//       int res = studentService.addStudent(student);
//        if (res>0) {
//            response.getWriter().println(student.getU_id());
//        }else {
//            response.getWriter().println(false);
//        }
   }
}
