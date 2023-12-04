package com.student.job.servlet;

import com.student.job.mapper.ApplicationMapper;
import com.student.job.mapper.JobMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.*;
import com.student.job.service.ApplicationService;
import com.student.job.service.JobService;
import com.student.job.service.StudentService;
import com.student.job.service.impl.ApplicationServiceImpl;
import com.student.job.service.impl.StudentServiceImpl;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet({"/addApplication","/showApply"})
public class ApplicationServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");
    private SqlSession session = SqlSessionUtil.openSession();
    private JobMapper jobMapper = session.getMapper(JobMapper.class);
    private ApplicationMapper applicationMapper = SqlSessionUtil.openSession().getMapper(ApplicationMapper.class);
    private final ApplicationService applicationService = new ApplicationServiceImpl();
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/addApplication".equals(servletPath)) {
            doPost(request,response);
        }else if ("/showApply".equals(servletPath)){
            doGet(request,response);
        }
    }

@Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    // 获取用户提交的表单数据
    request.setCharacterEncoding("UTF-8");
         User user = (User) request.getSession().getAttribute("user");
         Integer u_id = user.getU_id();
         Integer j_id = Integer.valueOf(request.getParameter("j_id"));
         String a_status = "未审核"; // 默认状态为未审核
        Application application = new Application();
        application.setU_id(u_id);
        application.setJ_id(j_id);
        application.setA_status(a_status);
        System.out.println(application);
        System.out.println(u_id);
        System.out.println(j_id);
        // 检查是否已经存在该用户的申请记录，如果存在则返回错误信息，否则继续处理
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        // 保存申请记录到数据库中
        try ( SqlSession session = sqlSessionFactory.openSession()){
            ApplicationMapper applicationMapper=session.getMapper(ApplicationMapper.class);
            int result = applicationMapper.checkDuplicate(u_id,j_id);
            System.out.println(result);
            if (result> 0) {
                String doubleError = "请勿重复申请";
                request.setAttribute("doubleError", doubleError);
                request.getRequestDispatcher("/checkJob.jsp").forward(request, response);
            }else{
                int res = applicationMapper.addApplication(application);
                System.out.println(res);
                request.getSession().setAttribute("application",application);
                request.getRequestDispatcher("/stuShowJob.jsp").forward(request,response);
                session.commit();
                if(res == 1){
                   response.getWriter().println(true);
               }else {
                   response.getWriter().println(false);
               }
            }
        } catch (Exception e) {
            request.setAttribute("error", "申请失败：" + e.getMessage());
            request.getRequestDispatcher("/stuShowJob.jsp").forward(request, response);

        }

    }

@Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
    Integer j_id = Integer.parseInt(request.getParameter("j_id"));


}


}
