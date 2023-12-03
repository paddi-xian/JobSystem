package com.student.job.servlet;

import com.student.job.mapper.ApplicationMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Application;
import com.student.job.pojo.Job;
import com.student.job.pojo.Student;
import com.student.job.pojo.User;
import com.student.job.service.ApplicationService;
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

@WebServlet("/addApplication")
public class ApplicationServlet extends HttpServlet {
    private ApplicationMapper applicationMapper = SqlSessionUtil.openSession().getMapper(ApplicationMapper.class);
    private final ApplicationService applicationService = new ApplicationServiceImpl();

@Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    // 获取用户提交的表单数据
    User user = (User) request.getSession().getAttribute("user");
    Integer u_id = user.getU_id();
    Integer j_id = Integer.valueOf(request.getParameter("j_id"));

        request.setCharacterEncoding("UTF-8");

        String a_status = "未审核"; // 默认状态为未审核
        Application application = new Application();
        application.setU_id(u_id);
        System.out.println(u_id);
        application.setJ_id(j_id);
        application.setA_status(a_status);
        // 检查是否已经存在该用户的申请记录，如果存在则返回错误信息，否则继续处理
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        // 保存申请记录到数据库中
        try (  SqlSession session = sqlSessionFactory.openSession()){
            ApplicationMapper applicationMapper=session.getMapper(ApplicationMapper.class);
            int result = applicationMapper.checkDuplicate(u_id,j_id);
            if (result> 0) {
                request.setAttribute("error", "您已经申请过该职位，请勿重复申请。");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }else{
                applicationMapper.addApplication(application);
                request.getSession().setAttribute("application",application);
                request.getRequestDispatcher("/stuShowJob.jsp").forward(request,response);
                session.commit();
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("申请送达");
            }
        } catch (Exception e) {
            request.setAttribute("error", "申请失败：" + e.getMessage());
            request.getRequestDispatcher("/stuShowJob.jsp").forward(request, response);

        }

    }
}
