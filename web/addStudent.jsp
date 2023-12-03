<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/11/5
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入信息界面</title>
    <link rel="stylesheet" href="css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <script src="js/layui.js"></script>
    <script src="js/vue.js"></script>
    <script src="js/script.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <style>
        label{
            font-weight: bold;
            font-size: 15px;
        }
        .am-form-group{
            margin-top: 10px;
        }
       /*input{*/
       /*     width:25px ;*/
       /*     height:35px;*/
       /* }*/
    </style>
</head>
<body>
<div  class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">

            <div class="am-g">
                <form class="am-form am-form-horizontal" action="addStudServlet" method="post"
                     >
                    <div class="forlable"  style="padding-top: 5px;margin-left: 150px">
                    <input value="504" name="roleId" type="hidden">
                    <div class="am-form-group">
                        <label for="s_name" class="am-u-sm-3 am-form-label">姓名</label>
                        <div class="am-u-sm-9">
                            <input id="s_name" v-model="student.s_name" required="" placeholder="输入你的真实名字" value=""
                                    name="s_name" type="text">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="s_gender" class="am-u-sm-3 am-form-label">性别</label>
                        <div class="am-u-sm-9">
                            <input id="s_gender" v-model="student.s_gender" required=""
                                   placeholder="输入性别" value="" name="s_gender" type="text">
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="s_age" class="am-u-sm-3 am-form-label">年龄</label>
                        <div class="am-u-sm-9">
                            <input id="s_age" v-model="student.s_age" required="" placeholder="输入年龄"
                                   value="" name="s_age" type="text">
                        </div>
                    </div>
<%--                    <form onsubmit="return validateInput()">--%>
                    <div class="am-form-group">
                        <label for="s_phone" class="am-u-sm-3 am-form-label">电话号码</label>
                        <div class="am-u-sm-9">
                            <input id="s_phone" v-model="s_phone"  required=""
                                   onblur="validateInput()"  value="${user.telephone}" name="s_phone" type="text" readonly>
                        </div>
                           </div>
                    <div class="am-form-group">
                        <label for="s_email" class="am-u-sm-3 am-form-label">邮箱</label>
                        <div class="am-u-sm-9">
                            <input id="s_email" v-model="s_email"  required=""
                                   value="${user.email}" name="s_email" type="text"readonly>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="s_intro" class="am-u-sm-3 am-form-label">简介</label>
                        <div class="am-u-sm-9">
                            <input id="s_intro" v-model="student.s_intro" required="" placeholder="请输入你的简介"
                                   value="" name="s_intro" type="text">
                        </div>
                    </div>

                        <div class="am-form-group">
                            <label for="s_college" class="am-u-sm-3 am-form-label">就读经历</label>
                            <div class="am-u-sm-9">
                                <input id="s_college" v-model="student.s_college" required="" placeholder="请输入你的就读经历"
                                       value="" name="s_college" type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="s_prize" class="am-u-sm-3 am-form-label">获奖经历</label>
                            <div class="am-u-sm-9">
                                <input id="s_prize" v-model="student.s_prize" required="" placeholder="请输入你的获奖经历"
                                       value="" name="s_prize" type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="s_experience" class="am-u-sm-3 am-form-label">工作经历</label>
                            <div class="am-u-sm-9">
                                <input id="s_experience" v-model="student.s_experience" required="" placeholder="请输入你的工作经历"
                                       value="" name="s_experience" type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="s_job" class="am-u-sm-3 am-form-label">求职意向</label>
                            <div class="am-u-sm-9">
                                <input id="s_job" v-model="student.s_job" required="" placeholder="请输入你的求职意向"
                                       value="" name="s_job" type="text">
                            </div>
                        </div>

                        <label><span id="u_idError">${u_idError}</span></label>
                    </div>
                    <div class="layui-form-item" style="margin-top: 30px ;margin-left: 40px">
                        <div class="layui-input-block">
                            <button  type="submit" class="layui-btn layui-btn-blue"lay-submit  lay-filter="formDemo" @click="addStudent">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                    <label><span id="uidError">${uidError}</span></label><br>

                </form>
            </div>
            </div>
    </div>
</div>
</body>
<script>
    function checkStudent(u_id,
                          s_name,
                          s_gender,
                          s_age,
                          s_phone,
                          s_email,
                          s_intro,
                          s_college,s_prize,s_experience,s_job) {
        $.ajax({
            url: "/addStudServlet",
            method: "Post",
            data:{ s_name: s_name,
                s_gender: s_gender,
                s_age: s_age,
                s_phone: s_phone,
                s_email:s_email,
                s_intro:s_intro, s_college:s_college,
                s_prize:s_prize,s_experience:s_experience,s_job:s_job},
            success:function (){
                console.log("添加成功");
            },
            error:function (){
                console.log("添加失败");
            }
        })
    }

</script>
</html>
