<%--
  Created by IntelliJ IDEA.
  User: zyn
  Date: 2023/12/2
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生管理收藏页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <style>
        .page-button {
            text-decoration: none;
            background: white;
            color: #000000;
            margin-left: 15px;
        }

        .total {
            width: 100px;
            display: inline;
        }

        .page2 {
            margin-left: 200px;
            display: inline;
        }
    </style>
</head>
<body>

<div class="am-g">
    <div class="am-u-sm-12">
        <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
                    <th class="table-title">兼职岗位名称</th>
                    <th class="table-title">学历要求</th>
                    <th class="table-title">工资</th>
                    <th class="table-title">工作时间</th>
                    <th class="table-title">公司名称</th>
                    <th class="table-set">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${info.list}" var="job">
                    <tr>
                        <td>${job.j_name}</td>
                        <td>${job.j_require}</td>
                        <td>${job.j_salary}</td>
                        <td>${job.j_hours}</td>
                        <td>${job.p_name}</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button id="${job.j_id}"
                                            class="delete am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                            name="${job.u_id}" onclick="del();"><span
                                            class="am-icon-trash-o"></span> 取消收藏
                                    </button>
                                </div>
                            </div>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr>
            <%--分页--%>
            <div class="page">
                <span class="total">共 ${info.getTotal()} 条数据</span>
                <div class="page2">
                    <c:if test="${info.hasPreviousPage}">
                        <a href="SelectRecordServlet?pageNum=${info.prePage}&pageSize=${pageSize}" class="page-button">上一页</a>
                    </c:if>
                    <c:if test="${info.pages <= 10}">
                        <c:set var="begin" value="1"></c:set>
                        <c:set var="end" value="${info.pages}"></c:set>
                    </c:if>

                    <%--第二种情况 10个格子以上--%>
                    <c:if test="${info.pages >10}">
                        <%--begin = ? end = ? --%>
                        <%--
                        2 7 11
                        3 8 12
                        7 12 16
                        begin = pageNum - 5
                        end = pageNum + 4
                        --%>
                        <%--通式--%>
                        <c:set var="begin" value="${info.pageNum -5}"/>
                        <c:set var="end" value="${info.pageNum +4}"/>
                        <%--左侧begin 扶正 为了保证通过上述公式运算后左右10个格子，begin和end都得扶正--%>
                        <c:if test="${begin <1 }">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="10"/>
                        </c:if>
                        <%--右侧end 扶正--%>
                        <c:if test="${end > info.pages}">
                            <c:set var="end" value="${info.pages}"/>
                            <c:set var="begin" value="${end -9}"/>
                        </c:if>
                    </c:if>

                    <c:forEach begin="${begin}" end="${end}" var="i">
                        <a href="SelectRecordServlet?pageNum=${i}&pageSize=${pageSize}" class="page-button">${i}</a>
                    </c:forEach>
                    <c:if test="${info.hasNextPage}">
                        <a href="SelectRecordServlet?pageNum=${info.nextPage}&pageSize=${pageSize}" class="page-button">下一页</a>
                    </c:if>
                </div>
                <select onchange="window.location=this.value" style="display: inline;width: 80px;margin-left: 20px">
                    <option value="SelectRecordServlet?pageNum=1&pageSize=5"<c:if test="${pageSize == 5}">selected</c:if>>5</option>
                    <option value="SelectRecordServlet?pageNum=1&pageSize=10"<c:if test="${pageSize == 10}">selected</c:if>>10</option>
                    <option value="SelectRecordServlet?pageNum=1&pageSize=15"<c:if test="${pageSize == 15}">selected</c:if>>15</option>
                </select>
            </div>
            <hr>
        </form>
    </div>
</div>
<script>
    $(function (){
        $(".delete").click(function (){
            let j_id = $(this).attr("id");
            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "removeRecordServlet",
                data: {"j_id": j_id},
                dataType: 'json',
                success:function (res){
                    if (res) {
                        alert("取消收藏成功");
                        location.href = "SelectRecordServlet?pageNum="+ ${pageNum} +"&pageSize="+ ${pageSize};
                    }
                }
            })
        })
    })
</script>
</body>
</html>
