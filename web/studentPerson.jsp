
<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/11/5
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>学生个人中心</title>
  <link rel="stylesheet" href="css/amazeui.min.css"/>
  <link rel="stylesheet" href="css/admin.css"/>
  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="myplugs/js/plugs.js"></script>
</head>
<div class="admin-content-body">
  <div class="am-cf am-padding am-padding-bottom-0">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">学生个人信息</strong><small></small>
    </div>
  </div>

  <hr>

  <div class="am-g">
    <div class="am-u-sm-12 am-u-md-6">
      <div class="am-btn-toolbar">
        <div class="am-btn-group am-btn-group-xs">
          <button type="button" id="add" class="btnadd am-btn am-btn-default">
            <span class="am-icon-plus"></span>
            新增
          </button>
        </div>
      </div>
    </div>
    <div class="am-u-sm-12 am-u-md-3">

    </div>
  </div>
  <div class="am-g">
    <div class="am-u-sm-12">
      <form class="am-form">
        <table class="am-table am-table-striped am-table-hover table-main">
          <thead>
          <tr>
            <th class="table-check"></th>
            <th class="table-title">姓名</th>
            <th class="table-title">性别</th>
            <th class="table-title">年龄</th>
            <th class="table-title">电话</th>
            <th class="table-title">邮箱</th>
            <th class="table-title">简介</th>
          </tr>
          </thead>
          <tbody>
              <c:forEach items="${student}" var="s">
            <tr>
              <td><input id="${s.s_id}" type="checkbox"></td>
              <td>${s.s_name}</td>
              <td>${s.s_gender}</td>
              <td>${s.s_age}</td>
              <td>${s.s_phone}</td>
              <td>${s.s_email}</td>
              <td>${s.s_intro}</td>

              <td>
                <div class="am-btn-toolbar">
                  <div class="am-btn-group am-btn-group-xs">
<%--                    <button id="${s.j_id}" class="delete" name="${s.u_id}">删除</button>--%>
                    <button id="${s.s_id}" class="edit" name="${s.u_id}">编辑</button>
                  </div>
                </div>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <hr>
      </form>
    </div>
  </div>
</div>
<script>
  $(function () {
    $(".btnedit").click(function () {
      $.jq_Panel({
        title: "修改个人信息",
        iframeWidth: 500,
        iframeHeight: 300,
        url: "studentUpdate.jsp"
      });
    });
    $(".btnadd").click(function () {
      $.jq_Panel({
        title: "添加个人信息",
        iframeHeight: 500,
        iframeWidth: 600,
        url: "addStudent.jsp"
      })
    })

  })
</script>
</html>
