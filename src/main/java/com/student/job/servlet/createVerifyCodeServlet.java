package com.student.job.servlet;

import com.student.job.utils.Verify;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "createVerifyCodeServlet", value = "/createVerifyCodeServlet")
public class createVerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Verify.getVerify(request,response);
    }

}
