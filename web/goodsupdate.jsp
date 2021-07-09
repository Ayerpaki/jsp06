<%@ page import="com.sc.bean.Goods" %><%--
  Created by IntelliJ IDEA.
  User: 98089
  Date: 2021/4/9
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <%
        Goods g=(Goods) request.getAttribute("g");
    %>
    <h1>修改商品</h1>
    <form action="GoodsUpdate" method="post" enctype="multipart/form-data">
        <!--一定要设置商品编号的隐藏域-->
        <input type="hidden" name="gid" value="<%out.print(g.getGid());%>"><br>
        <input type="hidden" name="gimg" value="<%out.print(g.getGimg());%>"><br>
        商品名称：<input type="text" name="gname" value="<%out.print(g.getGname());%>"><br>
        商品价格：<input type="text" name="gprice" value="<%out.print(g.getGprice());%>"><br>
        库存数量：<input type="text" name="gstock" value="<%out.print(g.getGstock());%>"><br>
        商品图片：<input type="file" name="upload"><br>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>
