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

        textarea {
            eight: 50px;
            padding: 6px 10px;
            resize: vertical;
            min-height: 10px;
        }
       /*input{*/
       /*     width:25px ;*/
       /*     height:35px;*/
       /* }*/
    </style>
</head>
<body>
<div  id="app" class="layui-content">
    <!-- content start -->
    <div class="layui-row">
        <div class="layui-card" >
            <div class="am-g">
                <form class="am-form am-form-horizontal" action="addStudServlet" method="post">
                    <input value="504" name="roleId" type="hidden">
                    <div class="layui-form-item">
                        <label for="s_name" class="layui-form-label">姓名</label>
                        <div class="layui-input-block">
                            <input id="s_name" v-model="student.s_name" required="" placeholder="输入你的真实名字" value=""
                                    name="s_name" type="text">
                        </div>
                    </div>

                        <div class="layui-form-item">
                        <label for="s_gender" class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input id="s_gender" v-model="student.s_gender" required=""
                                   placeholder="输入性别" value="" name="s_gender" type="text">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label for="s_age" class="layui-form-label">年龄</label>
                        <div class="layui-input-block">
                            <input id="s_age" v-model="student.s_age" required="" placeholder="输入年龄"
                                   value="" name="s_age" type="text">
                        </div>
                    </div>
<%--                    <form onsubmit="return validateInput()">--%>
                        <div class="layui-form-item">
                        <label for="s_phone" class="layui-form-label">电话号码</label>
                        <div class="layui-input-block">
                            <input id="s_phone" v-model="s_phone"  required=""
                                   onblur="validateInput()"  value="${user.telephone}" name="s_phone" type="text" readonly>
                        </div>
                           </div>
                    <div class="layui-form-item">
                        <label for="s_email" class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input id="s_email" v-model="s_email"  required=""
                                   value="${user.email}" name="s_email" type="text"readonly>
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label for="s_intro" class="layui-form-label">简介</label>
                        <div class="layui-input-block">
                            <textarea id="s_intro"style=" min-height: 10px;" v-model="student.s_intro" required="" placeholder="请输入你的简介"
                                   class="layui-textarea"  value="" name="s_intro" type="text"></textarea>
                        </div>
                    </div>

                        <div class="layui-form-item layui-form-text">
                            <label for="s_college" class="layui-form-label">就读经历</label>
                            <div class="layui-input-block">
                                <textarea id="s_college" style=" min-height: 10px;" v-model="student.s_college" required="" placeholder="请输入你的就读经历"
                                          class="layui-textarea"       value="" name="s_college" type="text"></textarea>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label for="s_prize" class="layui-form-label">获奖经历</label>
                            <div class="layui-input-block">
                                <textarea id="s_prize" style=" min-height: 10px;" v-model="student.s_prize" required="" placeholder="请输入你的获奖经历"
                                          class="layui-textarea"   value="" name="s_prize" type="text"></textarea>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label for="s_experience" class="layui-form-label">工作经历</label>
                            <div class="layui-input-block">
                                <textarea id="s_experience" style=" min-height: 10px;" v-model="student.s_experience" required="" placeholder="请输入你的工作经历"
                                          class="layui-textarea"   value="" name="s_experience" type="text"></textarea>
                            </div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label for="s_job" class="layui-form-label">求职意向</label>
                            <div class="layui-input-block">
                                <textarea id="s_job"style=" min-height: 10px;"  v-model="student.s_job" required="" placeholder="请输入你的求职意向"
                                          class="layui-textarea"       value="" name="s_job" type="text"></textarea>
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
<%--            <label><span id="success">${success}</span></label><br>--%>

                </form>
            </div>
            </div>
    </div>
</div>
</body>
<script>
    // new Vue({
    //     el : "app",
    //     methods:{
    //
    //     }
    // }
    // )
    // function checkStudent(u_id,
    //                       s_name,
    //                       s_gender,
    //                       s_age,
    //                       s_phone,
    //                       s_email,
    //                       s_intro,
    //                       s_college,s_prize,s_experience,s_job) {
    //     $.ajax({
    //         url: "/addStudServlet",
    //         method: "Post",
    //         data:{ s_name: s_name,
    //             s_gender: s_gender,
    //             s_age: s_age,
    //             s_phone: s_phone,
    //             s_email:s_email,
    //             s_intro:s_intro, s_college:s_college,
    //             s_prize:s_prize,s_experience:s_experience,s_job:s_job},
    //         success:function (){
    //             console.log("添加成功");
    //         },
    //         error:function (){
    //             console.log("添加失败");
    //         }
    //     })
    // }

</script>
</html>
