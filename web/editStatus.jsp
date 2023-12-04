<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/12/2
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核岗位</title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery-1.11.3.min.js"></script>
<%--    <script src="js/jquery-3.6.3.min.js"></script>--%>
</head>
<body>
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-g">
                <form class="am-form am-form-horizontal" method="post" style="padding-top: 30px;">
                    <div class="info-item">
                        <span class="label">公司名称:</span>
                        <span class="value">${job.p_name}</span>
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
                    <span class="label">选择状态:</span>
                        <input type="radio" name="status" value="通过">通过
                        <input type="radio" name="status" value="驳回">驳回<br>
                    <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <input type="button" button id="${job.j_id}" class="editStatus am-btn am-btn-success" value="提交"/>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script>
    $(function () {
        $(".editStatus").click(function () {
            let j_id = $(this).attr("id")
            let j_status = $('input[name="status"]:checked').val();

            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "updateStatus",
                data: {"j_id": j_id, "j_status": j_status},
                dataType: 'json',
                success: function (res) {
                    if (!res) {
                        alert("修改失败")
                    } else {
                        alert("修改成功")
                        parent.postMessage("closeUpdateStatus", "http:localhost:8080/job_system_war_exploded/")
                    }
                }
            })
        })
    })

</script>
</html>
