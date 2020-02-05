<%--
  Created by IntelliJ IDEA.
  User: 17591
  Date: 2020/1/18
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .wk{
            background-color: #F1F3F4;
        }
        .one{
            margin-top: 30px;
        }
        a{
            color: #151515;
            text-decoration: none;
        }
        h3{
            color: #151515;
            margin-bottom: 30px;
        }
        #of{
            position: relative;
        }
        #tf{
            position: relative;
        }
        #sf{
            position: relative;
        }
        .image1{
            width: 25px;
            height: 25px;
            position: absolute;
            top: 0px;
            right: 20px;
        }
        .image1 img{
            width: 100%;
            height: 100%;
        }
        #off{
            margin-top: -25px;
            margin-left: 27px;
            background-color: #F6F7F7;
        }
        #off div{
            color: #151515;
            margin-bottom: 10px;
        }
        #tff{
            margin-top: -25px;
            margin-left: 27px;
            background-color: #F6F7F7;
        }
        #tff div{
            color: #151515;
            margin-bottom: 10px;
        }
        #sff{
            margin-top: -25px;
            margin-left: 27px;
            background-color: #F6F7F7;
        }
        #sff div{
            color: #151515;
            margin-bottom: 10px;
        }
        a:hover{
            background-color: darkgray;
        }
    </style>
</head>
<body>
<div class="wk">
    <div class="one">
        <div id="of" onclick="show('off')">
            <h3>商品管理</h3>
            <div class="image1">
                <img src="/images/zuo/1.png" id="offimages1">
            </div>
        </div>
        <div style="display: none" id="off">
            <div><a href="/backed/product/getall">商品查询</a></div>
            <div><a href="/backed/index/addproduct">商品添加</a></div>
        </div>
    </div>
    <div class="two">
        <div id="tf" onclick="show('tff')">
            <h3>订单管理</h3>
            <div class="image1">
                <img src="/images/zuo/1.png" id="tffimages1">
            </div>
        </div>
        <div style="display: none" id="tff">
            <div><a href="/backed/order/getall">查看订单</a></div>
            <div><a href="/backed/order/getreturn">退货订单</a></div>
            <div><a href="/backed/order/getwait">待办订单</a></div>
            <div><a href="backed/order/getdelivery">发货订单</a></div>
        </div>
    </div>
    <div class="second">
        <div id="sf" onclick="show('sff')">
            <h3>用户管理</h3>
            <div class="image1">
                <img src="/images/zuo/1.png" id="sffimages1">
            </div>
        </div>
        <div style="display: none" id="sff">
            <div><a href="/backed/customer/getAll">所有用户</a></div>
            <div><a href="/backed/customer/getnormal">普通用户</a></div>
            <div><a href="/backed/customer/getgold">会员用户</a></div>
        </div>
    </div>
</div>
</body>
<script src="../../js/jquery-3.3.1.js"></script>
<script>
    function show(c) {
        if(document.getElementById(c).style.display=='none'){
            document.getElementById(c).style.display='block';
            document.getElementById(c+"images1").src='/images/zuo/2.png';
        }else{
            document.getElementById(c).style.display='none';
            document.getElementById(c+"images1").src='/images/zuo/1.png';
        }
    }
</script>
</html>
