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
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <style>
        .am-form{
            margin-top: 50px;
            margin-left: 50px
        }
        .table-title{
            font-size: 14px;
            font-weight: bold;
        }
        button {
            float: left;
            width: 100px;
            height: 40px;
            background-color: #3333337a;
            border-radius: 0px 10px 10px 0px;
            border: none;
            outline: none;
        }

    </style>
</head>
<body class="layui-padding-3">
<div class="am-g">
    <div class="am-u-sm-12" class="admin-content-body">
        <div class="am-cf am-padding am-padding-bottom-0">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">学生查看申请</strong><small></small>
            </div>
        </div>
        <form class="am-form" action="studentShowApply" method="post">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
                    <th class="table-title">兼职岗位名称</th>
                    <th class="table-title">学历要求</th>
                    <th class="table-title">工资</th>
                    <th class="table-title">工作时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${jobs}" var="job">
                    <tr>
                        <td>${job.j_name}</td>
                        <td>${job.j_require}</td>
                        <td>${job.j_salary}</td>
                        <td>${job.j_hours}</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="${job.j_id}"
                                            class="btnCheck am-btn am-btn-default am-btn-xs am-text-secondary am-hide-sm-only"
                                            name="${job.u_id}">查看更多</button>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
<script>
    $(function (){
        $(".btnCheck").click(function () {
                let j_id = $(this).attr("id");
            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "showMoreJobMessage",
                data: {"j_id": j_id},
                dataType: 'json',
                success: function (res) {
                    if (res != false) {
                        console.log(res)
                    } else {
                        console.log(res)
                    }
                }
            })
            $.jq_Panel({
                title:"查看更多岗位信息",
                iframeWidth:500,
                iframeHeight:300,
                url:"stuJobApplyMore.jsp"
            })
            });




    })


</script>
</html>
