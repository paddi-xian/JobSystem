<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/6
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
    <style>
        body{
            background-image: url("img/register1.jpg");
        }
        .login{
            width: 400px;
            margin: 0 auto;
        }
        .login-form>input{
            display: block;
            width: 98%;
            height: 40px;
            margin: 20px auto;
            border: 0;
            border-bottom: 1px solid #ccc;
            padding: 0 1%;
        }
        .login-btn{
            background: #222;
            color: #f1f1f1;
            font-size: 20px;
            width: 100% !important;
            height: 50px !important;
            margin: 20px 0 !important;
            padding: 0;
        }
        .register-link a{
            font-size: 14px;
        }
        .register-link a:hover{
            color: blueviolet;
        }
    </style>
</head>
<body>
    <div class="login">
        <form action="login" method="post" name="login">
            <div class="login-form">
                <h2>欢迎来到学生兼职系统</h2>
                <input type="text" placeholder="your telephone" name="telephone" id="telephone">
                <input type="password" placeholder="password" name="u_pass" id="u_pass">
                <input type="submit" value="Next" class="login-btn">
                <p class="register-link"><a href="register.jsp">请先注册</a></p>
                <p id="msg"></p>
            </div>
        </form>
    </div>
</body>
</html>
