package com.student.job.servlet;

import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.Record;
import com.student.job.pojo.User;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "isRecordServlet", value = "/isRecordServlet")
public class isRecordServlet extends HttpServlet {
    private final JobService jobService =(JobService) BeanFactory.getBean("jobService");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer j_id = Integer.parseInt(request.getParameter("j_id"));
        User user = (User) request.getSession().getAttribute("user");
        Job_Publisher record = jobService.isRecord(user.getU_id(), j_id);
        System.out.println(record);
        request.getSession().setAttribute("Record",record);



    }
}
