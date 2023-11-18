<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/11/14
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>发布者个人中心</title>
</head>
<body>
<h1>发布者个人中心</h1>
<form action="" method="post">
  <div>
    <label name="p_name">姓名：</label>
    <td>${publisher.p_name}</td>
  </div>
  <div>
    <label name="p_telephone">电话：</label>
    <td>${publisher.p_telephone}</td>
  </div>
  <div>
    <label name="p_address">地址：</label>
    <td>${publisher.p_address}</td>
  </div>
  <div>
    <label name="p_email">邮箱：</label>
    <td>${publisher.p_email}</td>
  </div>
  <div>
    <label name="p_introduction">介绍：</label><br>
    <td>${publisher.p_introduction}</td>
  </div>
<%--  <div>--%>
<%--    <input type="submit" value="编辑">--%>
<%--  </div>--%>
</form>
</body>
</html>
