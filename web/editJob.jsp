<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/6
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改兼职岗位</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
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
                                <input id="j_name" v-model="job.j_name" required="" placeholder="${job.j_name}"   name="j_name" type="text">
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label class="am-u-sm-3 am-form-label">学历要求</label>
                            <div class="am-u-sm-9">
                                <input type="radio" name="group1" value="不限" v-model="job.j_require">不限
                                <input type="radio" name="group1" value="大专" v-model="job.j_require">大专
                                <input type="radio" name="group1" value="本科" v-model="job.j_require">本科
                                <input type="radio" name="group1" value="研究生" v-model="job.j_require">研究生
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="j_salary" class="am-u-sm-3 am-form-label">兼职岗位薪资</label>
                            <div class="am-u-sm-9">
                                <input id="j_salary" v-model="job.j_salary" required="" placeholder="${job.j_salary}" class="verify" name="j_salary" type="text">
                                <div id="is_j_salary"></div>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="j_hours" class="am-u-sm-3 am-form-label">兼职岗位工作时间</label>
                            <div class="am-u-sm-9">
                                <input id="j_hours" v-model="job.j_hours" required="" placeholder="${job.j_hours}" class="verify" name="j_hours" type="text">
                                <div id="is_j_hours"></div>
                            </div>
                        </div>

                        <div class="am-form-group">
                            <label for="j_description" class="am-u-sm-3 am-form-label">兼职岗位描述</label>
                            <div class="am-u-sm-9">
                                <textarea id="j_description" v-model="job.j_description" placeholder="${job.j_description}" class="verify" name="j_description" style="width:343px;height: 100px" cols="32" rows="4"></textarea>
                                <div id="is_j_description"></div>
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
    let boolean = true;
    new Vue({
        el:"#app",
        data:{
            job:{
                j_id: '',
                j_name:'',
                j_description: '',
                j_salary: '',
                j_hours: '',
                u_id:'',
                j_require:'',
            },
        },
        methods:{
            editJob(){
                if(!boolean){
                    return;
                }
                console.log(JSON.parse(sessionStorage.getItem("job")))
                // this.job.j_id = JSON.parse(sessionStorage.getItem("job")).j_id;
                var ok = window.confirm("是否确认修改？");
                if(ok){
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
                            parent.postMessage("closeEditJob","http:localhost:8080/job_system_war_exploded/")
                        })
                        .catch(error =>{
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
        $("#j_salary").blur(function (){
            verifyjSalary();
        });
        $("#j_hours").blur(function (){
            verifyjHours();
        });
    });
    function verifyjSalary(){
        let value = $("#j_salary").val();
        let regex = /^(?:\d+|\d{1,}[.,]\d+)$/;
        if(value != ''){
            if(!regex.test(value)){
                $("#is_j_salary").text("您输入的格式不对").css({'color':'red'});
                boolean = false;
            }else{
                boolean = true;
            }
        }
    }
    function verifyjHours() {
        let value = $("#j_hours").val();
        let regex = /^\d+$/;
        if(value != ''){
            if (!regex.test(value)) {
                $("#is_j_hours").text("您输入的格式不对").css({'color': 'red'});
                boolean = false;
            } else {
                boolean = true;
            }
        }
    }
</script>
</html>
