<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/15
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理首页</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .first{
            width: 100%;
            height: 60px;
            background-color: black;
            line-height: 50px;
        }
        .first h1{
            margin-left: 40px;
            float: left;
            color: white;
        }
        .first a{
            display: block;
            margin: auto auto;
            float: right;
            font-size: 20px;
            margin-right: 40px;
            color: white;
            text-decoration: none;
        }
        .first #ff{
            margin-right: 100px;
        }
        .two #left{
            width: 15%;
            height: 100%;
            float: left;
            background-color: black;
            text-align: center;
        }
        #left ul li{
            color: white;
            font-size: 20px;
            list-style: none;
            margin-top: 50px;
        }
        #right{
            width: 85%;
            float: right;
            background-color: deepskyblue;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="first">
        <h1>xxx后台管理系统</h1>
        <a href="#" id="ff">退出</a>
        <a href="#">修改密码</a>
    </div>
    <div class="two">
        <div id="left">
            <ul>
                <li>首页</li>
                <li>商品</li>
                <li>订单</li>
                <li>营销</li>
            </ul>
            <h1>欢迎${us.username}登录后台管理系统</h1>
            <a href="/backed/product/getall">获取所有商品数据</a>
        </div>
        <div id="right">

        </div>
    </div>
</div>


</body>
</html>
