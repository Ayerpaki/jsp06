package com.sc.servelt;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GoodsUpdate")
public class GoodsUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //文件上传
        //1、创建文件上传对象
        SmartUpload smartUpload = new SmartUpload();

        //2、初始化
        smartUpload.initialize(super.getServletConfig(),req,resp);

        //3、限制文件类型、大小等
        smartUpload.setAllowedFilesList("jpg,JPG,jpeg,JPEG,png,PNG,gif,GIF");

        String gimg="";
        try {
            //4、上传文件
            smartUpload.upload();
            //5、获取文件对象
            File file = smartUpload.getFiles().getFile(0);
            if(file.isMissing()){
                //把原图片名称给gimg
                gimg=smartUpload.getRequest().getParameter("gimg");
            }else{
                //获取upload文件夹所在的路径
                String path = req.getServletContext().getRealPath("upload");
                String name=path+"/"+file.getFileName();
                System.out.println("路径："+name);
                //6、另存文件到upload目录
                file.saveAs(name);
                gimg=file.getFileName();//把文件名称给gimg，存入数据库
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
            System.out.println("文件上传失败");
        }

        req.setCharacterEncoding("utf-8");

        //获取gid参数值
        Request request = smartUpload.getRequest();//上传下载组件的request对象
        String gidStr = request.getParameter("gid");
        int gid=Integer.parseInt(gidStr);

        String gname = request.getParameter("gname");
        String gpriceStr = request.getParameter("gprice");
        float gprice=Float.parseFloat(gpriceStr);
        String gstockStr = request.getParameter("gstock");
        int gstock=Integer.parseInt(gstockStr);
        int gnum=1;


        Goods goods=new Goods(gid,gname,gprice,gimg,gnum,gstock);

        GoodsDao goodsDao=new GoodsDao();
        try {
            goodsDao.update(goods);
            //修改成功后，重定向查询商品的servlet
            resp.sendRedirect("GoodsAll");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
