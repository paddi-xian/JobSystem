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

@WebServlet(name = "addJobServlet", value = "/addJobServlet")
public class AddJobServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从session里面获取user的ID
        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.getU_id());
        request.setCharacterEncoding("UTF-8");
        //解析Vue的JSON格式，变成后端的JSON格式
        String s = request.getReader().readLine();
        Job job = JSON.parseObject(s, Job.class);
//        System.out.println(job);
//        System.out.println(job.getJ_hours());
        //在传入的值没有一项为空才增加job
        job.setU_id(user.getU_id());
        System.out.println(job);

        if (jobService.addJob(job)) {
            response.getWriter().println(job.getU_id());
        } else {
            response.getWriter().println(false);
        }
        response.getWriter().println(false);

    }
}
