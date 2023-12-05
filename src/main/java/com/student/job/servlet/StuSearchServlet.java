package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.User;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StuSearchServlet", value = "/StuSearchServlet")
public class StuSearchServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("str");
        //把一开始搜索的内容存入session，让它点击下一页的时候可以附带值str
        request.getSession().setAttribute("str",str);

        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));

        //每页多少条数据
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize")) ;
        request.getSession().setAttribute("pageNum",pageNum);
        request.getSession().setAttribute("pageSize", pageSize);
        //把本方法的url存入session域，让前端动态获取
        request.getSession().setAttribute("url","StuSearchServlet");
        //分页
        PageHelper.startPage(pageNum,pageSize);

        List<Job_Publisher> jobs = jobService.SelectJobByLikeName(str,null);

        PageInfo<Job_Publisher> info = new PageInfo<>(jobs);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("stuShowJob.jsp");
    }

}
