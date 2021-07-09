<%--
  Created by IntelliJ IDEA.
  User: 98089
  Date: 2021/4/9
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h1>添加商品</h1>
        <form action="GoodsAdd" method="post" enctype="multipart/form-data">
            商品名称：<input type="text" name="gname"><br>
            商品价格：<input type="text" name="gprice"><br>
            库存数量：<input type="text" name="gstock"><br>
            商品图片：<input type="file" name="upload"><br>
            <input type="submit" value="提交">
        </form>
    </center>
</body>
</html>
