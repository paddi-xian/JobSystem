<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/12/9
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/jquery-1.11.3.min.js"></script>
<head>
    <title>更多申请信息</title>
  <style>
    .info-item {
      margin-top: 10px;
    }

    .label {
      font-size: 20px;
      font-family: "Cambria Math";
      font-weight: 600;
    }

    .value {
      font-size: 20px;
      font-family: cursive;
      font-weight: 600;
    }

    .button {
      width: 100px;
      margin-right: 50px;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div class="info-item">
  <span class="label">公司名称:</span>
  <span class="value"  @click="btn">${job.p_name}</span>
</div>
<div class="info-item">
  <span class="label">岗位名称:</span>
  <span class="value">${job.j_name}</span>
</div>
<div class="info-item">
  <span class="label">岗位描述:</span>
  <span class="value">${job.j_description}</span>
</div>
<div class="info-item">
  <span class="label">公司邮箱:</span>
  <span class="value">${job.p_email}</span>
</div>
<div class="info-item">
  <span class="label">公司地址:</span>
  <span class="value">${job.p_address}</span>
</div>
</body>
</html>
