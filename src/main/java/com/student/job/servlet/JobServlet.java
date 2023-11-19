package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.User;
import com.student.job.service.JobService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/Job","/AllJob","/StuShowJob"})
public class JobServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected  void  service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/Job".equals(servletPath)) {
            doGet(request,response);
        }else if ("/AllJob".equals(servletPath)){
            doALL(request, response);
        }else if ("/StuShowJob".equals(servletPath)){
            doAllJob(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer u_id = user.getU_id();
        //获取前端第几页
        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));

        //每页多少条数据
        int  pageSize =  5 ;

        //分页
        PageHelper.startPage(pageNum,pageSize);
        //查询所有job
        List<Job> jobs = jobService.selectJobByUid(u_id);

        PageInfo<Job> info = new PageInfo<>(jobs);
//        System.out.println(info.getList());
//        System.out.println("info.getTotal()="+info.getTotal());
//        System.out.println(info.getSize());

//        request.getSession().removeAttribute("jobs");
//        request.getSession().setAttribute("jobs",jobs);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("job.jsp");
    }

    private void doALL(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Job> AllJob = jobService.selectAllJob();
        request.getSession().removeAttribute("AllJob");
        request.getSession().setAttribute("AllJob",AllJob);
        response.sendRedirect("showJob.jsp");
    }

    private void doAllJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Job> AllJob = jobService.selectAllJob();
        request.getSession().removeAttribute("AllJob");
        request.getSession().setAttribute("AllJob",AllJob);
        response.sendRedirect("stuShowJob.jsp");
    }

}
