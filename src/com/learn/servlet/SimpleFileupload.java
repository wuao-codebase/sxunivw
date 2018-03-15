package com.learn.servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.learn.po.Czy;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SimpleFileupload
 */
@WebServlet("/simpleFileupload")
public class SimpleFileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
		//1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8"); 
        String value =null;
        InputStream in =null;
        String fileName =null;
		upload.setSizeMax(1024 * 1024 * 150);//设置上传的文件总的大小不能超过150M
		try {
			// 1. 得到 FileItem 的集合 items
			List<FileItem> /* FileItem */items = upload.parseRequest(request);
			// 2. 遍历 items:
			for (FileItem item : items) {
				// 若是一个一般的表单域, 打印信息
				if (item.isFormField()) {
					String name = item.getFieldName();
					 value = item.getString("utf-8");
					System.out.println(name + ": " + value);
					
					 HttpSession session = request.getSession(false);
						Czy use = (Czy)session.getAttribute("user");					
						String Xxdm =use.getXxdm();
						String xydm =use.getXydm();
						String zydm =use.getZydm();
						 System.out.print(zydm);
						if(zydm==null){
							 zydm=value;
							 System.out.print(zydm);
						}
						String type = ".rar";
						 fileName = "PYFA"+Xxdm+xydm+zydm+type;
						   fileName = "e:\\datarar\\" + fileName;//文件最终上传的位置
//						fileName = "f:\\数据文件\\" + fileName;//文件最终上传的位置
							System.out.println(fileName);
				
				}
				else {
					long sizeInBytes = item.getSize();
					System.out.println(fileName);
					System.out.println(sizeInBytes);
					 in = item.getInputStream();
				}
			}
			byte[] buffer = new byte[1024];
			int len = 0;
			OutputStream out = new FileOutputStream(fileName);

			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}

			out.close();
			in.close();

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject();  
		 jsonObject.put("result", "ok");
		 response.getWriter().write(jsonObject.toString());

	}
	
	
}