package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.learn.mapper.UnivMapper;
import com.learn.po.Czy;
import com.learn.po.Xxm;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/GetAllxxm")
public class GetAllxxm extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    this.doPost(request, response);  
}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	SqlSession sqlSession = null;
    	try{
    		response.setContentType("application/json;charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    			List<Xxm> xxms = univMapper.getAllxxm();
    			JSONArray jsonArray = JSONArray.fromObject(xxms);
	       		 out.print(jsonArray);
	   			 out.flush();  
	   	         out.close();
	   	      sqlSession.commit(); 
        	}catch(Exception ex){
        		System.err.println(ex.getMessage());
        	}finally {
    			if (sqlSession!=null) {
    				sqlSession.close();
    			}
    		}

    }
    
    }