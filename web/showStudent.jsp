<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/4
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>学生页面</title>
</head>
<body>
<h1>欢迎${s_name}！</h1>
<p>这是学生页面。</p>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>邮箱</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stuList}" var="s">
            <tr>
                <td>${s.s_id}</td>
                <td>${s.s_name}</td>
                <td>${s.s_gender}</td>
                <td>${s.s_age}</td>
                <td>${s.s_phone}</td>
                <td>${s.s_email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>

