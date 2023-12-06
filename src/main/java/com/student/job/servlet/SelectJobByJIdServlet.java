package com.student.job.servlet;

import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectJobByJIdServlet", value = "/SelectJobByJIdServlet")
public class SelectJobByJIdServlet extends HttpServlet {

    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer j_id = Integer.parseInt(request.getParameter("j_id"));
        Job_Publisher job = jobService.SelectJobByJid(j_id);
        if (job != null){
            request.getSession().removeAttribute("job");
            request.getSession().setAttribute("job",job);
//            System.out.println(job);
            response.getWriter().println(true);
        }else {
            response.getWriter().println(false);
        }
    }
}
