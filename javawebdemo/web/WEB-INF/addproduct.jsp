<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/2/1
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加商品</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .bottom #left{
            width: 15%;
            height: 100%;
            float: left;
            background-color: #F1F3F4;
            text-align: center;
        }
        #right{
            margin-top: -20px;
            width: 85%;
            height: 100%;
            float: right;
        }
        form{
            text-align: center;
            width: 100%;
            height: 100%;
            font-size: 18px;
        }
        input{
            height: 30px;
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="top">
        <jsp:include page="top.jsp"></jsp:include>
    </div>
    <div class="bottom">
        <div id="left">
            <jsp:include page="left.jsp"></jsp:include>
        </div>
        <div id="right">
            <form action="/backed/product/addproduct" method="post"><br>
                <input type="text" placeholder="商品名称" name="pname"><br>
                <input type="text" placeholder="商品价格" name="price"><br>
                <input type="number" placeholder="商品数量" name="pnum"><br>
                <input type="submit" value="添加"  >
            </form>
        </div>
    </div>
</div>
</body>
</html>
