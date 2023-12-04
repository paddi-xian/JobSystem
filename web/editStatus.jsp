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
    <script src="js/jquery-3.6.3.min.js"></script>
</head>
<body>
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-g">
                <form class="am-form am-form-horizontal" action="updateStatus" method="post" style="padding-top: 30px;">
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
                        <h2>请选择状态</h2>
                        <input type="radio" name="status" value="通过">通过<br>
                        <input type="radio" name="status" value="驳回">驳回<br>
                    <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <input type="button" button id="${job.j_id}"  class="editStatus am-btn am-btn-success" value="提交"/>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script>
    $(document).ready(function(){
        $(".editStatus").click(function(e){
            // 从URL获取参数
            // 阻止表单的默认提交行为
            e.preventDefault();

            // 获取选中的状态和jobId
            var jobId = $(this).attr("id"); // 获取页面中的j_id，这是从后端session中获取的，假设你已经在页面加载时从session中获取了它
            var status = $('input[name="status"]:checked').val();

            // 构建要发送的数据
            var data = {
                j_id: jobId,
                j_status: status
            };

            // 发送AJAX请求
            $.ajax({
                type: "POST",  // 使用POST方法发送数据
                url: "updateStatus",  // 发送到updateStatus路径
                data: JSON.stringify(data),  // 将数据转换为JSON字符串
                contentType: "application/json; charset=utf-8",  // 设置正确的Content-Type头
                dataType: "json",  // 预期服务器返回的数据类型是JSON
                success: function(response) {  // 请求成功时的回调函数
                    // 在这里处理服务器返回的响应，例如更新页面或显示成功的消息
                    console.log(response);
                },
                error: function(xhr, status, error) {  // 请求失败时的回调函数
                    // 在这里处理错误，例如显示一个错误消息
                    console.error(error);
                }
            });
        });
    });
    // document.getElementById('editStatus').addEventListener('click', function() {
    //     var status = '';
    //     var radios = document.getElementsByName('status');
    //     for (var i = 0; i < radios.length; i++) {
    //         if (radios[i].checked) {
    //             status = radios[i].value;
    //             break;
    //         }
    //     }
    //     var jobId = document.getElementById('jobId').value;
    //     var data = { j_id: jobId, j_status: status };
    //     var xhr = new XMLHttpRequest();
    //     xhr.open('POST', '/updateStatus', true);
    //     xhr.setRequestHeader('Content-Type', 'application/json');
    //     xhr.onreadystatechange = function() {
    //         if (xhr.readyState === 4 && xhr.status === 200) {
    //             // 数据提交成功后，你可以在这里更新页面或者显示一个成功的消息
    //             alert('状态更新成功');
    //         } else if (xhr.readyState === 4) {
    //             // 数据提交失败后，你可以在这里显示一个错误消息
    //             alert('状态更新失败');
    //         }
    //     };
    //     xhr.send(JSON.stringify(data));
    // });
</script>
</html>
