package com.student.job.servlet;

import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Student;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/student","/updateStuServlet"})
public class Studentervlet extends HttpServlet {
    @Override
    protected  void  service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/student".equals(servletPath)) {
            doList(request,response);
        }else if ("/updateStuServlet".equals(servletPath)){
            doUpdate(request, response);
        }
    }

    //查找所有学生
    protected void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            List<Student> stuList = studentMapper.getStuList();
            request.setAttribute("stuList",stuList);
            System.out.println(stuList);
            session.commit();
        } catch (Exception e) {
            // 处理异常，返回错误页面和错误信息给用户
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }
        request.getRequestDispatcher("showStudent.jsp").forward(request,response);
    }
    //更新学生个人信息
    private  void  doUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String s_name = request.getParameter("s_name");
        String s_gender = request.getParameter("s_gender");
        int s_age = Integer.parseInt(request.getParameter("s_age"));
        String s_phone = request.getParameter("s_phone");
        String s_email = request.getParameter("s_email");
        String s_intro= request.getParameter("s_intro");


        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session =sqlSessionFactory.openSession()){
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            studentMapper.updateStudent(s_name, s_gender, s_age, s_phone, s_email, s_intro);
            session.commit();
            session.commit();
        }catch (Exception e){
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }finally {
            request.getRequestDispatcher("student.jsp").forward(request,response);

        }



    }
}
