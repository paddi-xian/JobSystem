<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/10/19
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生页面</title>
</head>
<body>
<table>
<tr>
  <th>ID</th>
  <th>姓名</th>
  <th>性别</th>
  <th>年龄</th>
  <th>电话</th>
  <th>邮箱</th>
</tr>
  <c:forEach items="${StuList}" var="s"></c:forEach>
  <tr>
  <td>${s.s__id}$</td>
  <td>${s.s_name}$</td>
  <td>${s.s_gender}$</td>
  <td>${s.s_age}$</td>
  <td>${s.s_phone}$</td>
  <td>${s.s_email}$</td>
  </tr>
  </table>
</body>
</html>
