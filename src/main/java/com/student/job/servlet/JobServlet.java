package com.student.job.servlet;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.mapper.UserMapper;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.User;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"/Job","/ShowJob","/StuShowJob","/updateStatus"})
public class JobServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");
    private SqlSession session = SqlSessionUtil.openSession();
    private UserMapper userMapper = session.getMapper(UserMapper.class);
    private JobMapper jobMapper = session.getMapper(JobMapper.class);
    @Override
    protected  void  service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/Job".equals(servletPath)) {
            doGet(request,response);
        }else if ("/ShowJob".equals(servletPath)){
            doShowJob(request, response);
        }else if ("/StuShowJob".equals(servletPath)) {
            doAllJob(request, response);
        }else if("/updateStatus".equals(servletPath)){
            doStatus(request,response);
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
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize"));
        request.getSession().setAttribute("pageSize", pageSize);
        //把本方法的url存入session域，让前端动态获取
        request.getSession().setAttribute("url","Job");
        //分页
        PageHelper.startPage(pageNum,pageSize);
        //查询所有job
        List<Job> jobs = jobService.selectJobByUid(u_id);

        PageInfo<Job> info = new PageInfo<>(jobs);
        request.getSession().setAttribute("info",info);
        response.sendRedirect("job.jsp");
    }

    private void doShowJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取前端第几页
        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));
        //每页多少条数据
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize"));
        request.getSession().setAttribute("pageSize", pageSize);
        //分页
        PageHelper.startPage(pageNum,pageSize);
        //查询所有job
        List<Job> AllJob = jobService.selectAllJob();
        PageInfo<Job> info = new PageInfo<>(AllJob);
        request.getSession().setAttribute("info",info);
        request.getRequestDispatcher("showJob.jsp").forward(request,response);
    }

    private void doAllJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取前端第几页
        Integer  pageNum = Integer.parseInt(request.getParameter("pageNum"));

        //每页多少条数据
        Integer  pageSize =  Integer.parseInt(request.getParameter("pageSize"));
        request.getSession().setAttribute("pageSize", pageSize);
        request.getSession().setAttribute("url","StuShowJob");
        //分页
        PageHelper.startPage(pageNum,pageSize);
        //查询所有job
        List<Job_Publisher> StuJob = jobService.SelectJob_publish();
        PageInfo<Job_Publisher> info = new PageInfo<>(StuJob);
        request.getSession().setAttribute("info",info);
        request.getRequestDispatcher("stuShowJob.jsp").forward(request,response);
    }

    private void doStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Integer j_id = Integer.parseInt(request.getParameter("j_id"));
        request.getSession().setAttribute("j_id", j_id);
        String j_status = request.getParameter("j_status");
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            JobMapper jobMapper = session.getMapper(JobMapper.class);
            int res = jobMapper.updateStatusByJob(j_id,j_status);
            if (res == 1){
                response.getWriter().println(true);
            }else {
                response.getWriter().println(false);
            }
            session.commit();
//            request.getRequestDispatcher("showJob.jsp").forward(request,response);
        }finally {
            session.close();
        }
    }
}
