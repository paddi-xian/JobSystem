<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<script src="js/jquery-1.11.3.min.js"></script>
<head>
    <title>查看申请学生岗位信息</title>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <style>
        .container .carousel .carousel-inner .item > img {
            width: 100%;
            height: 400px;
            align-items: center;
        }

        .container .carousel {
            width: 900px;
            /* align-items: center; */
            margin-left: 150px;
        }

    </style>
</head>
<body>
<div class="am-g">
    <div class="am-u-sm-12">
        <form class="am-form" action="publisherApply" method="post">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
                    <th class="table-title">申请工作</th>
                    <th class="table-title">学生姓名</th>
                    <th class="table-title">性别</th>
                    <th class="table-title">年龄</th>
                    <th class="table-title">邮箱</th>
                    <th class="table-title">电话</th>
                    <th class="table-title">就读经历</th>
                    <th class="table-title">获奖经历</th>
                    <th class="table-title">工作经历</th>
                    <th class="table-set"></th>
                </tr>
                </thead>
            </table>
            <c:forEach items="${students}" var="s">
                <td>${s.j_name}</td>
                <td>${s.s_name}</td>
                <td>${s.s_name}</td>
                <td>${s.s_gender}</td>
                <td>${s.s_age}</td>
                <td>${s.s_phone}</td>
                <td>${s.s_college}</td>
                <td>${s.s_prize}</td>
                <td>${s.s_experience}</td>
            </c:forEach>
        </form>
    </div>
</div>
</body>
<script>

</script>
</html>