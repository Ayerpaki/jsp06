<%@ page import="java.util.List" %>
<%@ page import="com.sc.bean.Goods" %><%--
  Created by IntelliJ IDEA.
  User: 98089
  Date: 2021/4/9
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h1>商品列表</h1>
        <h2>
            <a href="goodsadd.jsp">添加商品</a>
        </h2>
        商品编号-商品名称-商品价格-商品图片-购买数量-库存数量<br>
        <%
            List<Goods> list=(List<Goods>) request.getAttribute("goodslist");
            for (int i = 0; i < list.size(); i++) {
                Goods goods = list.get(i);
                out.println(goods.getGid()+"-");
                out.println(goods.getGname()+"-");
                out.println(goods.getGprice()+"-");
                out.println("<a href='GoodsDownload?name="+goods.getGimg()+"'>");
                out.println("<img alt='暂无图片' src='upload/"+goods.getGimg()+"' width='50px' height='40px'>");
                out.println("</a>"+"-");
                out.println(goods.getGnum()+"-");
                out.println(goods.getGstock());
                out.println(" <a href='GoodsGoUpdate?gid="+goods.getGid()+"'>修改</a>");
                out.println(" <a href='GoodsDel?gid="+goods.getGid()+"'>删除</a>");
                out.println("<br>");
            }
        %>

    </center>
</body>
</html>
