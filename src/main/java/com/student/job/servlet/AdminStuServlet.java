package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.Student;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet({"/showStudent","/showStudentTotal"})
public class AdminStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/showStudent".equals(servletPath)) {
            doShow(request, response);
        }
    }

    private SqlSession session = SqlSessionUtil.openSession();
    private void doShow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取前端第几页
        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));

        //每页多少条数据
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize"));
        request.getSession().setAttribute("pageSize", pageSize);
        //分页
        PageHelper.startPage(pageNum,pageSize);

        // 获取 mapper
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        List<Student> stuList = studentMapper.getStuList();
        PageInfo<Student> info = new PageInfo<>(stuList);
        request.getSession().setAttribute("info",info);
        System.out.println(stuList);
        request.getRequestDispatcher("showStudent.jsp").forward(request,response);
    }

}
