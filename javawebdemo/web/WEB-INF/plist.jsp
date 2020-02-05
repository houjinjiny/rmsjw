<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/15
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
            <form action="/backed/product/fuzzysearch" method="post" >
                <input type="text" placeholder="搜索商品" name="key">
                <input type="submit" value="搜索" id="put1">
            </form>
            <c:if test="${not empty plist.data}">
                <table>
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>商品名称</th>
                            <th>商品价格</th>
                            <th>商品库存</th>
                            <th>商品在售</th>
                            <th>商品创建时间</th>
                            <th>商品更新时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <c:forEach items="${plist.data}" var="p" >
                        <tbody>
                            <tr>
                                <td>${p.id}</td>
                                <td>${p.pname}</td>
                                <td>${p.price}</td>
                                <td>${p.pnum}</td>
                                <td class="pt">${p.type}</td>
                                <td>${p.create_time}</td>
                                <td>${p.update_time}</td>
                                <td>
                                    <button onclick="toType(this)">下/上架</button>
                                    <button>修改</button>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${empty plist.data}">
                没有更多的商品
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
    function toType(but) {
        var id2=$(but).parent().parent().children().first().text();
        var ty=$(but).parent().parent().children().first().nextAll(".pt").text();
        // 下架
        if(0==ty){
            $.get(
                "/backed/product/totype",
                {"id":id2},
                function (data) {
                    var num=Number(data);
                    if(num>0){
                        $(but).parent().parent().children().first().nextAll(".pt").text(1);
                    }
                }
            )
        }else{
            //上架
            $.get(
                "/backed/product/uptype",
                {"id":id2},
                function (data) {
                    var num=Number(data);
                    if(num>0){
                        $(but).parent().parent().children().first().nextAll(".pt").text(0);
                    }
                }
            )
        }

    }
</script>
</html>
