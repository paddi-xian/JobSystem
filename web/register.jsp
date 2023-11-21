<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/6
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        body{
            background-image: url("img/register1.jpg");
        }
        .login{width: 400px;margin: 0 auto;}
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
        span{
            color:red;
            font-size: 13px;
        }
    </style>
</head>
    <div class="login">
        <form action="register" method="post" name="login" id="loginForm">
            <div class="login-form">
                <h2>欢迎来到学生兼职系统</h2>
                <input type="text" placeholder="您的用户名" name="u_name" id="u_name"  required>
                <label><span id="u_nameError"></span></label>
                <input type="password" placeholder="请输入密码" name="u_pass" id="u_pass"  required>
                <input type="password" placeholder="请确认密码" name="u_pass2" id="u_pass2">
                <label><span id="u_passError"></span></label>
                <input type="text" placeholder="输入手机号" name="telephone" id="telephone" required>
                <label><span id="telephoneError">${telephoneError}</span></label>
                <input type="text" placeholder="输入邮箱" name="email" id="email" required>
                <label><span id="emailError"></span></label><br>
                <label for="role">请选择用户类型:</label>
                <select id="role" name="role" >
                    <option value="学生">学生</option>
                    <option value="发布者">发布者</option>
<%--                    <option value="管理员">管理员</option>--%>
                </select><br>
                <input type="submit" value="注册" class="login-btn" id="btn">
                <span id="myspan"></span>
            </div>
        </form>
    </div>
    <script src="js/registerRegx.js"></script>
</body>
</html>
