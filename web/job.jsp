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
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
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
                    <button type="button" id="add" class="btnadd am-btn am-btn-default"><span class="am-icon-plus"></span>
                        新增
                    </button>
<%--                    <button id="${job.j_id}" class="add" name="${job.u_id}">新增</button>--%>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" placeholder="请输入兼职岗位名称">
                <span class="am-input-group-btn">
                <button class="am-btn am-btn-default" type="button">搜索</button>
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
                        <th class="table-title">工作时间</th>
                        <th class="table-set">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${jobs}" var="job">
                        <tr>
                            <td><input id="${job.j_id}" type="checkbox"></td>
                            <td>${job.j_name}</td>
                            <td>${job.j_description}</td>
                            <td>${job.j_salary}</td>
                            <td>${job.j_hours}</td>
                            <td>
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button id="${job.j_id}" class="delete" name="${job.u_id}">删除</button>
                                        <button id="${job.j_id}" class="edit" name="${job.u_id}">编辑</button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="am-cf">
                    共 15 条记录
                    <div class="am-fr">
                        <ul class="am-pagination">
                            <li class="am-disabled">
                                <a href="#">«</a>
                            </li>
                            <li class="am-active">
                                <a href="#">1</a>
                            </li>
                            <li>
                                <a href="#">2</a>
                            </li>
                            <li>
                                <a href="#">3</a>
                            </li>
                            <li>
                                <a href="#">4</a>
                            </li>
                            <li>
                                <a href="#">5</a>
                            </li>
                            <li>
                                <a href="#">»</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <hr>
            </form>
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".btnedit").click(function () {
            $.jq_Panel({
                title: "修改兼职岗位",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "editJob.jsp"
            });
        });
        $(".btnadd").click(function () {
            $.jq_Panel({
                title: "添加兼职岗位",
                iframeHeight: 300,
                iframeWidth: 500,
                url: "addJob.jsp"
            })
        })
        // $(".add").click(function (){
        //     let j_id = $(this).attr("id")
        //     let u_id = $(this).attr("name")
        //     $.ajax({
        //         async:false,
        //         cache:false,
        //         type:"post",
        //         url:"addJob",
        //         data:{"j_id":j_id,"u_id":u_id},
        //         dataType: 'json',
        //         success:function (res){
        //             if(!res){
        //                 alert("添加失败")
        //             }else{
        //                 alert("添加成功"+j_id+"==="+u_id)
        //                 $.ajax({
        //                     async:false,
        //                     cache:false,
        //                     type:"get",
        //                     url:"Job?u_id="+u_id
        //                 })
        //             }
        //         }
        //     })
        // })

        $(".delete").click(function () {
            let j_id = $(this).attr("id")
            let u_id = $(this).attr("name")
            $.ajax({
                async:false,
                cache:false,
                type:"post",
                url:"deleteJob",
                data:{"j_id":j_id,"u_id":u_id},
                dataType:'json',
                success:function (res){
                    if(!res){
                        alert("删除失败")
                    }else {
                        alert("删除成功" + j_id + "===" + u_id)
                        // window.location.href = "job.jsp"
                        $.ajax({
                            async:false,
                            cache:false,
                            type:"get",
                            url:"Job?u_id="+u_id,})
                    }
                }
            });
        })


    })
</script>
</body>
</html>
