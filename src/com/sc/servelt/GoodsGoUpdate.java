package com.sc.servelt;

import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GoodsGoUpdate")
public class GoodsGoUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取gid参数值
        String gidStr = req.getParameter("gid");
        int gid=Integer.parseInt(gidStr);

        //通过gid查询整个商品对象
        GoodsDao goodsDao=new GoodsDao();

        try {
            Goods goods=goodsDao.select(gid);

            req.setAttribute("g",goods);
            req.getRequestDispatcher("goodsupdate.jsp").forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
