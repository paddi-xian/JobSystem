package com.student.job.servlet;

import com.alibaba.fastjson.JSON;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
import com.student.job.service.StudentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudServlet")
public class addStuServlet extends HttpServlet {
 private final StudentService stuService =(StudentService) BeanFactory.getBean("stuService");
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
  //从session里面获取user的ID
  User user = (User) request.getSession().getAttribute("user");
  System.out.println(user.getU_id());
  request.setCharacterEncoding("UTF-8");
  String s = request.getReader().readLine();
  Student student = JSON.parseObject(s, Student.class);
  System.out.println(student);
  //在传入的值没有一项为空才增加学生信息
  if (student.getS_name() != null && student.getS_gender() != null&& student.getS_age() != null&& student.getS_gender() != null&& student.getS_phone() != null&& student.getS_email() != null&& student.getS_intro() != null) {
    student.setU_id(user.getU_id());
    System.out.println(student);
   if (stuService.addStudent(student)) {
    response.getWriter().println(student.getU_id());
   }else {
    response.getWriter().println(false);
   }
  }
  response.getWriter().println(false);
 }

}
