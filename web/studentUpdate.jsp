<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/10/22
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<html>
<head>
    <title>学生修改信息页面</title>
    <link rel="stylesheet" href="css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <script src="js/layui.js"></script>
    <script src="js/vue.js"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <style>
        textarea {
            eight: 50px;
            padding: 6px 10px;
            resize: vertical;
            min-height: 10px;
        }
        body {
            overflow-y: scroll;
        }
        crollbar[orientation="vertical"] {
            width: 10px; /* 设置滚动条宽度 */
            background-color: #f0f0f0; /* 设置滚动条背景颜色 */
            position: absolute; /* 设置滚动条位置为绝对定位 */
            right: 0; /* 设置滚动条距离容器右边的距离 */
            top: 0; /* 设置滚动条距离容器上边的距离 */
        }
    </style>
</head>
<body>
<div id="app" class="layui-content">
    <scrollbar orientation="vertical"></scrollbar>
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-header">初次登录请新增信息</div>
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
            <input type="text" id="s_age" name="s_age" v_model="student.s_age"  placeholder=""  value="${student.s_age}" class="layui-input">
        </div>
    </div>
<%--    修改电话--%>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" id="s_phone" name="s_phone" onblur="validateInput()"
                   v_model="student.s_phone" placeholder=""  value="${student.s_phone}"  class="layui-input">
        </div>
    </div>
<%--    修改邮箱--%>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" id="s_email" name="s_email"
                   v_model="student.s_email" placeholder=""  value="${student.s_email}"  class="layui-input">
        </div>
    </div>
<%--    修改简介--%>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">简介</label>
                    <div class="layui-input-block">
                        <textarea id="s_intro" style=" min-height: 10px;" name="s_intro" v_model="student.s_intro" placeholder="${student.s_intro}" value=""  class="layui-textarea"></textarea>
                    </div>
                </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">就读经历</label>
        <div class="layui-input-block">
            <textarea id="s_college" style=" min-height: 10px;" name="s_college" v_model="student.s_college" placeholder="${student.s_college}" value=""  class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">获奖经历</label>
        <div class="layui-input-block">
            <textarea id="s_prize" style=" min-height: 10px;" name="s_prize" v_model="student.s_prize" placeholder="${student.s_prize}" value=""  class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">工作经历</label>
        <div class="layui-input-block">
            <textarea id="s_experience" style=" min-height: 10px;" name="s_experience" v_model="student.s_experience" placeholder="${student.s_experience}" value=""  class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">求职意向</label>
        <div class="layui-input-block">
            <textarea id="s_job" style=" min-height: 10px;" name="s_job" v_model="student.s_job" placeholder="${student.s_job}" value=""  class="layui-textarea"></textarea>
        </div>
    </div>
                <div class="layui-form-item" style="margin-top: 20px " >
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
            s_name: $('#s_name').val(),
            s_gender: $('#s_gender').val(),
            s_age: $('#s_age').val(),
            s_phone: $('#s_phone').val(),
            s_email: $('#s_email').val(),
            s_intro: $('#s_intro').val(),
            s_college: $('#s_college').val(),
            s_prize: $('#s_prize').val(),
            s_experience: $('#s_experience').val(),
            s_job: $('#s_job').val()
            // u_id: $('#u_id').val()
        },
        success: function() {
            alert("修改成功");
        },
        error: function(xhr, status, error) {
            console.log(error); // 如果有错误发生，可以在这里进行错误处理
        }
    });
    function validateInput() {
        var s_phone = document.getElementById("s_phone").value;
        var s_email = document.getElementById("s_email").value;

        // 判断电话号码格式
        var phoneRegex =  /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/; // 这是一个示例电话号码格式
        if (!phoneRegex.test(s_phone)) {
            alert("电话号码格式不正确");
            document.getElementById("s_phone").value = ""; // 清除电话号码输入框的内容
            return;
        }

        // 判断邮箱格式
        var emailRegex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; // 这是一个示例邮箱格式
        if (!emailRegex.test(s_email)) {
            alert("邮箱格式不正确");
            document.getElementById("s_email").value = ""; // 清除邮箱输入框的内容
            return;
        }
    }

</script>
</body>
</html>
