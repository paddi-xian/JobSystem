package com.student.job.servlet;

import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.service.JobService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Job")
public class JobServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer u_id = Integer.parseInt(request.getParameter("u_id"));
        int total = jobService.JobTotal(u_id);
        List<Job>jobs=jobService.selectJobByUid(u_id);
        request.getSession().removeAttribute("jobs");
        request.getSession().setAttribute("jobs",jobs);
        request.getSession().setAttribute("total",total);
        request.getRequestDispatcher("job.jsp").forward(request,response);
    }


}
