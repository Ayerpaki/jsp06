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
import java.util.List;

@WebServlet("/GoodsAll")
public class GoodsAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao=new GoodsDao();
        try {
            //查询所有商品，获取集合
            List<Goods> list = goodsDao.selectAll();

            //把集合存入request，转发到页面上可以取出来
            req.setAttribute("goodslist",list);

            //转发到jsp页面
            req.getRequestDispatcher("goodsall.jsp").forward(req,resp);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
