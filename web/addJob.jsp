<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/10
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加兼职岗位页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/app.css">
    <style>
      .admin-main{
        padding-top: 0px;
      }
    </style>
</head>
<body>
  <div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
      <div class="admin-content-body">
        <div class="am-g">
          <form class="am-form am-form-horizontal" action="" method="post" style="padding-top: 30px;">
            <input value="504" name="roleId" type="hidden">
            <div class="am-form-group">
              <label for="j_name" class="am-u-sm-3 am-form-label">
                兼职岗位名称
              </label>
              <div class="am-u-sm-9">
                <input id="j_name" required="" placeholder="输入兼职岗位名称" value="" name="j_name" type="text">
                <small>输入兼职岗位名称。</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="j_description" class="am-u-sm-3 am-form-label">
                兼职岗位描述
              </label>
              <div class="am-u-sm-9">
                <input id="j_description" required="" placeholder="输入兼职岗位描述" value="" name="j_description" type="text">
                <small>输入兼职岗位描述。</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="j_salary" class="am-u-sm-3 am-form-label">
                兼职岗位薪资
              </label>
              <div class="am-u-sm-9">
                <input id="j_salary" required="" placeholder="输入兼职岗位薪资" value="" name="j_salary" type="text">
                <small>输入兼职岗位薪资。</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="j_hours" class="am-u-sm-3 am-form-label">
                兼职岗位工作时间
              </label>
              <div class="am-u-sm-9">
                <input id="j_hours" required="" placeholder="输入兼职岗位工作时间" value="" name="j_hours" type="text">
                <small>输入兼职岗位工作时间。</small>
              </div>
            </div>
            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <input id="addRole" class="am-btn am-btn-success" value="提交" type="button">
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
