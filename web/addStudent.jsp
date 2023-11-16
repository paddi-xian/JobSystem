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
</head>
<body>
<div  class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-g">
                <form class="am-form am-form-horizontal" action="addStudServlet" method="post"
                      style="padding-top: 20px;">

                    <input value="504" name="roleId" type="hidden">
                    <div class="am-form-group">
                        <label for="s_name" class="am-u-sm-3 am-form-label">姓名</label>
                        <div class="am-u-sm-9">
                            <input id="s_name" v-model="student.s_name" required="" placeholder="输入你的名字" value=""
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

                    <div class="am-form-group">
                        <label for="s_phone" class="am-u-sm-3 am-form-label">电话号码</label>
                        <div class="am-u-sm-9">
                            <input id="s_phone" v-model="student.s_phone" required="" placeholder="请输入你的联系电话"
                                   value="" name="s_phone" type="text">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="s_phone" class="am-u-sm-3 am-form-label">邮箱</label>
                        <div class="am-u-sm-9">
                            <input id="s_email" v-model="student.s_email" required="" placeholder="请输入你的邮箱"
                                   value="" name="s_email" type="text">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="s_intro" class="am-u-sm-3 am-form-label">简介</label>
                        <div class="am-u-sm-9">
                            <input id="s_intro" v-model="student.s_intro" required="" placeholder="请输入你的简介"
                                   value="" name="s_intro" type="text">
                        </div>
                    </div>
                    <label><span id="u_idError">${u_idError}</span></label>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button  type="submit" class="layui-btn layui-btn-blue"lay-submit  lay-filter="formDemo" @click="addStudent">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                    <label><span id="uidError">${uidError}</span></label><br>

                <%--                    <div class="am-form-group">--%>
<%--                        <div class="am-u-sm-9 am-u-sm-push-3">--%>
<%--                            <input id="addRole" class="am-btn am-btn-success" value="提交" @click="addStudent"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
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
                          s_intro) {
        $.ajax({
            url: "/addStudServlet",
            method: "Post",
            data:{ s_name: s_name,
                s_gender: s_gender,
                s_age: s_age,
                s_phone: s_phone,
                s_email:s_email,
                s_intro:s_intro},
            success:function (){
                console.log("添加成功");
            },
            error:function (){
                console.log("添加失败");
            }
        })
        //
        // $.ajax({
        //     url:"/checkStudent",
        //     method:"GET",
        //     data: {u_id:u_id},
        //     success:function (data) {
        //         if (data.exits){
        //             console.log("请勿重复添加信息");
        //         }else {
        //         }
        //
        //     }
        // })
    }
    // new Vue({
    //     el: "#app",
    //     data: {
    //         student: {
    //             s_name: '',
    //             s_gender: '',
    //             s_age: '',
    //             s_phone: '',
    //             s_email:'',
    //             s_intro:'',
    //             u_id: '',
    //         },
    //
    //     },
    //     methods: {
    //         addStudent() {
    //             axios.post('addStudServlet', this.student)
    //                 .then(response => {
    //                     if (response.data == false) {
    //                         console.log(response.data)
    //                         this.student.u_id = response.data;
    //                         console.log(this.student.u_id)
    //                         alert("增加失败!!!")
    //                         return;
    //                     } else {
    //                         console.log(response.data)
    //                         this.student.u_id = response.data;
    //                         console.log(this.student.u_id)
    //                         alert("添加成功")
    //                     }
    //                 })
    //                 .catch(error => {
    //                     console.error(error);
    //                 });
    //
    //         },
    //     }
    // })

</script>
</html>
