<%--
  Created by IntelliJ IDEA.
  User: 98089
  Date: 2021/4/7
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h1>欢迎来到我的商城主页！</h1>
        <h2>快快选购商品吧！</h2>
        <h2>
            <a href="cars.jsp">前往购物车</a><br>
            <a href="GoodsAll">进入商品管理页面</a>
        </h2>
        <%
            session.setAttribute("uid",1);//暂时模拟1号用户登录
        %>
        <div>
            商品名称：羽绒服00 <br>
            商品价格：68.00 <br>
            库存数量：700 <br>
            <a href="CarsAdd?gid=2">加入购物车</a>
        </div>
        <div>
            商品名称：牛仔裤 <br>
            商品价格：38.00 <br>
            库存数量：100 <br>
            <a href="CarsAdd?gid=3">加入购物车</a>
        </div>
        <div>
            商品名称：保暖裤 <br>
            商品价格：58.99 <br>
            库存数量：100 <br>
            <a href="CarsAdd?gid=4">加入购物车</a>
        </div>
        <div>
            商品名称：裙子 <br>
            商品价格：3000.00 <br>
            库存数量：333 <br>
            <a href="CarsAdd?gid=5">加入购物车</a>
        </div>
    </center>
</body>
</html>
