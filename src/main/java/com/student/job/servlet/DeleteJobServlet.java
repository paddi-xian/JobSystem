package com.student.job.servlet;

import com.student.job.pojo.BeanFactory;
import com.student.job.service.JobService;
import com.student.job.service.impl.JobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteJob")
public class DeleteJobServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端传来的j_id
        Integer j_id = Integer.parseInt(request.getParameter("j_id"));
//        System.out.println(j_id);
        int res = jobService.deleteJobByJID(j_id);

        if (res == 1) {
            response.getWriter().println(true);
        }else {
            response.getWriter().println(false);
        }

    }
}
