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
            <form action="/backed/product/fuzzysearch " method="post" >
                <input type="text" placeholder="搜索商品" name="key">
                <input type="submit" placeholder="搜索">
            </form>
            <c:if test="${not empty plist.data}">
                <table>
                    <tr>
                        <th>序号</th>
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>商品库存</th>
                        <th>商品在售</th>
                        <th>商品创建时间</th>
                        <th>商品更新时间</th>
                    </tr>

                    <c:forEach items="${plist.data}" var="p" >
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.pname}</td>
                            <td>${p.price}</td>
                            <td>${p.pnum}</td>
                            <td class="pt">${p.type}</td>
                            <td>${p.create_time}</td>
                            <td>${p.update_time}</td>
                            <td>
                                <button onclick="toType(this)">下架</button>
                                <button>修改</button>
                            </td>
                        </tr>
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
    function toType(but) {
        var id2=$(but).parent().parent().children().first().text();
        $.get(
            "/backed/product/totype",
            {id:id2},
            function (data) {
                var num=Number(data);
                if(num>0){
                    $(but).parent().parent().children().first().nextAll(".pt").text(1);
                }
            }
        )
    }
</script>
</html>
