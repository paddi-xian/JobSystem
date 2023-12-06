package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.User;
import com.student.job.service.JobService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectJobByLikeNameServlet", value = "/SelectJobByLikeNameServlet")
public class SelectJobByLikeNameServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String str = request.getParameter("str");
        //把一开始搜索的内容存入session，让它点击下一页的时候可以附带值str
        request.getSession().setAttribute("str",str);




        Integer u_id = user.getU_id();
        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));
//        System.out.println(u_id);

        //每页多少条数据
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize")) ;
        request.getSession().setAttribute("pageNum",pageNum);
        request.getSession().setAttribute("pageSize", pageSize);
        //点击搜索按钮，把原本session域内的url覆盖 ${url}原本是Job ----> SelectJobByLikeNameServlet
        request.getSession().setAttribute("url","SelectJobByLikeNameServlet");
        //分页
        PageHelper.startPage(pageNum,pageSize);

        List<Job_Publisher> jobs = jobService.SelectJobByLikeName(str,u_id);

        PageInfo<Job_Publisher> info = new PageInfo<>(jobs);
//        System.out.println(info);
        request.getSession().removeAttribute("info");
        request.getSession().setAttribute("info",info);
        response.sendRedirect("job.jsp");


    }

}
