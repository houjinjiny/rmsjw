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
        .two #left{
            width: 15%;
            height: 100%;
            float: left;
            background-color: #F1F3F4;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="first">
        <jsp:include page="top.jsp"></jsp:include>
    </div>

    <div class="two">
        <div id="left">
            <jsp:include page="left.jsp"></jsp:include>
        </div>
        <div id="right">

        </div>
    </div>
</div>
</body>
</html>
