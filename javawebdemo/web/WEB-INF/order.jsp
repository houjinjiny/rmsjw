<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/2/15
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台</title>
    <link rel="stylesheet" href="../../layui/layui/css/layui.css">
    <link rel="stylesheet" href="../../static/css/order.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="font-size: 20px">后台管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" id="nav">
            <li class="layui-nav-item"><a href="">欢迎：${us.username}</a></li>
            <li class="layui-nav-item"><a href="/index.jsp">安全退出</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">消息提醒</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item">
                    <a class="dhl" href="/backed/index/home">首页</a>
                </li>
                <li class="layui-nav-item">
                    <a class="dhl" href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/backed/product/getall">商品查询</a></dd>
                        <dd><a href="/backed/index/addproduct">商品添加</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="dhl">交易管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/backed/order/getall">订单列表</a></dd>
                        <dd><a href="/backed/order/gethuo">发货管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" >
                    <a href="javascript:;" class="dhl">会员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/backed/customer/getAll">全部用户</a></dd>
                        <dd><a href="/backed/customer/getgold">超级会员</a></dd>
                        <dd><a href="/backed/customer/getnormal">普通用户</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="dhl">管理员</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/backed/user/getmsg">个人信息</a></dd>
                        <dd><a href="/backed/index/changemsg">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="one">
            <div id="oo">
                <div id="oo-o" class="rr">${i5}</div>
                <div id="oo-t">全部订单</div>
            </div>
            <div id="ot">
                <div id="ot-o" class="rr">${i6}</div>
                <div id="ot-t">已完成</div>
            </div>
            <div id="ott">
                <div id="ott-o" class="rr">${i2}</div>
                <div id="ott-t">待收款</div>
            </div>
            <div id="of">
                <div id="of-o" class="rr">${i1}</div>
                <div id="of-t">待发货</div>
            </div>
            <div id="ofi">
                <div id="ofi-o" class="rr">${i3}</div>
                <div id="ofi-t">待收货</div>
            </div>
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
<script src="../../layui/layui/layui.js"></script>
<script src="../../static/js/jquery-3.3.1.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    $(function () {
        $("thead th").css("background-color","#5CA7BA");
        $("tbody tr:even").css("background-color","#AED7ED");
        $("tbody tr:odd").css("background-color","#C6EDE8");
    });
</script>
</body>
</html>
