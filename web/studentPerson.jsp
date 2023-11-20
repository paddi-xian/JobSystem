
<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/11/5
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生个人中心</title>
  <link rel="stylesheet" href="css/amazeui.min.css"/>
  <link rel="stylesheet" href="css/admin.css"/>
  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <style>
        .test{
            margin-top: 50px;
            width: 200px;
        }
    </style>
</head>
<body>
<div class="layui-content">
  <div class="layui-row">
    <div class="layui-card">
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
          <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" id="add" class="btnadd am-btn am-btn-default">
                  <span class="am-icon-plus"></span>
                新增个人信息
              </button>
            </div>
          </div>
        </div>
<%--        <div class="am-u-sm-12 am-u-md-3">--%>
          <div class="test">
      <div class="layui-card-header">个人信息</div>
      <div class="layui-form-item">
        <label class="layui-form-label">学生姓名</label>
        <div class="layui-input-block">
          <td>${student.s_name}</td>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-block">
          <td>${student.s_gender}</td>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-block">
<%--          <input type="text" name="s_age"  value="${student.s_age}" >--%>
          <td>${student.s_age}</td>
        </div>
      </div>
      <%--    修改电话--%>
      <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-block">
<%--          <input type="text" name="s_phone" value="${student.s_phone}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">--%>
           <td>${student.s_phone}</td>

        </div>
      </div>
      <%--    修改邮箱--%>
      <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-block">
<%--          <input type="text" name="s_email" value="${student.s_email}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">--%>
          <td>${student.s_email}</td>
        </div>
      </div>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">简介</label>
        <div class="layui-block">
       <td>${student.s_intro}</td>
        </div>
      </div>
          </div>
      </form>
    </div>
  </div>



  </div>
</div>
</body>
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
        iframeWidth: 500,
        url: "addStudent.jsp"
      })
    })

  })
</script>
</html>
