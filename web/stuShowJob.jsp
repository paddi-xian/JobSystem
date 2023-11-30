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
            margin: auto;
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
        .main{
            display: flex;
            width:100%;
            height:200px;
            background-color: #555555;
            margin-top: 50px;
        }
        .child{
            border: 1px solid #dddddd;
            flex: 1;
            padding: 10px;
            width: 50px;
            background-color: yellow;
            /*height: 38px;*/
        }
    </style>
</head>
<body class="box">
<%--<div class="admin-content-body">--%>
<%--  <div class="am-cf am-padding am-padding-bottom-0">--%>

<div class="container con">
    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>
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
<div class="main">
    <div class="child">

    </div>
    <div class="child">2</div>
    <div class="child">3</div>
</div>
<div class="main">
    <div class="child">

    </div>
    <div class="child">2</div>
    <div class="child">3</div>
</div>
</body>
</html>
