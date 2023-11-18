<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/10
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加兼职岗位页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/app.css">
    <script src="js/vue.js"></script>
    <script src="js/axios.js"></script>
    <script src="js/jquery-3.6.3.min.js"></script>
    <style>
        .admin-main {
            padding-top: 0px;
        }
    </style>
</head>
<body>
<div id="app" class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-g">
                <form class="am-form am-form-horizontal" style="padding-top: 30px;">
                    <input value="504" name="roleId" type="hidden">
                    <div class="am-form-group">
                        <label for="j_name" class="am-u-sm-3 am-form-label">兼职岗位名称</label>
                        <div class="am-u-sm-9">
                            <input id="j_name" v-model="job.j_name"  placeholder="输入兼职岗位名称" class="verify"
                                   name="j_name" type="text">
                            <div id="is_j_name"></div>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="j_description" class="am-u-sm-3 am-form-label">兼职岗位描述</label>
                        <div class="am-u-sm-9">
                            <input id="j_description" v-model="job.j_description"
                                   placeholder="输入兼职岗位描述" class="verify" name="j_description" type="text">
                            <div id="is_j_description"></div>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="j_salary" class="am-u-sm-3 am-form-label">兼职岗位薪资</label>
                        <div class="am-u-sm-9">
                            <input id="j_salary" v-model="job.j_salary"  placeholder="输入兼职岗位薪资"
                                   class="verify" name="j_salary" type="text" />
                            <div id="is_j_salary"></div>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <label for="j_hours" class="am-u-sm-3 am-form-label">兼职岗位工作时间</label>
                        <div class="am-u-sm-9">
                            <input id="j_hours" v-model="job.j_hours"  placeholder="输入兼职岗位工作时间"
                                   class="verify" name="j_hours" type="text" />
                            <div id="is_j_hours"></div>
                        </div>
                    </div>

                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
                            <input type="button" id="addRole" class="am-btn am-btn-success" value="提交" @click="addJob"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    let bool = false;
    new Vue({
        el: "#app",
        data: {
            job: {
                j_name: '',
                j_description: '',
                j_salary: '',
                j_hours: '',
                u_id: '',
            },

        },
        methods: {
            addJob() {
                if(!verifyjName() || !verifyjDescription() || !verifyjSalary() || !verifyjHours()){
                    return;
                }
                var ok = window.confirm("是否确认添加？");
                if(ok){
                    axios.post('addJobServlet', this.job)
                        .then(response => {
                            if (response.data == false) {
                                console.log(response.data)
                                this.job.u_id = response.data;
                                console.log(this.job.u_id)
                                alert("增加失败!!!")
                                return;
                            } else {
                                console.log(response.data)
                                this.job.u_id = response.data;
                                console.log(this.job.u_id)
                                alert("添加成功")
                                //给父页job.jsp传递关闭该子页的信息
                                parent.postMessage("closeAddJob","http:localhost:8080/job_system_war_exploded/")
                            }
                        })
                        .catch(error => {
                            console.error(error);
                        });
                }


            },
        }
    })
    $(function(){
        $(".verify").focus(function (){
            let id = $(this).attr("id");
            id = "is_" + id;
            $("#"+id).text("");
        });
        $("#j_name").blur(function (){
            verifyjName();
        });
        $("#j_description").blur(function (){
            verifyjDescription();
        });
        $("#j_salary").blur(function (){
            verifyjSalary();
        });
        $("#j_hours").blur(function (){
            verifyjHours();
        });
    });
    function verifyjName(){
        let value = $("#j_name").val();
        if(value === ""){
            $("#is_j_name").text("兼职岗位名称不能为空").css({'color':'red'});
            return  false;
        }else{
            return  true;
        }
    }
    function verifyjDescription(){
        let value = $("#j_description").val();
        if(value === ""){
            $("#is_j_description").text("兼职岗位描述不能为空").css({'color':'red'});
            return  false;
        }else{
            return  true;
        }
    }
    function verifyjSalary(){
        let value = $("#j_salary").val();
        let regex = /^(?:\d+|\d{1,}[.,]\d+)$/;
        if(value === ""){
            $("#is_j_salary").text("兼职岗位薪资不能为空").css({'color':'red'});
            return  false;
        }
        if(!regex.test(value)){
            $("#is_j_salary").text("您输入的格式不对").css({'color':'red'});
            return  false;
        }else{
            return  true;
        }
    }
    function verifyjHours(){
        let value = $("#j_hours").val();
        let regex = /^\d+$/;
        if(value === ""){
            $("#is_j_hours").text("兼职岗位工作时间不能为空").css({'color':'red'});
            return  false;
        }
        if(!regex.test(value)){
            $("#is_j_hours").text("您输入的格式不对").css({'color':'red'});
            return  false;
        }else{
            return  true;
        }
    }
</script>
</html>
