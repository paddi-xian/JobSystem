<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/4
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>求职者看到的页面</title>
    <link rel="stylesheet" href="css/layui.css">
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <script src="js/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">兼职管理系统——学生端</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="img/user.jpg" class="layui-nav-img">${user.u_name}
                </a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="#.jsp">个人中心</a>
                    </dd>
                    <dd>
                        <a href="updatePwd.jsp">修改密码</a>
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
                            <a href="student?u_id=${user.u_id}" target="right">学生个人中心</a>
                        </dd>
                        <dd>
                            <a href="studentUpdate.jsp" target="right">学生修改个人信息</a>
                        </dd>
                        <dd>
                            <a href="StuShowJob" target="right">学生查看兼职岗位信息</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" >
                    <a href="javascript:;">兼职岗位管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="message.jsp" target="right">留言区</a>
                        </dd>
                        <dd>
                            <a href="1.jsp" target="right">暂未开放</a>
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
            url: "updatePwd.jsp"
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
