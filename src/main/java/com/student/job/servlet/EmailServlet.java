package com.student.job.servlet;

import com.student.job.utils.Mail;
import com.student.job.utils.MailUtils;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "EmailServlet", value = "/EmailServlet")
public class EmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 创建一个随机数生成器
        Random random = new Random();
        // 生成一个在 100000 到 999999 之间的随机数
        //String.valueOf强转成字符串
        String randomNumber = String.valueOf(random.nextInt(900000) + 100000);

        //获取前端的邮箱
        String email = request.getParameter("email");

        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().
                    getResourceAsStream("email.properties"));

            /*发件人*/
            String from = properties.getProperty("from");

            /*收件人*/
            String to = email;

            /*主题*/
            String subject = properties.getProperty("subject");

            /*正文,发送验证码*/
            String content = randomNumber;
            /*把验证码存入session，方便后续判断*/
            request.getSession().setAttribute("content",content);

            String host = properties.getProperty("host");

            /*发送人的名字*/
            String username = properties.getProperty("username");

            /*授权码*/
            String password = properties.getProperty("password");

            /*创建一个会话*/
            Session session = MailUtils.createSession(host, username, password);
            /*制作一个Mail*/
            Mail mail = new Mail(from, to, subject, content);
            MailUtils.send(session, mail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
