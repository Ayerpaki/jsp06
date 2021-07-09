package com.sc.servelt;

import com.sc.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GoodsDel")
public class GoodsDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取gid参数值
        String gidStr = req.getParameter("gid");
        int gid=Integer.parseInt(gidStr);

        GoodsDao goodsDao=new GoodsDao();
        try {
            //通过gid删除商品
            goodsDao.delete(gid);

            //删除成功后，重定向到查询商品的servlet
            resp.sendRedirect("GoodsAll");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
