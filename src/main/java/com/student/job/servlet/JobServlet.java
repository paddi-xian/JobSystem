package com.student.job.servlet;

import com.student.job.pojo.Job;
import com.student.job.service.JobService;
import com.student.job.service.impl.JobServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Job")
public class JobServlet extends HttpServlet {
    private JobService jobService = new JobServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer u_id = Integer.parseInt(request.getParameter("u_id"));
        List<Job>jobs=jobService.selectJobByUid(u_id);
        request.getSession().removeAttribute("jobs");
        request.getSession().setAttribute("jobs",jobs);
        response.sendRedirect("job.jsp");
    }

}
