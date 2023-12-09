package com.student.job.servlet;

import com.github.pagehelper.PageInfo;
import com.student.job.mapper.ApplicationMapper;
import com.student.job.mapper.JobMapper;
import com.student.job.mapper.PublisherMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Job;
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
import java.util.List;

@WebServlet("/publisherApply")
public class PublishApply extends HttpServlet {

    private SqlSession session = SqlSessionUtil.openSession();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer u_id = Integer.parseInt(request.getParameter("u_id"));
        System.out.println(u_id);
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
//        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
//        List<Student> students =  studentMapper.
        PublisherMapper mapper = session.getMapper(PublisherMapper.class);
        List<Student> students = mapper.selectStuByPubUid(u_id);
        System.out.println(students);
        request.getSession().removeAttribute("students");
        request.getSession().setAttribute("students",students);
        request.getRequestDispatcher("publisherApply.jsp").forward(request,response);
    }
}
