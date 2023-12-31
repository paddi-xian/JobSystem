package com.student.job.servlet;

import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.User;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "removeRecordServlet", value = "/removeRecordServlet")
public class removeRecordServlet extends HttpServlet {
    private final JobService jobService =(JobService) BeanFactory.getBean("jobService");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer j_id = Integer.parseInt(request.getParameter("j_id"));
        User user = (User) request.getSession().getAttribute("user");
        int res = jobService.removeRecord(user.getU_id(), j_id);
        if(res == 1){
            response.getWriter().println(true);
        }else {
            response.getWriter().println(false);
        }
    }
}
