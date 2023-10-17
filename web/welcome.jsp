<%--
  Created by IntelliJ IDEA.
  User: Bo'o'm
  Date: 2023/10/10
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎界面</title>
    <style type="text/css">
        .imgBox{
            border-top: 2px solid cadetblue;
            width: 100%;
            height:250px;
            margin:0 auto;
        }
        .imgBox img{
            width: 100%;
            height:250px;
            margin:0 auto;
        }
        .img1{
            display: block;
        }
        .img2{
            display:none;
        }
        .img3{
            display: none;
        }
        .img4{
            display: none;
        }
        .content{
            margin-top: 20px;
            border-style:solid;
            border-radius: 5px;
            border-left-width:25px;
            border-left-color: #67a8ec;
        }
    </style>
</head>
<body>
<div class="imgBox">
    <img class="img-slide img1" src="img/1.jpg" alt="1">
    <img class="img-slide img2" src="img/2.jpg" alt="2">
    <img class="img-slide img3" src="img/3.jpg" alt="3">
    <img class="img-slide img4" src="img/4.jpg" alt="4">
</div>
<div class="content">
    <h3 align="center">公告板</h3>
    <ul>
        <li><a href="#">广告位招租</a></li>
        <li><a href="#">广告位招租</a></li>
        <li><a href="#">广告位招租</a></li>
        <li><a href="#">广告位招租</a></li>
        <li><a href="#">...</a></li>
    </ul>
</div>
</body>
<script type="text/javascript">
    var index=0;
    function ChangeImg(){
        index++;
        var a=document.getElementsByClassName("img-slide");
        if(index>=a.length) index=0;
        for(var i=0;i<a.length;i++){
            a[i].style.display='none';
        }
        a[index].style.display='block';
    }
    setInterval(ChangeImg,3000);
</script>
</html>
