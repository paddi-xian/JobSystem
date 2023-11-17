<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/11/14
  Time: 22:49
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
<form action="/updatePubServlet" method="post">
  <div>
    <label for="p_name">姓名：</label>
    <input type="text" id="p_name" name="p_name" value="${publisher.p_name}" required>
  </div>
  <div>
    <label for="p_telephone">电话：</label>
    <input type="tel" id="p_telephone" name="p_telephone" value="${publisher.p_telephone}" required>
  </div>
  <div>
    <label for="p_address">地址：</label>
    <input type="text" id="p_address" name="p_address" value="${publisher.p_address}" required>
  </div>
  <div>
    <label for="p_email">邮箱：</label>
    <input type="email" id="p_email" name="p_email" value="${publisher.p_email}" required>
  </div>
  <div>
    <label for="p_introduction">介绍：</label><br>
    <textarea id="p_introduction" name="p_introduction" rows="4" cols="50">${publisher.p_introduction}</textarea>
  </div>
  <div>
    <input type="submit" value="编辑">
  </div>
</form>
</body>
</html>
