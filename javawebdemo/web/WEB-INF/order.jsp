<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/2/2
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>订单</title>
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
        #right form{
            height: 50px;
            width: 100%;
            line-height: 50px;
            text-align: center;
            font-size: 18px;
        }
        #right form input{
            height: 30px;
        }
        #put1{
            width: 50px;
        }
        table{
            border-collapse: collapse;
            margin-top: 10px;
            margin-left: 10px;
            margin-right: 20px;
        }
        tr{
            width: 100%;
            height: 20px;
            text-align: center;
        }
        td{
            font-size: 14px;
        }
        td,th{
            width: 8.2%;
            border:1px solid black;
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
            <form action="/backed/order/fuzzysearch" method="post" >
                <input type="text" placeholder="订单号" name="key">
                <input type="submit" value="搜索" id="put1">
            </form>
            <c:if test="${not empty olist.data}">
                <table>
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>订单号</th>
                            <th>用户名</th>
                            <th>电话</th>
                            <th>商品</th>
                            <th>单价</th>
                            <th>数量</th>
                            <th>总价</th>
                            <th>时间</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <c:forEach items="${olist.data}" var="o">
                        <tbody>
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.order_num}</td>
                                <td>${o.cname}</td>
                                <td>${o.c_iphon}</td>
                                <td>${o.pname}</td>
                                <td>${o.price}</td>
                                <td>${o.pnum}</td>
                                <td>${o.sum}</td>
                                <td>${o.times}</td>
                                <td>${o.state}</td>
                                <td>
                                    <button>修改</button>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>
</body>
<script src="../../js/jquery-3.3.1.js"></script>
<script>
    $(function () {
        $("tbody tr:even").css("background-color","#D1D1D1");
    });
</script>
</html>
