<%--
  Created by IntelliJ IDEA.
  User: zyn
  Date: 2023/11/21
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置密码</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery-3.6.3.min.js"></script>
    <style>
        body{
            background-image: url("img/register1.jpg");
        }
        .admin-main{
            padding-top: 0px;
        }
        .reset{
            width: 400px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="reset">
    <div class="am-g">
        <form action="/resetPass" class="am-form am-form-horizontal" method="post" style="padding-top:30px;" data-am-validator onsubmit="confirmPass()">
            <h2 style="text-align: center">重置密码</h2>
            <div class="am-form-group">
                <label class="am-u-sm-3 am-form-label">新密码</label>
                <div class="am-u-sm-9">
                    <input type="password" id="newPass" required placeholder="请输入新密码" name="newPass">
                </div>
            </div>
            <div class="am-form-group">
                <label class="am-u-sm-3 am-form-label">确认密码</label>
                <div class="am-u-sm-9">
                    <input type="password" id="newPass2" required placeholder="请确认密码" name="newPass2">
                </div>
            </div>
            <div class="am-form-group">
                <div class="am-u-sm-9 am-u-sm-push-3">
                    <input type="submit" class="am-btn am-btn-success" value="确认密码" onclick="confirmPass()"/>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function confirmPass(){
        var newPass = $('#newPass').val();
        var newPass2 = $('#newPass2').val();

        if(newPass != newPass2) {
            alert("两次输入的密码不一致，请重新输入！");
            return false; //阻止表单提交
        }
        // 如果新密码和确认密码匹配，提交表单
        alert("密码重置成功")
        return true;
    }
</script>
</body>
</html>
