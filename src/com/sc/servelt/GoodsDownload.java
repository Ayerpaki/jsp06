package com.sc.servelt;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsDownload")
public class GoodsDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //文件下载
        //1、创建文件下载对象
        SmartUpload smartUpload = new SmartUpload();

        //2、初始化
        smartUpload.initialize(super.getServletConfig(),req,resp);

        //3、设置浏览器弹出“下载对话框”
        smartUpload.setContentDisposition(null);

        try {
            //4、下载文件
            smartUpload.downloadFile("upload/"+name);
        } catch (SmartUploadException e) {
            e.printStackTrace();
            System.out.println("文件下载失败");
        }
    }
}
