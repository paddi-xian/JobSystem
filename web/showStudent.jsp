
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
    <style>
        .page-button {
            text-decoration: none;
            background: white;
            color: #000000;
            margin-left: 15px;
        }

        .total {
            width: 100px;
            display: inline;
        }

        .page2 {
            margin-left: 200px;
            display: inline;
        }
    </style>
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
                            <th class="table-check"></th>
                            <th class="table-id">ID</th>
                            <th class="table-title">姓名</th>
                            <th class="table-title">性别</th>
                            <th class="table-title">年龄</th>
                            <th class="table-title">电话</th>
                            <th class="table-set">邮箱</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${info.list}" var="stu">
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
                    <hr>
                    <div class="page">
                        <span class="total">共 ${info.getTotal()} 条数据</span>
                        <div class="page2">
                            <c:if test="${info.hasPreviousPage}">
                                <a href="showStudent?pageNum=${info.prePage}&pageSize=${pageSize}" class="page-button">上一页</a>
                            </c:if>
                            <c:if test="${info.pages <= 10}">
                                <c:set var="begin" value="1"></c:set>
                                <c:set var="end" value="${info.pages}"></c:set>
                            </c:if>

                            <%--第二种情况 10个格子以上--%>
                            <c:if test="${info.pages >10}">
                                <%--通式--%>
                                <c:set var="begin" value="${info.pageNum -5}"/>
                                <c:set var="end" value="${info.pageNum +4}"/>
                                <%--左侧begin 扶正 为了保证通过上述公式运算后左右10个格子，begin和end都得扶正--%>
                                <c:if test="${begin <1 }">
                                    <c:set var="begin" value="1"/>
                                    <c:set var="end" value="10"/>
                                </c:if>
                                <%--右侧end 扶正--%>
                                <c:if test="${end > info.pages}">
                                    <c:set var="end" value="${info.pages}"/>
                                    <c:set var="begin" value="${end -9}"/>
                                </c:if>
                            </c:if>

                            <c:forEach begin="${begin}" end="${end}" var="i">
                                <a href="showStudent?pageNum=${i}&pageSize=${pageSize}" class="page-button">${i}</a>
                            </c:forEach>
                            <c:if test="${info.hasNextPage}">
                                <a href="showStudent?pageNum=${info.nextPage}&pageSize=${pageSize}" class="page-button">下一页</a>
                            </c:if>
                        </div>
                        <select onchange="window.location=this.value" style="display: inline;width: 80px;margin-left: 20px">
                            <option value="showStudent?pageNum=1&pageSize=5"<c:if test="${pageSize == 5}">selected</c:if>>5</option>
                            <option value="showStudent?pageNum=1&pageSize=10"<c:if test="${pageSize == 10}">selected</c:if>>10</option>
                            <option value="showStudent?pageNum=1&pageSize=15"<c:if test="${pageSize == 15}">selected</c:if>>15</option>
                        </select>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

