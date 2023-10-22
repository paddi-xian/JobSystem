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
        span{
            color:red;
            font-size: 12px;
        }
    </style>
</head>
    <div class="login">
        <form action="/register" method="post" name="login" id="loginForm">
            <div class="login-form">
                <h2>欢迎来到学生兼职系统</h2>
                <input type="text" placeholder="您的用户名" name="u_name" id="u_name" required>
                <label><span id="u_nameError"></span></label><br>
                <input type="password" placeholder="请输入密码" name="u_pass" id="u_pass" ><br>
                <input type="password" placeholder="请确认密码" name="u_pass2" id="u_pass2"><br>
                <label><span id="u_passError"></span></label><br>
                <input type="text" placeholder="输入手机号" name="telephone" id="telephone" required><br>
                <label><span id="telephoneError"></span></label><br>
                <label for="role">请选择用户类型:</label>
                <select id="role" name="role">
                    <option value="学生">学生</option>
                    <option value="发布者">发布者</option>
                    <option value="管理员">管理员</option>
                </select><br>
                <input type="submit" value="注册" class="login-btn" id="btn">
                <span id="myspan"></span>
            </div>
        </form>
    </div>
    <script>
        window.onload = function(){
            //获取u_name的span标签
            var u_nameErrorSpan = document.getElementById("u_nameError");
            //给用户名绑定blur事件
            var u_nameElt = document.getElementById("u_name");
            u_nameElt.onblur = function(){
                //获取用户名
                var u_name = u_nameElt.value;
                //去除前后空白
                u_name = u_name.trim();
                if(u_name === ""){
                    //用户名为空
                    u_nameErrorSpan.innerText = "用户名不能为空";
                }else{
                    //用户名不为空
                    //继续判断长度[6-14]
                    if(u_name.length < 2 || u_name.length > 10){
                        //用户名长度非法
                        u_nameErrorSpan.innerText = "用户名长度必须在[2-10]之间";
                    }else{
                        //用户名长度合法
                        //继续判断是否含有特殊符号
                        var regExp = /^[\u4e00-\u9fa5a-zA-Z0-9]+$/;
                        var ok = regExp.test(u_name);
                        if(ok){
                            //用户名最终合法
                        }else{
                            //用户名含有特殊符号
                            u_nameErrorSpan.innerText = "用户名只能由汉字或数字或字母组成";
                        }
                    }
                }
            }
            //给u_name这个文本框绑定获得焦点事件
            u_nameElt.onfocus = function(){
                //清空非法的value
                if(u_nameErrorSpan.innerText != ""){
                    u_nameElt.value = "";
                }
                //清空span
                u_nameErrorSpan.innerText = "";
            }

            //获取密码错误提示的span标签
            var u_passErrorSpan = document.getElementById("u_passError");
            //获取确认密码对象
            var u_pass2Elt = document.getElementById("u_pass2");
            //绑定blur事件
            u_pass2Elt.onblur = function(){
                //获取密码和确认密码
                var u_passElt = document.getElementById("u_pass");
                var u_pass = u_passElt.value;
                var u_pass2 = u_pass2Elt.value;
                if(u_pass != u_pass2){
                    //密码不一致
                    u_passErrorSpan.innerText = "密码不一致";
                }else{
                    //密码一致
                    u_passErrorSpan.innerText = "密码一致";
                }
            }
            //绑定focus事件
            u_pass2Elt.onfocus = function(){
                if(u_passErrorSpan.innerText != ""){
                    u_pass2Elt.value = "";
                }
                u_passErrorSpan.innerText = "";
            }

            //获取telephone的span
            var telephoneSpan = document.getElementById("telephoneError");
            //给telephone绑定blur事件
            var telephoneElt = document.getElementById("telephone");
            telephoneElt.onblur = function(){
                //获取telephone
                var telephone = telephoneElt.value;
                //编写telephone的正则
                var telephoneRegEXp = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                var ok = telephoneRegEXp.test(telephone);
                if(ok){
                    //合法
                }else{
                    //不合法
                    telephoneSpan.innerText="手机号不合法";
                }
            }
            //给telephoneElt绑定focus
            telephoneElt.onfocus = function(){
                if(telephoneSpan.innerText != ""){
                    telephoneElt.value = "";
                }
                telephoneSpan.innerText = "";
            }

            //给提交按钮绑定鼠标单击事件
            var submitBtnElt = document.getElementById("btn");
            btn.onclick = function(){
                //不需要人工操作，使用纯JS代码触发事件
                u_nameElt.focus();
                u_nameElt.blur();

                u_pass2Elt.focus();
                u_pass2Elt.blur();

                telephoneElt.focus();
                telephoneElt.blur();
            }
        }
    </script>
</body>
</html>
