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
                    <form class="am-form am-form-horizontal" action="role/addroleSubmit.action" method="post" style="padding-top: 30px;">
                        <input value="504" name="roleId" type="hidden">
                        <div class="am-form-group">
                            <label for="j_name" class="am-u-sm-3 am-form-label">
                                兼职岗位名称
                            </label>
                            <div class="am-u-sm-9">
                                <input id="j_name" required="" placeholder="请输入兼职岗位名称" value="" name="j_name" type="text">
                                <small id="helpRole">输入兼职岗位名称</small>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <label for="j_description" class="am-u-sm-3 am-form-label">
                                兼职岗位描述
                            </label>
                            <div class="am-u-sm-9">
                                <input id="j_description" required="" placeholder="请输入兼职岗位名称" value="" name="j_description" type="text">
                                <small>输入链接地址。</small>
                            </div>
                        </div>
                        <div class="am-form-group">
                            <div class="am-u-sm-9 am-u-sm-push-3">
                                <input id="addJob" class="am-btn am-btn-success" value="提交" type="button">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
