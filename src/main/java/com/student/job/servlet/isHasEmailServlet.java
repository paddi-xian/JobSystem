package com.student.job.servlet;

import com.student.job.service.UserService;
import com.student.job.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "isHasEmailServlet", value = "/isHasEmailServlet")
public class isHasEmailServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Boolean res = userService.isHasEmail(email);
        if (res) {
            response.getWriter().println(true);
        }else  {
            response.getWriter().println(false);
        }
    }
}
