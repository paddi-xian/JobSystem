<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        #message{
            color:red;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <script type="text/javascript" src="js/jquery-3.6.3.min.js"></script>
    <div class="login">
        <form action="login" method="post" id="login">
            <div class="login-form">
                <h2>欢迎来到学生兼职系统</h2>
                <input type="text" placeholder="your telephone" name="telephone" id="telephone" required>
                <input type="password" placeholder="password" name="u_pass" id="u_pass" required>
                <%-- 如果有提示信息，则显示 --%>
                <c:if test="${not empty message}">
                    <span id="message" >${message}</span>
                </c:if>
                <input type="submit" value="Next" class="login-btn">
                <p class="register-link"><a href="register.jsp">没有账号？请先注册</a></p>
                <p class="register-link" style="padding-right: 20px"><a href="forgotPass.jsp">忘记密码</a></p>
            </div>
        </form>
    </div>
    <script>
        window.onload = function (){
            var form = document.getElementById("login");
            form.onsubmit = function (){
                var telephone = form.telephone.value;
                var u_pass = form.u_pass.value;

                // 使用正则表达式校验手机号格式
                //编写telephone的正则
                var telephoneRegEXp = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                if (!telephoneRegEXp.test(telephone)) {
                    alert("手机号格式不正确");
                    return false;
                }
            }
            
            var msgElt = document.getElementById("message");
            var telephoneElt = document.getElementById("telephone");
            var passElt = document.getElementById("u_pass");
            //给telephone这个文本框绑定获得焦点事件
            telephoneElt.onfocus = function(){
                //清空span
                msgElt.innerText = "";
            }
            passElt.onfocus = function(){
                //清空span
                msgElt.innerText = "";
            }
        }
    </script>
</body>
</html>
