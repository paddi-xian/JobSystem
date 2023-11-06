
<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/4
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>查看学生信息页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
</head>
<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">查看所有学生用户信息</strong><small></small>
        </div>
    </div>
    <hr>

    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button type="button" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 禁用</button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">
        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" placeholder="请输入用户ID">
                <span class="am-input-group-btn">
                <button class="am-btn am-btn-default" type="button">搜索</button>
              </span>
            </div>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <form class="am-form">
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-check"><input type="checkbox"></th>
                            <th class="table-id">ID</th>
                            <th class="table-title">姓名</th>
                            <th class="table-title">性别</th>
                            <th class="table-title">年龄</th>
                            <th class="table-title">电话</th>
                            <th class="table-set">邮箱</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${stuList}" var="stu">
                            <tr>
                                <td><input type="checkbox"></td>
                                <td>${stu.s_id}</td>
                                <td>${stu.s_name}</td>
                                <td>${stu.s_gender}</td>
                                <td>${stu.s_age}</td>
                                <td>${stu.s_phone}</td>
                                <td>${stu.s_email}</td>

                            <td>
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button"
                                                class="btnedit am-btn am-btn-default am-btn-xs am-text-secondary"><span
                                                class="am-icon-pencil-square-o"></span> 解禁
                                        </button>
                                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span
                                                class="am-icon-trash-o"></span> 禁用
                                        </button>
                                    </div>
                                </div>
                            </td>
                            </tr>
                    </c:forEach>
                    </tbody>
                    </table>
                    <div class="am-cf">
                        共 2 条记录
                        <div class="am-fr">
                            <ul class="am-pagination">
                                <li class="am-disabled">
                                    <a href="#">«</a>
                                </li>
                                <li class="am-active">
                                    <a href="#">1</a>
                                </li>
                                <li>
                                    <a href="#">2</a>
                                </li>
                                <li>
                                    <a href="#">3</a>
                                </li>
                                <li>
                                    <a href="#">4</a>
                                </li>
                                <li>
                                    <a href="#">5</a>
                                </li>
                                <li>
                                    <a href="#">»</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <hr>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

