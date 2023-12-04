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
        <form class="am-form am-form-horizontal" method="post" action="/updatePwd" style="padding-top:30px;" data-am-validator>
            <h2 style="text-align: center">修改密码</h2>
            <div class="am-form-group">
                <label for="old_pass" class="am-u-sm-3 am-form-label">原密码</label>
                <div class="am-u-sm-9">
                    <input type="password" id="old_pass" required placeholder="请输入原密码">
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
                    <button type="button" class="am-btn am-btn-success"  id="update">修改密码</button>
<%--                    <input type="submit" class="am-btn am-btn-success" value="修改密码" id="confirmPwd"/>--%>
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

            if ($.trim($("#old_pass").val()) == $.trim($("#newPwd").val())) {
                alert("新密码与原密码不能一致");
                return
            }

            // if ($.trim($("#new_pass").val()) == $.trim($("#confirmPwd").val())) {
            //     alert("确认密码需要和新密码一致");
            //     return;
            // }

            $.ajax({
                type: "post",
                url: "/updatePwd",
                dataType: "json",
                data: {
                    newPwd: $("#new_pass").val(),
                    oldPwd: $("#old_pass").val(),
                },
                success: function (data) {
                    if (data.code.trim() == "1") {
                        window.location.href = "/";
                    } else if (data.code.trim() == "0") {
                        alert(data.message)
                    }
                }
            })
        })
    });
    // function submitForm() {
    //     var u_id = document.getElementById("u_id").value;
    //     var old_pass = document.getElementById("old_pass").value;
    //     var new_pass = document.getElementById("new_pass").value;
    //     var new_pass2 = document.getElementById("new_pass2").value;
    //
    //     if (new_pass != new_pass2) {
    //         alert("两次输入的密码不一致");
    //         return false;
    //     }
    //
    //     var xmlhttp = new XMLHttpRequest();
    //     xmlhttp.onreadystatechange = function () {
    //         if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
    //             alert(xmlhttp.responseText);
    //         }
    //     }
    //     xmlhttp.open("POST", "/updatePwd", true);
    //     xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xmlhttp.send("u_id=" + u_id + "&old_pass=" + old_pass + "&new_pass=" + new_pass);
    // }
</script>
</body>
</html>
