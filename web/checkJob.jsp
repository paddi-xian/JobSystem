<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zyn
  Date: 2023/12/1
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<script src="js/jquery-1.11.3.min.js"></script>
<head>
    <title>查看更多岗位信息</title>
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
<div class="info-item">
    <c:if test="${empty Record}">
        <button id="addButton" class="button" name="${job.j_id}">收藏</button>
    </c:if>
    <c:if test="${not empty Record}">
        <button id="removeButton" class="button" name="${job.j_id}">取消收藏</button>
    </c:if>
    <button id="${job.j_id}" name="${job.u_id}" class="btnApply">申请岗位</button>
</div>
<label class="doubleError"><span id="doubleError">${doubleError}</span></label><br>
<script>
    $(function () {
        // $(".btn").click(function (){
        //     parent.postMessage("closeBtn","http:localhist:8080/job_system_war_exploded/")
        // })

        //收藏按钮
        $("#addButton").click(function () {
            let j_id = $(this).attr("name")
            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "AddRecordServlet",
                data: {"j_id": j_id},
                dataType: 'json',
                success: function (res) {
                    if (!res) {
                        alert("收藏失败")
                    } else {
                        alert("收藏成功")
                        parent.postMessage("closeAddRecord", "http:localhost:8080/job_system_war_exploded/")
                    }
                }
            })
        })
    })
    $(function () {
        $(".btnApply").click(function () {
            let j_id = $(this).attr("id")
            let u_id = $(this).attr("name")
            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "addApplication",
                data: {"j_id": j_id, "u_id": u_id},
                dataType: 'json',
                success: function (res) {
                    if (!res) {
                        alert("申请失败")
                    } else {
                        alert("申请成功")
                        parent.postMessage("closeAddRecord", "http:localhost:8080/job_system_war_exploded/")
                    }
                }
            })
        })

        //取消收藏按钮
        $("#removeButton").click(function () {
            let j_id = $(this).attr("name")
            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "removeRecordServlet",
                data: {"j_id": j_id},
                dataType: 'json',
                success: function (res) {
                    if (!res) {
                        alert("取消收藏失败");
                    } else {
                        alert("取消收藏成功");
                        parent.postMessage("closeAddRecord", "http:localhost:8080/job_system_war_exploded/")
                    }
                }
            })
        })

    })
</script>
</body>
</html>
