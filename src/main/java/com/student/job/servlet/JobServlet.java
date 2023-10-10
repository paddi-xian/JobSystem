package com.student.job.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/dept/list".equals(servletPath)){
            doList(request,response);
        }else if("/dept/detail".equals(servletPath)){
            doDetail(request,response);
        }else if("/dept/delete".equals(servletPath)){
            doDel(request,response);
        }else if("/dept/save".equals(servletPath)){
            doSave(request,response);
        }else if("/dept/modify".equals(servletPath)){
            doModify(request,response);
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) {
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) {

    }

    private void doSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String contextPath = request.getContextPath();

        String j_id = request.getParameter("j_id");
        String j_name = request.getParameter("j_name");
        String j_description = request.getParameter("j_description");
        String j_salary = request.getParameter("j_salary");
        String j_hours = request.getParameter("j_hours");

    }

    private void doModify(HttpServletRequest request, HttpServletResponse response) {
    }
}
