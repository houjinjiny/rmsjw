<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/2/15
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台</title>
    <link rel="stylesheet" href="../../layui/layui/css/layui.css">
    <link rel="stylesheet" href="../../static/css/home.css">
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
        <div class="left">
            <div id="left-three">
                <p>公告：以下为待处理的业务</p>
            </div>
            <div id="left-one">
                <div id="lo-o">
                    <span>待发货</span>
                    <a href="/backed/order/daifh">查看详情</a>
                    <div>${i1}单</div>
                </div>
                <div id="lo-t">
                    <span>待收款</span>
                    <a href="/backed/order/daisk">查看详情</a>
                    <div>${i2}单</div>
                </div>
            </div>
            <div id="left-two">
                <div id="lt-o">
                    <span>待收货</span>
                    <a href="/backed/order/daish">查看详情</a>
                    <div>${i3}单</div>
                </div>
                <div id="lt-t">
                    <span>待付款</span>
                    <a href="/backed/order/daifk">查看详情</a>
                    <div>${i4}单</div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../layui/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
