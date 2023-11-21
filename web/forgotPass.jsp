<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/11/19
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/layui.css">
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
            background: cornflowerblue;
            color: #f1f1f1;
            font-size: 20px;
            width: 100% !important;
            height: 50px !important;
            margin: 20px 0 !important;
            padding: 0;
        }

    </style>

</head>
<body>
<script type="text/javascript" src="js/jquery-3.6.3.min.js"></script>
    <div class="login">
            <div class="login-form">
                <form action="#" method="post" id="resetPass">
                <h2>忘记密码</h2>
                <div class="layui-form-item">
                    <div class="input-wrap">
                        <input type="text" name="email" value="" lay-verify="required" placeholder="邮箱" lay-reqtext="请填写邮箱" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-row">
                        <div class="layui-col-xs7">
                            <div class="layui-input-wrap">
                                <div class="layui-input-prefix">
                                    <i class="layui-icon layui-icon-cellphone"></i>
                                </div>
                                <input type="text" name="code" value="" placeholder="验证码" lay-reqtext="请填写验证码" autocomplete="off" class="layui-input" id="code">
                            </div>
                        </div>
                        <div class="layui-col-xs5">
                            <div style="margin-left: 59px;">
                                <button type="button" class="layui-btn layui-btn-fluid layui-btn-primary" lay-on="reg-get-vercode">获取验证码</button>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="submit" value="下一步" class="login-btn">
                </form>
            </div>
    </div>
</body>
</html>
