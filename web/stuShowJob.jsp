<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/11/14
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>兼职岗位页面</title>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="myplugs/js/plugs.js"></script>
    <style>
        .box {
            position: relative;
            background: rgba(255, 255, 255, 0.1);
            font-family: "Segoe UI", "Lucida Grande", Helvetica, Arial, "Microsoft YaHei", FreeSans, Arimo, "Droid Sans", "wenquanyi micro hei", "Hiragino Sans GB", "Hiragino Sans GB W3", FontAwesome, sans-serif;
            font-weight: 400;
            line-height: 1.6;
            color: #333;
            font-size: 1.6rem
        }

        .con {
            width: 100%;
            height: 400px;
            background-color: rgb(0 0 0 / 18%);
        }

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
        #myCarousel{
            margin-left: 130px;
        }

        .search {
            width: 1000px;
            height: 40px;
            /*border:2px solid black;*/
            margin:0px 0px 20px 100px;
        }

        .input {
            float: left;
            width: 500px;
            height: 40px;
            outline: none;
            border: none;
            background-color: #7777774d;
            border-radius: 10px 0px 0px 10px;
            margin-left:150px;
        }

        .button {
            float: left;
            width: 100px;
            height: 40px;
            background-color: #3333337a;
            border-radius: 0px 10px 10px 0px;
            border: none;
            outline: none;
        }

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
        .jq_dvpanel{
            transform: translate(10%,110%);
        }
    </style>
</head>
<body class="box">
<div class="container con">
    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img decoding="async" src="img/1.jpg" alt="First slide">
            </div>
            <div class="item">
                <img decoding="async" src="img/2.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img decoding="async" src="img/3.jpg" alt="Third slide">
            </div>
            <div class="item">
                <img decoding="async" src="img/4.jpg" alt="Fourth slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<hr>

<div class="search">
    <input type="text" class="input" placeholder="🔍 输入要搜索的内容">
    <input type="button" value="搜索" class="button">
</div>
<div class="am-g">
    <div class="am-u-sm-12">
        <form class="am-form"  action="addApplication" method="post">
            <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
<%--                    <th class="table-check"></th>--%>
                    <th class="table-title">兼职岗位名称</th>
                    <th class="table-title">学历要求</th>
                    <th class="table-title">工资</th>
                    <th class="table-title">工作时间</th>
                    <th class="table-title">公司名称</th>
                    <th class="table-set"></th>
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
                                    <button type="button" id="${job.j_id}"
                                            class="btnCheck am-btn am-btn-default am-btn-xs am-text-secondary am-hide-sm-only"
                                            name="${job.u_id}">查看更多</button>
                                </div>
                                <button type="button" id="${job.j_id}"
                                        class="btnApply am-btn am-btn-default am-btn-xs am-text-secondary am-hide-sm-only"
                                        name="${job.j_id}" onclick="addApplication('${job.j_id}')">发出申请</button>
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
                        <a href="StuShowJob?pageNum=${info.prePage}&pageSize=${pageSize}" class="page-button">上一页</a>
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
                        <a href="StuShowJob?pageNum=${i}&pageSize=${pageSize}" class="page-button">${i}</a>
                    </c:forEach>
                    <c:if test="${info.hasNextPage}">
                        <a href="StuShowJob?pageNum=${info.nextPage}&pageSize=${pageSize}" class="page-button">下一页</a>
                    </c:if>
                </div>
                <select onchange="window.location=this.value" style="display: inline;width: 80px;margin-left: 20px">
                    <option value="StuShowJob?pageNum=1&pageSize=5"<c:if test="${pageSize == 5}">selected</c:if>>5</option>
                    <option value="StuShowJob?pageNum=1&pageSize=10"<c:if test="${pageSize == 10}">selected</c:if>>10</option>
                    <option value="StuShowJob?pageNum=1&pageSize=15"<c:if test="${pageSize == 15}">selected</c:if>>15</option>
                </select>
            </div>
            <hr>
        </form>
    </div>
</div>
<script>
    $(function (){
        $(".btnCheck").click(function (){
            let j_id = $(this).attr("id");
            $.ajax({
                async:false,
                cache: false,
                type: "post",
                url: "isRecordServlet",
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
                title:"查看更多岗位信息",
                iframeWidth:500,
                iframeHeight:300,
                url:"checkJob.jsp"
            })
            window.addEventListener("message",e => {
                if(e.data == "closeAddRecord"){
                    $.jq_Panel_close();
                }
            })
        })
    })
    function addApplication(elementId) {
        var jId = elementId; // 获取按钮的id，也就是job.j_id
        if (jId != null && !isNaN(parseInt(jId))) { // 检查jId是否存在并且是数字
            $.ajax({
                url: '/addApplication', // 调用后端的/addApplication
                type: 'POST', // 使用POST方法提交请求
                data: { 'j_id': jId }, // 发送的数据，这里是jId
                success: function(result) { // 请求成功后的回调函数，result是后端返回的数据
                    if (result == '申请成功') { // 如果返回的是"申请成功"，那么...
                        alert('申请成功');
                    } else { // 如果返回的不是"申请成功"，那么...
                        // 在这里你可以执行你想做的操作，例如显示一个错误消息
                        alert('申请失败');
                    }
                },
                error: function(xhr, status, error) {
                    // 在这里你可以处理出现的错误，例如显示一个错误消息
                    alert('Error: ' + error);
                }
            });
        } else {
            alert('申请失败');
        }
    }
</script>
</body>
</html>
