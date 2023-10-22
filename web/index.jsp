<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/6
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>学生兼职管理系统</title>
  <link rel="stylesheet" href="css/layui.css">
  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="myplugs/js/plugs.js"></script>
  <script src="js/layui.js"></script>
</head>

<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
      <div class="layui-header">
        <div class="layui-logo">兼职管理系统——管理员端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
          <li class="layui-nav-item">
            <a href="javascript:;">
              <img src="img/user.jpg" class="layui-nav-img"> ${user.u_name}
            </a>
            <dl class="layui-nav-child">
              <dd>
                <a href="admin.jsp">个人中心</a>
              </dd>
              <dd>
                <a href="">安全设置</a>
              </dd>
            </dl>
          </li>
          <li class="layui-nav-item">
            <a href="login.jsp">退出系统</a>
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
                  <a href="showStudent.jsp" target="right">学生管理</a>
                </dd>
                <dd>
                  <a href="showPublisher.jsp" target="right">发布者管理</a>
                </dd>
              </dl>
            </li>
            <li class="layui-nav-item layui-nav-itemed" >
              <a href="javascript:;">岗位管理</a>
              <dl class="layui-nav-child">
                <dd>
                  <a href="job.jsp" target="right">兼职岗位审核</a>
                </dd>
                <dd>
                  <a href="message.jsp" target="right">留言区管理</a>
                </dd>
                <dd>
              </dl>
            </li>
            <li class="layui-nav-item">
              <a href="javascript:;">暂未开放</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

            <li class="layui-nav-item">
              <a href="javascript:;">暂未开放</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

            <li class="layui-nav-item">
              <a href="javascript:;">暂未开放</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

            <li class="layui-nav-item">
              <a href="javascript:;">暂未开放</a>
              <dl class="layui-nav-child">

              </dl>
            </li>

          </ul>
        </div>
      </div>

      <div class="layui-body" style="z-index: 0;">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
          <iframe src="welcome.jsp" name="right" frameborder="0" width="100%" height="1200"></iframe>

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
