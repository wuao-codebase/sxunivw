package com.learn.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Filedownload", urlPatterns = { "/Filedownload" })
public class Filedownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileInputStream in = null; //输入流
		ServletOutputStream out = null; //输出流
		try {
			//设置下载文件使用的报头
			request.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Type", "application/x-msdownload" );
			String aFilename =request.getParameter("PYFAURL");
			response.setHeader("Content-Disposition", "attachment; filename="+aFilename);
			// 读入文件
//			in = new FileInputStream("f:\\数据文件\\" + aFilename); 
			in = new FileInputStream("e:\\datarar\\" + aFilename); 
			//得到响应对象的输出流，用于向客户端输出二进制数据
			out = response.getOutputStream();
			out.flush();
			int aRead = 0;
			byte b[] = new byte[1024];
			while ((aRead = in.read(b)) != -1 & in != null) {
				out.write(b,0,aRead);
			}
			out.flush();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	}
}