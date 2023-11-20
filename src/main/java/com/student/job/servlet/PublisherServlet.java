package com.student.job.servlet;

import com.student.job.mapper.PublisherMapper;
import com.student.job.mapper.StudentMapper;
import com.student.job.pojo.Publisher;
import com.student.job.pojo.Student;
import com.student.job.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/showPublisher","/updatePubServlet","/publisherPerson"})
public class PublisherServlet extends HttpServlet {
    @Override
    protected  void  service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String servletPath =request.getServletPath();
        if ("/showPublisher".equals(servletPath)) {
            doList(request,response);
        }else if ("/updatePubServlet".equals(servletPath)){
            doUpdate(request, response);
        }else if("/publisherPerson".equals(servletPath)){
            doPerson(request,response);
        }
    }


    private   void doPerson(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer u_id = Integer.parseInt(request.getParameter( "u_id"));
        System.out.println(u_id);
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try(SqlSession session =sqlSessionFactory.openSession()){
            PublisherMapper publisherMapper = session.getMapper(PublisherMapper.class);
            Publisher publisher=publisherMapper.getPublisherById(u_id);
            System.out.println(publisher);
            request.getSession().removeAttribute("publisher");
            request.getSession().setAttribute("publisher",publisher);
            request.getRequestDispatcher("publisherPerson.jsp").forward(request,response);
        }
    }

    //查找所有发布者
    protected void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // 获取 mapper
            PublisherMapper publisherMapper = session.getMapper(PublisherMapper.class);
            List<Publisher> publisherList = publisherMapper.getAllPublishers();
            request.setAttribute("publisherList",publisherList);
            System.out.println(publisherList);
            session.commit();
        } catch (Exception e) {
            // 处理异常，返回错误页面和错误信息给用户
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }
        request.getRequestDispatcher("showPublisher.jsp").forward(request,response);
    }
    //更新发布者个人信息
    protected  void  doUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String p_name = request.getParameter("p_name");
        String  p_email = request.getParameter("p_email");
        String p_telephone = request.getParameter("p_telephone");
        String p_address= request.getParameter("p_address");
        String p_introduction= request.getParameter("p_introduction");


        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory();
        try (SqlSession session =sqlSessionFactory.openSession()){
            PublisherMapper publisherMapper = session.getMapper(PublisherMapper.class);
            publisherMapper.updatePublisher(p_name, p_email, p_telephone, p_address, p_introduction);
            session.commit();
        }catch (Exception e){
            request.getRequestDispatcher("error.jsp").forward(request,response);
            e.printStackTrace();
        }finally {
            request.getRequestDispatcher("publisherUpdate.jsp").forward(request,response);

        }



    }
}
