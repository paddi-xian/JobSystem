<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="js/jquery-3.6.3.min.js"></script>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <style>
        body {
            background-image: url("img/register1.jpg");
        }
        .admin-main {
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
        <form class="am-form am-form-horizontal" method="post" style="padding-top:30px;" data-am-validator>
            <h2 style="text-align: center">修改密码</h2>
            <div class="am-form-group">
                <label for="old_pass" class="am-u-sm-3 am-form-label">原密码</label>
                <div class="am-u-sm-9">
                    <input type="password" id="old_pass" required placeholder="请输入原密码">
<%--                    <label><span id="telephoneError">${message}</span></label>--%>
                    <c:if test="${not empty message}">
                        <span id="message">${message}</span>
                    </c:if>
                </div>
            </div>
            <div class="am-form-group">
                <label for="new_pass" class="am-u-sm-3 am-form-label">新密码</label>
                <div class="am-u-sm-9">
                    <input type="password" id="new_pass" required placeholder="请输入新密码" >
                </div>
            </div>
            <div class="am-form-group">
                <label for="confirmPwd" class="am-u-sm-3 am-form-label">确认密码</label>
                <div class="am-u-sm-9">
                    <input type="password" id="confirmPwd" required placeholder="请确认密码" >
                </div>
            </div>
            <div class="am-form-group">
                <div class="am-u-sm-9 am-u-sm-push-3">
<%--                    <button type="button" class="am-btn am-btn-success"  id="update">修改密码</button>--%>
                    <input type="submit" class="am-btn am-btn-success" value="修改密码" id="update"/>
                </div>
            </div>
        </form>
    </div>
</div>


<script>
    $(function () {
        //修改密码
        $("#update").on("click", function () {
            if ($.trim($("#old_pass").val()) == "") {
                alert("原密码不能为空");
                return;
            }
            if ($.trim($("#new_pass").val()) == "") {
                alert("新密码不能为空");
                return;
            }
            if ($.trim($("#confirmPwd").val()) == "") {
                alert("确认密码不能为空");
                return;
            }

            if ($.trim($("#old_pass").val()) == $.trim($("#new_pass").val())) {
                alert("新密码与原密码不能一致");
                return
            }

            $.ajax({
                type: "post",
                url: "/updatePwd",
                dataType: "json",
                data: {
                    new_pass: $("#new_pass").val(),
                    old_pass: $("#old_pass").val(),
                },
                success: function (result) {
                    if (result == 1 ) {
                        alert("修改成功")
                    } else {
                        alert("修改失败")
                    }
                    parent.postMessage("closeUpdatePwd","http:localhost:8081/job_system_war_exploded/")
                }
            })
        })
    });

</script>
</body>
</html>
