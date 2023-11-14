package com.student.job.servlet;

import com.alibaba.fastjson.JSON;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.User;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "EditJobServlet", value = "/EditJobServlet")
public class EditJobServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String s = request.getReader().readLine();
        Job job = JSON.parseObject(s, Job.class);
        Job job1 = (Job) request.getSession().getAttribute("job");
        job.setJ_id(job1.getJ_id());

        if (job.getJ_id() != null){
            //传入的值没有空值才修改job
            if (jobService.editJob(job)) {
                response.getWriter().println(job.getU_id());
            }else {
                response.getWriter().println(false);
            }
        }
        response.getWriter().println(false);
    }
}

