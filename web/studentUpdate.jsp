<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/10/22
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>学生修改信息页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/app.css">
    <script src="js/vue.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <script src="js/layui.js"></script>
</head>
<body>
<div id="app" class="layui-content">
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-header">修改个人信息</div>
            <form class="layui-form layui-card-body" action="updateStudent" method="post">
<%--                修改姓名--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">学生姓名</label>
                    <div class="layui-input-block">
                        <input type="text" id="s_name" name="s_name" v_model="student.s_name" value="${student.s_name}" value=""   class="layui-input">
                    </div>
                </div>
<%--    修改性别--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
<%--                     <select id="s_gender" v_model="student.s_gender">--%>
<%--                     <option value="男">男性</option>--%>
<%--                        <option value="女">女性</option>--%>
<%--                     </select>--%>
    <input type="text" id="s_gender" name="s_gender" v_model="student.s_gender" value="${student.s_gender}" value=""   class="layui-input">
                    </div>
                </div>
<%--    修改年龄--%>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" id="s_age" name="s_age" v_model="student.s_age"  placeholder="${student.s_age}"  value="" class="layui-input">
        </div>
    </div>
<%--    修改电话--%>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" id="s_phone" name="s_phone" onblur="validateInput()"
                   v_model="student.s_phone" placeholder="${student.s_phone}"  value=""  class="layui-input">
        </div>
    </div>
<%--    修改邮箱--%>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" id="s_email" name="s_email" onblur="validateInput()"
                   v_model="student.s_email" placeholder="${student.s_email}"  value=""  class="layui-input">
        </div>
    </div>
<%--    修改简介--%>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">简介</label>
                    <div class="layui-input-block">
                        <textarea id="s_intro" name="s_intro" v_model="student.s_intro" placeholder="${student.s_intro}" value="" placeholder="请输入内容(100字以内)" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
<%--                        <input type="hidden" name="u_id" value="${sessionScope.u_id}">--%>
                        <button  type="submit" value="update" class="layui-btn layui-btn-blue"lay-submit  lay-filter="formDemo" @click="studentUpdate">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../assets/layui.all.js"></script>
<script>
    var form = layui.form
        ,layer = layui.layer;
    $.ajax({
        url: '/updateStudent',
        type: 'POST',
        data: {
            name: $('#name').val(),
            gender: $('#gender').val(),
            age: $('#age').val(),
            phone: $('#phone').val(),
            email: $('#email').val(),
            intro: $('#intro').val(),
            // u_id: $('#u_id').val()
        },
        success: function(response) {
            // 处理响应数据
        }
    });
    function validateInput() {
        var s_phone = document.getElementById("s_phone").value;
        var s_email = document.getElementById("s_email").value;

        // 判断电话号码格式
        var phoneRegex =  /^(?:13[5-8]|137)\d{9}$/; // 这是一个示例电话号码格式
        if (!phoneRegex.test(s_phone)) {
            alert("电话号码格式不正确,请输入135、138、137开头的11位数字");
            document.getElementById("s_phone").value = ""; // 清除电话号码输入框的内容
            return;
        }

        // 判断邮箱格式
        var emailRegex = /^[^@]+@[^@]+\.(?:com|cn)$/; // 这是一个示例邮箱格式
        if (!emailRegex.test(s_email)) {
            alert("邮箱格式不正确，请输入@字符， 以com或者cn结尾");
            document.getElementById("s_email").value = ""; // 清除邮箱输入框的内容
            return;
        }
    }

</script>
</body>
</html>
