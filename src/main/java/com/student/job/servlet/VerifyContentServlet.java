package com.student.job.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VerifyContentServlet", value = "/VerifyContentServlet")
public class VerifyContentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = (String) request.getSession().getAttribute("content");
        String code = request.getParameter("code");

        if (code.equals(content)) {
            request.getSession().removeAttribute("content");
            response.getWriter().println(true);
        }else {
            response.getWriter().println(false);
        }
    }
}
