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
          <form class="am-form am-form-horizontal" action="addJobServlet"  method="post" style="padding-top: 30px;">
            <input value="504" name="roleId" type="hidden">
            <div class="am-form-group">
              <label for="j_name" class="am-u-sm-3 am-form-label">兼职岗位名称</label>
              <div class="am-u-sm-9">
                <input id="j_name" v-model="job.j_name" required="" placeholder="输入兼职岗位名称" value="" name="j_name" type="text">
              </div>
            </div>

            <div class="am-form-group">
              <label for="j_description" class="am-u-sm-3 am-form-label">兼职岗位描述</label>
              <div class="am-u-sm-9">
                <input id="j_description" v-model="job.j_description" required="" placeholder="输入兼职岗位描述" value="" name="j_description" type="text">
              </div>
            </div>

            <div class="am-form-group">
              <label for="j_salary" class="am-u-sm-3 am-form-label">兼职岗位薪资</label>
              <div class="am-u-sm-9">
                <input id="j_salary" v-model="job.j_salary" required="" placeholder="输入兼职岗位薪资" value="" name="j_salary" type="text">
              </div>
            </div>

            <div class="am-form-group">
              <label for="j_hours" class="am-u-sm-3 am-form-label">兼职岗位工作时间</label>
              <div class="am-u-sm-9">
                <input id="j_hours" v-model="job.j_hours" required="" placeholder="输入兼职岗位工作时间" value="" name="j_hours" type="text">
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <input id="addRole" class="am-btn am-btn-success"  value="提交" type="submit"/>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
<%--<script>--%>
<%--  new Vue({--%>
<%--    el:"#app",--%>
<%--    data:{--%>
<%--      job:{--%>
<%--        j_name:'',--%>
<%--        j_description:'',--%>
<%--        j_salary:'',--%>
<%--        j_hours:'',--%>
<%--        u_id:'',--%>
<%--      },--%>

<%--    },--%>
<%--    methods:{--%>
<%--      addJob() {--%>
<%--        axios.post('/addJobServlet', this.job)--%>
<%--                .then(response => {--%>
<%--                  if (response == true) {--%>
<%--                    window.location.href="/Job"--%>
<%--                  } else {--%>
<%--                    alert("增加失败!!!")--%>
<%--                    console.log(response)--%>
<%--                  }--%>
<%--                })--%>
<%--                .catch(error => {--%>
<%--                  console.error(error);--%>
<%--                });--%>
<%--      },--%>
<%--      }--%>
<%--  })--%>
<%--</script>--%>
</html>
