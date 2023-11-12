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
    <script src="js/jquery-3.6.3.min.js"></script>
    <script src="js/layui.js"></script>
</head>
<body>
<div id="app" class="layui-content">
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-header">修改个人信息</div>
            <form class="layui-form layui-card-body" action="/updateStudent" method="post">
<%--                修改姓名--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">学生姓名</label>
                    <div class="layui-input-block">
                        <input type="text" id="s_name" name="s_name" v_model="student.s_name" value="${student.s_name}" value="" required  lay-verify="required"  class="layui-input">
                    </div>
                </div>
<%--    修改性别--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                     <select id="s_gender" v_model="student.s_gender">
                     <option value="男">男性</option>
                        <option value="女">女性</option>
                     </select>
                    </div>
                </div>
<%--    修改年龄--%>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text"id="s_age" name="s_age" v_model="student.s_age"  placeholder="${student.s_age}" required value="" lay-verify="required" class="layui-input">
        </div>
    </div>
<%--    修改电话--%>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" id="s_phone" name="s_phone" v_model="student.s_phone" placeholder="${student.s_phone}" required value="" lay-verify="required"  class="layui-input">
        </div>
    </div>
<%--    修改邮箱--%>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" id="s_email" name="s_email" v_model="student.s_email" placeholder="${student.s_email}" required value="" lay-verify="required" class="layui-input">
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
                        <input  type="button" class="layui-btn layui-btn-blue" id="editRole" lay-submit  value="提交" @click="studentUpdate"/>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
    new Vue({
        el:'#app',
        data:{
            student: {
                s_name: '',
                s_gender: '',
                s_age: '',
                s_phone: '',
                s_email:'',
                s_intro:'',
                u_id: '',
            }
        },
        methods:{
            studentUpdate(){
                console.log(JSON.parse(sessionStorage.getItem("student")))
                // this.job.j_id = JSON.parse(sessionStorage.getItem("job")).j_id;
                // this.student.u_id=JSON.parse(sessionStorage.getItem("u_id")).u_id;
                this.student.s_id=JSON.parse(sessionStorage.getItem("s_id")).s_id;

                axios.post('StudentServlet',this.student)
                    .then(response => {
                        if(response.data == false){
                            // response.data.forEach((item))=>{
                            console.log(response.data)
                            this.student.s_id = response.data;
                            console.log(this.student.s_id)
                            alert("修改失败！！")
                            return;
                        }else{
                            console.log(response.data)
                            this.student.s_id = response.data;
                            console.log(this.student.s_id)
                            alert("修改成功")
                        }
                        parent.postMessage("closeStudentUpdate","http:localhost:8080/job_system_war_exploded/")
                    })
                    .catch(error =>{
                        console.error(error);
                    });
            },
        }
    })
</script>
</body>
</html>
