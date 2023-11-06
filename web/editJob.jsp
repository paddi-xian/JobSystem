<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/6
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改兼职岗位</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/app.css">
    <script src="js/vue.js"></script>
    <script src="js/axios.js"></script>
    <script src="js/jquery-3.6.3.min.js"></script>
    <style>
      .admin-main{
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
                    <form class="am-form am-form-horizontal" action="editJobServlet" method="post" style="padding-top: 30px;">
                        <input value="504" name="roleId" type="hidden">
                        <div class="am-form-group">
                            <label for="j_name" class="am-u-sm-3 am-form-label">兼职岗位名称</label>
                            <div class="am-u-sm-9">
                                <input id="j_name" v-model="job.j_name" required="" placeholder="请输入兼职岗位名称" value="${job.j_name}" name="j_name" type="text">
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="j_description" class="am-u-sm-3 am-form-label">兼职岗位描述</label>
                            <div class="am-u-sm-9">
                                <input id="j_description" v-model="job.j_description" required="" placeholder="请输入兼职岗位名称" value="${job.j_description}" name="j_description" type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="j_salary" class="am-u-sm-3 am-form-label">兼职岗位薪资</label>
                            <div class="am-u-sm-9">
                                <input id="j_salary" v-model="job.j_salary" required="" placeholder="输入兼职岗位薪资" value="${job.j_salary}" name="j_salary" type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="j_hours" class="am-u-sm-3 am-form-label">兼职岗位工作时间</label>
                            <div class="am-u-sm-9">
                                <input id="j_hours" v-model="job.j_hours" required="" placeholder="输入兼职岗位工作时间" value="${job.j_hours}" name="j_hours" type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-3">
                                <input type="button" id="editRole" class="am-btn am-btn-success" value="提交" @click="editJob"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script>
    new Vue({
        el:"#app",
        data:{
            job:{
                j_name:'',
                j_description: '',
                j_salary: '',
                j_hours: '',
                u_id:'',
            },
        },
        methods:{
            editJob(){
                axios.post('EditJobServlet',this.job)
                    .then(response => {
                        if(response.data == false){
                            console.log(response.data)
                            this.job.u_id = response.data;
                            console.log(this.job.u_id)
                            alert("修改失败！！")
                            return;
                        }else{
                            console.log(response.data)
                            this.job.u_id = response.data;
                            console.log(this.job.u_id)
                            alert("修改成功")
                        }
                    })
                    .catch(error =>{
                        console.error(error);
                    });
            },
        }
    })
</script>
</html>
