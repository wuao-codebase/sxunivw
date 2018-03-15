package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.learn.mapper.UnivMapper;
import com.learn.po.Bkzy;
import com.learn.po.Czy;
import com.learn.po.Gzzy;
import com.learn.po.Xxm;
import com.learn.po.Zypz;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    this.doPost(request, response);  
}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	SqlSession sqlSession = null;
    	try{  
    		response.setContentType("application/json;charset=UTF-8"); 
    		PrintWriter out=response.getWriter();
    		String userName = request.getParameter("userName");
        	String password = request.getParameter("password");
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		Czy czyer= univMapper.getCzy(userName);
    		if (czyer.getCzyzgh().equals(userName)&&czyer.getCzykl().equals(password)) {
    			if(czyer.getCzylb().equals("4")){
    				czyer.setXxxm("陕西省教育厅");
    				czyer.setCzyzl("教育厅管理员");
    			}
    			if(czyer.getCzylb().equals("3")){
    				Xxm xxxm = univMapper.getXxm(czyer.getXxdm());
        			czyer.setXxxm(xxxm.getXxxm());
        			czyer.setCzyzl("学校管理员");
    			}
    			if(czyer.getCzylb().equals("2")){
    				Xxm xxxm = univMapper.getXxm(czyer.getXxdm());
    				if(czyer.getXydm()!=null)
    				{
    					czyer.setXyxm(univMapper.getXyxm(czyer.getXydm()).getXymc());
    				}
        			czyer.setXxxm(xxxm.getXxxm());
        			czyer.setCzyzl("学院管理员");
    			}
    			if(czyer.getCzylb().equals("1")){
    				Xxm xxxm = univMapper.getXxm(czyer.getXxdm());
        			czyer.setXxxm(xxxm.getXxxm());
        			czyer.setCzyzl("专业管理员");
        			czyer.setXyxm(univMapper.getXyxm(czyer.getXydm()).getXymc());	
        			Zypz xyzy = univMapper.getZYpzxx(czyer.getCzyzgh());
        			czyer.setZydm(xyzy.getZydilsh());
                	if (xyzy.getZylb().equals("1")) {
                			czyer.setZylb("1");
                			Bkzy zymc = univMapper.getZyidlshb(xyzy.getZydilsh());
                			czyer.setZymc(zymc.getYijimc()+"-"+zymc.getErjdmmc()+"-"+zymc.getSanjmc());
    				}
                	if (xyzy.getZylb().equals("2")) {
                		czyer.setZylb("2");
                		Gzzy zymc = univMapper.getZyidlsh(xyzy.getZydilsh());
                		czyer.setZymc(zymc.getYijmc()+"-"+zymc.getErjmc()+"-"+zymc.getSanjmc());
                	}
    			}
    			request.getSession().setAttribute("user", czyer);
    			JSONArray jsonArray = JSONArray.fromObject(czyer);  
                System.out.println(jsonArray.toString());  


       		 	out.print(jsonArray.toString()); 

                out.flush();  
                out.close();
			}
    		
        	sqlSession.commit();
        	}catch(Exception ex){
        		System.err.println(ex.getMessage());
        		sqlSession.rollback();
        	}finally {
    			if (sqlSession!=null) {
    				sqlSession.close();
    			}
    		}

    }
    
    }
