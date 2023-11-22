<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/11/8
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <style>
        body {
            background-image: url("img/register1.jpg");
        }
        .admin-main {
            padding-top: 0px;
        }
        #old_pass,#new_pass,#new_pass2{
            width: 50%;
        }
    </style>
</head>
<body>
<div class="am-g">
    <form class="am-form am-form-horizontal"
          method="post"
          style="padding-top:30px;" data-am-validator>
        <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label">原密码 </label>
            <div class="am-u-sm-9">
                <input type="password" id="old_pass" required placeholder="请输入原密码" name="u_pass">
            </div>
        </div>
        <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label"> 新密码 </label>
            <div class="am-u-sm-9">
                <input type="password" id="new_pass" required placeholder="请输入新密码" name="u_pass">
            </div>
        </div>
        <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label">确认密码</label>
            <div class="am-u-sm-9">
                <input type="password" id="new_pass2" required placeholder="请确认密码" name="u_pass">
            </div>
        </div>
        <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
                <input type="submit" class="am-btn am-btn-success" value="修改密码" onclick="submitForm()"/>
            </div>
        </div>
    </form>
</div>
<script>
    function submitForm() {
        var u_id = document.getElementById("u_id").value;
        var old_pass = document.getElementById("old_pass").value;
        var new_pass = document.getElementById("new_pass").value;
        var new_pass2 = document.getElementById("new_pass2").value;

        if (new_pass != new_pass2) {
            alert("两次输入的密码不一致");
            return false;
        }

        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                alert(xmlhttp.responseText);
            }
        }
        xmlhttp.open("POST", "/updatePwd", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("u_id=" + u_id + "&old_pass=" + old_pass + "&new_pass=" + new_pass);
    }
</script>
</body>
</html>
