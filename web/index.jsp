<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/6
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>大气网站后台模板</title>
  <link rel="stylesheet" href="css/layui.css">
  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="myplugs/js/plugs.js"></script>
  <script src="js/layui.js"></script>
</head>

<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <div class="layui-logo">学生兼职管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
          <li class="layui-nav-item">
            <a href="javascript:;">
              <img src="images/1.gif" class="layui-nav-img"> 管理员
            </a>
            <dl class="layui-nav-child">
              <dd>
                <a href="">个人中心</a>
              </dd>
              <dd>
                <a href="">安全设置</a>
              </dd>
            </dl>
          </li>
          <li class="layui-nav-item">
            <a href="">退出系统</a>
          </li>
        </ul>
      </div>

      <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
          <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
          <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
              <a class="" href="javascript:;">主页</a>
              <dl class="layui-nav-child">
                <dd>
                  <a href="student.jsp" target="right">学生个人中心</a>
                </dd>
                <dd>
                  <a href="publisher.jsp" target="right">发布者信息</a>
                </dd>
                <dd>
                  <a href="job.jsp" target="right">兼职岗位信息</a>
                </dd>

                  <a href="javascript:void(0)"  onclick="updatePwd('修改密码',1)">修改密码</a>
                </dd>
              </dl>
            </li>
            <li class="layui-nav-item">
              <a href="javascript:;">菜单栏</a>
              <dl class="layui-nav-child">
                <dd>
                  <a href="message.jsp" target="right">留言管理</a>
                </dd>
                <dd>
                  <a href="admin.jsp" target="right">用户管理</a>
                </dd>
                <dd>
              </dl>
            </li>
            <li class="layui-nav-item">
              <a href="javascript:;">菜单栏</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

            <li class="layui-nav-item">
              <a href="javascript:;">菜单栏</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

            <li class="layui-nav-item">
              <a href="javascript:;">菜单栏</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

            <li class="layui-nav-item">
              <a href="javascript:;">菜单栏</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

          </ul>
        </div>
      </div>

      <div class="layui-body" style="z-index: 0;">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
          <iframe src="product.html" name="right" frameborder="0" width="100%" height="1200"></iframe>

        </div>
      </div>

      <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
      </div>
    </div>
    <script type="text/javascript">
      //添加编辑弹出层
      function updatePwd(title, id) {
        $.jq_Panel({
          title: title,
          iframeWidth: 500,
          iframeHeight: 300,
          url: "updatePwd.html"
        });
      }
    </script>

    <script>
      //JavaScript代码区域
      layui.use('element', function() {
        var element = layui.element;

      });
    </script>

  </body>
</html>
