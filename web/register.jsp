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
    </style>
</head>
<body>
    <div class="login">
        <form action="register" method="post" name="login">
            <div class="login-form">
                <h2>欢迎来到学生兼职系统</h2>
                <p>请先注册</p>
                <input type="text" placeholder="your id" name="u_id" id="u_id">
                <input type="text" placeholder="your name" name="u_name" id="u_name">
                <input type="password" placeholder="password" name="u_pass" id="u_pass">
                <input type="text" placeholder="telephone" name="telephone" id="telephone">
                <label for="role">请选择用户类型:</label>
                <select id="role" name="role">
                    <option value="学生">学生</option>
                    <option value="发布者">发布者</option>
                    <option value="管理员">管理员</option>
                </select><br>
                <input type="submit" value="Join US" class="login-btn" id="btn">
                <p id="msg"></p>
            </div>
        </form>
    </div>
    <script>
        window.onload = function (){
            document.getElementById("btn").onclick = function (){
                //1.创建ajax对象
                var xhr = new XMLHttpRequest();
                //2.注册回调函数
                xhr.onreadystatechange = function (){
                    if(this.readyState == 4){
                        if(this.status == 200){
                            document.getElementById("login-form").innerHTML = this.responseText
                        }else {
                            alert(this.status)
                        }
                    }
                }
                //3.开启通道
                xhr.open("POST","/register",true)
                //4.发送请求
                //模拟AJAX提交form表单数据
                //设置请求头的内容类型时，必须在open之后
                xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded")
                //放到send()这个函数的小括号当中的数据，会自动在请求体当中提交数据
                //使用JS代码获取用户填写的用户名和密码
                var u_id = document.getElementById("u_id").value;
                var u_name = document.getElementById("u_name").value;
                var u_pass = document.getElementById("u_pass").value;
                var telephone = document.getElementById("telephone").value;
                var role = document.getElementById("role").value;
                //xhr.send("遵循HTTP协议username=xxx&password=xxx")
                xhr.send("u_id="+u_id+"&u_name="+u_name+"u_pass="+u_pass+"&telephone="+telephone+"role="+role)
            }
        }
    </script>
</body>
</html>
