<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/2/1
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户</title>
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
            <form action="/backed/customer/fuzzysearch" method="post" >
                <input type="text" placeholder="身份证号" name="key">
                <input type="submit" value="搜索" id="put1">
            </form>
            <c:if test="${not empty customerlist.data}">
                <table>
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>用户名</th>
                            <th>身份证号</th>
                            <th>手机号</th>
                            <th>邮箱</th>
                            <th>性别</th>
                            <th>地址</th>
                            <th>会员级别</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <c:forEach items="${customerlist.data}" var="d">
                        <tbody>
                            <tr>
                                <td>${d.id}</td>
                                <td>${d.cname}</td>
                                <td class="in">${d.id_number}</td>
                                <td>${d.iphone}</td>
                                <td>${d.email}</td>
                                <td>${d.sex}</td>
                                <td>${d.address}</td>
                                <td class="ty">${d.type}</td>
                                <td>
                                    <button onclick="upType(this)">升级</button>
                                    <button onclick="downType(this)">降级</button>
                                </td>
                            </tr>
                        </tbody>

                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty customerlist.data}">
                此用户不存在
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
    function upType(but) {
        var key=$(but).parent().parent().children().first().nextAll(".in").text();
        var ty=$(but).parent().parent().children().first().nextAll(".ty").text();

        $.post(
            "/backed/customer/uptype",
            {"key":key,"ty":ty},
            function (data) {
                var num=Number(data);
                var t=Number(Number(ty)+Number(1));
                if(num>0){
                    $(but).parent().parent().children().first().nextAll(".ty").text(t);
                }
            }
        )
    }
    function downType(but) {
        var key=$(but).parent().parent().children().first().nextAll(".in").text();
        var ty=$(but).parent().parent().children().first().nextAll(".ty").text();

        $.post(
            "/backed/customer/downtype",
            {"key":key,"ty":ty},
            function (data) {
                var num=Number(data);
                var t=Number(Number(ty)-Number(1));
                if(num>0){
                    $(but).parent().parent().children().first().nextAll(".ty").text(t);
                }
            }
        )
    }
</script>
</html>
