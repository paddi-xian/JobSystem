package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.User;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectJobByLikeNameServlet", value = "/SelectJobByLikeNameServlet")
public class SelectJobByLikeNameServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String str = request.getParameter("str");
        Integer u_id = user.getU_id();
        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));

        //每页多少条数据
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize")) ;
        request.getSession().setAttribute("pageNum",pageNum);
        request.getSession().setAttribute("pageSize", pageSize);
        //分页
        PageHelper.startPage(pageNum,pageSize);

        List<Job_Publisher> jobs = jobService.SelectJobByLikeName(str,u_id);

        PageInfo<Job_Publisher> info = new PageInfo<>(jobs);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("job.jsp");


    }

}
