<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/30
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .first{
            width: 100%;
            height: 60px;
            background-color: #3388FF;
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
        .first h3{
            color: white;
            float: right;
            margin-right: 50px;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="first">
        <h1>xxx后台管理系统</h1>
        <a href="#" id="ff">退出</a>
        <h3>用户：${us.username}</h3>
    </div>
</div>
</body>
</html>
