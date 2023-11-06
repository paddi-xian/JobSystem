<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/10/22
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
</head>
<body>
<div class="am-g">
    <div class="am-u-sm-12 am-u-md-6">
        <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
                <button type="button" id="add" class="btnadd am-btn am-btn-default"><span class="am-icon-plus"></span>
                    新增
                </button>
                <%--                    <button id="${job.j_id}" class="add" name="${job.u_id}">新增</button>--%>
            </div>
        </div>
    </div>
    <div class="am-u-sm-12 am-u-md-3">

    </div>
<div class="layui-content">
    <div class="layui-row">
        <div class="layui-card">
            <div class="layui-card-header">个人信息</div>
<%--            <form class="layui-form layui-card-body" action="/updateStuServlet" method="get">--%>

                <%--                修改姓名--%>

    <div class="layui-form-item">
                    <label class="layui-form-label">学生姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="s_name" value="${student.s_id}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
<%--    修改性别--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                     <select name="s_gender">
                     <option value="男">男性</option>
                        <option value="女">女性</option>
                     </select>
                    </div>
                </div>
<%--    修改年龄--%>
    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="s_age"  value="${student.s_age}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
<%--    修改电话--%>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-block">
            <input type="text" name="s_phone" value="${student.s_phone}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
<%--    修改邮箱--%>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
            <input type="text" name="s_email" value="${student.s_email}" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
<%--    修改简介--%>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">简介</label>
                    <div class="layui-input-block">
                        <textarea name="s_intro" value="${student.s_intro}" placeholder="请输入内容(100字以内)" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button  type="submit" class="layui-btn layui-btn-blue" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="../assets/layui.all.js"></script>
<script>
    var form = layui.form
        ,layer = layui.layer;
    $(function () {
        $(".btnadd").click(function () {
            $.jq_Panel({
                title: "添加个人信息",
                iframeHeight: 300,
                iframeWidth: 500,
                url: "addStudent.jsp"
            })
        })
    })
</script>
</div>

</body>
</html>
