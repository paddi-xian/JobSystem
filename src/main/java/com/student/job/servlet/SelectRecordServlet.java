package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.pojo.*;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectRecordServlet", value = "/SelectRecordServlet")
public class SelectRecordServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer u_id = user.getU_id();
        //获取前端第几页
        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));
        //每页多少条数据
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize"));
        request.getSession().setAttribute("pageNum",pageNum);
        request.getSession().setAttribute("pageSize", pageSize);
        //分页
        PageHelper.startPage(pageNum,pageSize);
        //查询所有job
        List<Job_Publisher> jobs = jobService.selectRecord(u_id);

        PageInfo<Job_Publisher> info = new PageInfo<>(jobs);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("stuRecord.jsp");

    }

}
