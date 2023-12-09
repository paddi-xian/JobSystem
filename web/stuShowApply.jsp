<%--
  Created by IntelliJ IDEA.
  User: SkylaYU
  Date: 2023/12/8
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生查看申请</title>
</head>
<body>
<div class="am-g">
    <div class="am-u-sm-12">
        <form class="am-form" action="studentShowApply" method="post">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
                    <th class="table-title">兼职岗位名称</th>
                    <th class="table-title">学历要求</th>
                    <th class="table-title">工资</th>
                    <th class="table-title">工作时间</th>
                    <th class="table-title">公司名称</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${jobs}" var="job">
                    <tr>
                        <td>${job.j_name}</td>
                        <td>${job.j_require}</td>
                        <td>${job.j_salary}</td>
                        <td>${job.j_hours}</td>
                        <td>${job.p_name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
</html>
