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

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       //从session里面获取user的ID
       User user = (User) request.getSession().getAttribute("user");
       request.setCharacterEncoding("UTF-8");
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
        Student student = null;
        try {
            student = (Student) tempStudent.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        //根据需要修改新对象的某些属性
        student.setU_id(user.getU_id()); // 假设这是需要单独设置的属性
        student.setS_phone(user.getTelephone());
        student.setS_email(user.getEmail());
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
               request.getRequestDispatcher("remain.jsp").forward(request,response);
               session.commit();
               session.close();
           }

       } catch (Exception e) {
        e.printStackTrace();
        request.getRequestDispatcher("studentPerson.jsp").forward(request,response);
       }
   }
}
