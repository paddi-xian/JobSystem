package com.student.job.servlet;

import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
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


       //在传入的值没有一项为空才增加学生信息
       //创建学生对象
       Student student = new Student();
       student.setS_name(s_name);
       student.setS_gender(s_gender);
       student.setS_age(Integer.valueOf(s_age));
       student.setS_phone(s_phone);
       student.setS_email(s_email);
       student.setS_intro(s_intro);
       student.setU_id(user.getU_id());

       boolean u_idExists=studentMapper.checkU_idExits(student.getU_id());
       if (u_idExists) {
           request.setAttribute("u_idError","请勿重复添加信息");
           request.getParameter("student.jsp");
           return;
       }
       //调用Mybatis的Mapper接口插入用户数据
       SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
       try (SqlSession session = sqlSessionFactory.openSession()) {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.addStudent(student);
        session.commit();
        request.getSession().setAttribute("student",student);
        request.getRequestDispatcher("studentPerson.jsp").forward(request,response);
       } catch (Exception e) {
        e.printStackTrace();
        request.getRequestDispatcher("addStudent.jsp").forward(request,response);
       }
   }
}
