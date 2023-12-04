<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/6
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>兼职岗位页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.6.3.min.js"></script>
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
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">兼职岗位管理页面</strong><small></small>
        </div>
    </div>

    <hr>

    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
<%--                    <button id="${job.j_id}" class="add" name="${job.u_id}">新增</button>--%>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" id="search" class="am-form-field" placeholder="请输入兼职岗位名称">
                <span class="am-input-group-btn">
                <button type="button" class="search am-btn am-btn-default">搜索</button>
              </span>
            </div>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <form class="am-form">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th class="table-check"></th>
                        <th class="table-title">兼职岗位名称</th>
                        <th class="table-title">兼职岗位描述</th>
                        <th class="table-title">工资</th>
                        <th class="table-title">学历要求</th>
                        <th class="table-title">工作时间</th>
                        <th class="table-title">公司名称</th>
                        <th class="table-title">审核状态</th>
                        <th class="table-set">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${info.list}" var="job">
                        <tr>
                            <td><input id="${job.j_id}" type="checkbox"></td>
                            <td>${job.j_name}</td>
                            <td>${job.j_description}</td>
                            <td>${job.j_salary}</td>
                            <td>${job.j_require}</td>
                            <td>${job.j_hours}</td>
                            <td>${job.p_name}</td>
                            <td>${job.j_status}</td>
                            <td>
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" id="${job.j_id}" name="${job.j_id}"
                                                class="btnStatus am-btn am-btn-default am-btn-xs am-text-secondary am-hide-sm-only">编辑状态</button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="am-cf">
                </div>
                <hr>
                <%--分页--%>
                <div class="page">
                    <span class="total">共 ${info.getTotal()} 条数据</span>
                    <div class="page2">
                        <c:if test="${info.hasPreviousPage}">
                            <a href="ShowJob?pageNum=${info.prePage}&pageSize=${pageSize}" class="page-button">上一页</a>
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
                            <a href="ShowJob?pageNum=${i}&pageSize=${pageSize}" class="page-button">${i}</a>
                        </c:forEach>
                        <c:if test="${info.hasNextPage}">
                            <a href="ShowJob?pageNum=${info.nextPage}&pageSize=${pageSize}" class="page-button">下一页</a>
                        </c:if>
                    </div>
                    <select onchange="window.location=this.value" style="display: inline;width: 80px;margin-left: 20px">
                        <option value="ShowJob?pageNum=1&pageSize=5"<c:if test="${pageSize == 5}">selected</c:if>>5</option>
                        <option value="ShowJob?pageNum=1&pageSize=10"<c:if test="${pageSize == 10}">selected</c:if>>10</option>
                        <option value="ShowJob?pageNum=1&pageSize=15"<c:if test="${pageSize == 15}">selected</c:if>>15</option>
                    </select>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(function (){
        $(".btnStatus").click(function () {
            let j_id = $(this).attr("id");
            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "updateStatus",
                data: {"j_id": j_id},
                dataType: 'json',
            });
            $.ajax({
                async: false,
                cache: false,
                type: "post",
                url: "SelectJobByJIdServlet",
                data: {"j_id": j_id},
                dataType: 'json',
                success: function (res) {
                    if (res != false) {
                        console.log(res)
                    } else {
                        console.log(res)
                    }
                }
            });
            $.jq_Panel({
                title: "编辑状态",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "editStatus.jsp"
            })
        })
    })
</script>
</html>
