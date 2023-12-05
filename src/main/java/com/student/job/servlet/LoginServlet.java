package com.student.job.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.student.job.mapper.UserMapper;
import com.student.job.pojo.BeanFactory;
import com.student.job.pojo.Job;
import com.student.job.pojo.Job_Publisher;
import com.student.job.pojo.User;
import com.student.job.service.JobService;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final JobService jobService = (JobService) BeanFactory.getBean("jobService");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //获取用户提交的登录信息
        //String u_name = request.getParameter("u_name");
        String telephone = request.getParameter("telephone");
        String u_pass = request.getParameter("u_pass");
        System.out.println(telephone+"+++++"+u_pass);

        //验证码判断
        String vCode = (String) request.getSession().getAttribute("vCode");
        String vCode1 = request.getParameter("vCode");
        if (!vCode1.equalsIgnoreCase(vCode) && vCode1 != "") {
            String message = "验证码错误";
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            System.out.println("登录失败");
        }

        //从前端获取的密码进行SHA1加密
        String shA1Password = null;
        try {
            shA1Password = getSHA1Hash(u_pass);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        System.out.println("SHA1加密后的密码：" + shA1Password);

        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectByTelAndPass(telephone,shA1Password);

            if (user == null || !user.getTelephone().equals(telephone) && !user.getU_pass().equals(shA1Password)) {
                // 如果没有找到用户或用户名或密码错误，则重定向到错误页面
                String message = "手机号不存在或手机号密码错误";
                request.setAttribute("message", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
                System.out.println("登录失败");
            } else {
                // 获取用户的角色类型
                String role = user.getRole();
                if ("管理员".equals(role)) {
                    // 如果用户角色是管理员，则重定向到管理员页面
                    request.getSession().setAttribute("user",user);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                } else if ("发布者".equals(role)) {
                    // 如果用户角色是发布者，则重定向到发布者页面
                    request.getSession().setAttribute("user",user);
                    request.getRequestDispatcher("publisher.jsp").forward(request,response);
                } else if ("学生".equals(role)) {
                    // 如果用户角色是学生，则重定向到学生页面
                    request.getSession().setAttribute("user",user);
                    //分页
                    PageHelper.startPage(1,5);
                    request.getSession().setAttribute("pageSize",5);
                    //查询所有job
                    List<Job_Publisher> AllJob = jobService.SelectJob_publish();
                    request.getSession().setAttribute("url","StuShowJob");
                    PageInfo<Job_Publisher> info = new PageInfo<>(AllJob);
                    request.getSession().setAttribute("info",info);
                    request.getRequestDispatcher("student.jsp").forward(request,response);
                }
                else {
                    // 如果角色类型未知，则重定向到错误页面
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                }
            }
            session.commit();
        } catch (Exception e) {
            // 处理异常，返回错误页面和错误信息给用户
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }
    }

    private String getSHA1Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return bytesToHex(digest); // 将字节数组转换为十六进制字符串
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
