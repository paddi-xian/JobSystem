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

@WebServlet({"/Job","/AllJob"})
public class JobServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected  void  service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/Job".equals(servletPath)) {
            doList(request,response);
        }else if ("/AllJob".equals(servletPath)){
            doALL(request, response);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer u_id = Integer.parseInt(request.getParameter("u_id"));
        List<Job>jobs=jobService.selectJobByUid(u_id);
        request.getSession().removeAttribute("jobs");
        request.getSession().setAttribute("jobs",jobs);
        request.getRequestDispatcher("job.jsp").forward(request,response);
    }



    private void doALL(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Job> AllJob = jobService.selectAllJob();
        request.getSession().removeAttribute("AllJob");
        request.getSession().setAttribute("AllJob",AllJob);
        response.sendRedirect("showJob.jsp");
    }


}
