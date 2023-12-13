package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.User;
import com.student.job.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/studentShowApply"})
public class StuShowApply extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/studentShowApply".equals(servletPath)) {
            doGet(request,response);
        }
    }
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer u_id = user.getU_id();
        System.out.println(u_id);
//        List<Job_Publisher> jobs = jobService.selectRecord(u_id);
        List<Job>jobs = jobService.selectJobByStuUid(u_id);
        System.out.println(jobs);
        request.getSession().removeAttribute("jobs");
        request.getSession().setAttribute("jobs",jobs);
        request.getRequestDispatcher("stuShowApply.jsp").forward(request,response);

    }

//    protected  void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        Integer j_id = Integer.parseInt(request.getParameter("j_id"));
//        Job_Publisher job = jobService.SelectJobByJid(j_id);
//        if (job != null){
//            request.getSession().removeAttribute("job");
//            request.getSession().setAttribute("job",job);
//            System.out.println(job);
//            response.getWriter().println(true);
//        }else {
//            response.getWriter().println(false);
//        }
//    }

}
