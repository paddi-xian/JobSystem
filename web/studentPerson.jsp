
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
        .test {
            margin-top: 50px;
            width: 200px;
            margin-left: 250px;
            display: inline-block;
        }
        .mation{
            margin-top: 50px;
            width: 300px;
           transform: translateX(700px);
            position: relative;
            top: -450px;
        }
        .user_img {
            width: 100px;
            /*height: 20px;*/
            overflow: hidden;
        }
        .user_img img{
            width: 100%;
            height: auto;
        }
        .layui-block{
            border: 1px solid black;
            font-size: 17px;
            padding: 5px;
        }
        .layui-form-label{
            font-size: 17px;
        }
        .layui-card-header{
            font-size: 20px;
        }
        .am-btn-group{
            margin-right: 50px;
        }
    </style>
</head>
<body>
<div class="layui-content">
  <div class="layui-row">
    <div class="layui-card">
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6" style="margin-left: 450px;margin-top: 25px">
          <div class="am-btn-toolbar">
<%--              添加信息按钮--%>
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" id="add" class="btnadd am-btn am-btn-default">
                  <span class="am-icon-plus"></span>
                新增个人信息
              </button>
            </div>
<%--    修改信息按钮--%>
              <div class="am-btn-group am-btn-group-xs" >
                  <button type="button" id="update" class="btnupdate am-btn am-btn-default">
                      <span class="am-icon-plus"></span>
                      修改个人信息
                  </button>
              </div>
<%--    <div class="am-btn-group am-btn-group-xs" >--%>
<%--        <button type="button" id="upload" class="btnupload am-btn am-btn-default">--%>
<%--            <span class="am-icon-plus"></span>--%>
<%--           上传个人简历--%>
<%--        </button>--%>
<%--    </div>--%>

          </div>
        </div>
<%--        <div class="am-u-sm-12 am-u-md-3">--%>
          <div class="test">
              <div class="user_img">
                  <img src="img/user.jpg" alt="用户头像">
              </div >
      <div class="layui-card-header">个人信息</div>
<%--              姓名--%>
      <div class="layui-form-item">
        <label class="layui-form-label">学生姓名</label>
        <div class="layui-block">
          <td>${student.s_name}</td>
        </div>
      </div>
<%--              性别--%>
      <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-block">
          <td>${student.s_gender}</td>
        </div>
      </div>
<%--              年龄--%>
      <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-block">
<%--          <input type="text" name="s_age"  value="${student.s_age}" >--%>
          <td>${student.s_age}</td>
        </div>
      </div>
      <%--    电话--%>
      <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-block">
           <td>${student.s_phone}</td>
        </div>
      </div>
      <%--    邮箱--%>
      <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-block">
<%--          <input type="text" name="s_email" value="${student.s_email}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">--%>
          <td>${student.s_email}</td>
        </div>
      </div>
<%--              简介--%>
      <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">简介</label>
        <div class="layui-block">
       <text>${student.s_intro}</text>
        </div>
      </div>
          </div>
          <div class="mation">
              <div class="layui-form-item">
                  <label class="layui-form-label">学习经历</label>
                  <div class="layui-block">
                      <td>${student.s_college}</td>
                  </div>
              </div>
              <div class="layui-form-item">
                  <label class="layui-form-label">获奖经历</label>
                  <div class="layui-block">
                      <td>${student.s_prize}</td>
                  </div>
              </div>
              <div class="layui-form-item">
                  <label class="layui-form-label">工作经历</label>
                  <div class="layui-block">
                      <td>${student.s_experience}</td>
                  </div>
              </div>
              <div class="layui-form-item">
                  <label class="layui-form-label">求职意向</label>
                  <div class="layui-block">
                      <td>${student.s_job}</td>
                  </div>
              </div>
              <div class="layui-card-bottom">第一次登录请添加信息！！</div>
          </div>

    </div>
  </div>
  </div>
</div>
</body>
<script>
  $(function () {
    $(".btnupdate").click(function () {
      $.jq_Panel({
        title: "修改个人信息",
        iframeWidth: 500,
        iframeHeight: 700,
        url: "studentUpdate.jsp"
      });
        panel.css("top", "50px"); // 设置面板距离页面最上端的距离为
    });
    $(".btnadd").click(function () {
      $.jq_Panel({
        title: "添加个人信息",
        iframeHeight: 600,
        iframeWidth: 500,
        url: "addStudent.jsp"
      });
        panel.css("top", "50px"); // 设置面板距离页面最上端的距离为
    })
      // $(".btnload").click(function () {
      //     $.jq_Panel({
      //         title: "添加个人信息",
      //         iframeHeight: 600,
      //         iframeWidth: 500,
      //         url: "uploadResume.jsp"
      //     });
      //     panel.css("top", "50px"); // 设置面板距离页面最上端的距离为
      // })
  })
</script>
</html>
