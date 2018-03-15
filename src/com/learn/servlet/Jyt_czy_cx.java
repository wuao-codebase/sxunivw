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

@WebServlet("/Jytglcx")
public class Jyt_czy_cx extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    this.doPost(request, response);  
}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    		SqlSession sqlSession = null;
    		response.setContentType("application/json;charset=UTF-8");
    		PrintWriter out = response.getWriter();

    		
    			try{
        			sqlSession = SqlSessionFactoryUtil.openSqlSession();
            		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    			List<String> czylbs = Arrays.asList("4","3");
        		List<Czy> czys =univMapper.getCzys((czylbs));
        		for(Czy czy: czys)
        		{
        			if (czy.getCzylb().equals("4")) {
        				czy.setXxxm("陕西省教育厅");
        				czy.setCzyzl("教育厅管理员");
        				czy.setCzykl("********");
    				}
        			if(czy.getCzylb().equals("3")){
        				Xxm xxxm = univMapper.getXxm(czy.getXxdm());
            			czy.setXxxm(xxxm.getXxxm());
            			czy.setCzyzl("学校管理员");
            			czy.setCzykl("********");
        			}
        		}
        		JSONArray jsonArray = JSONArray.fromObject(czys);
    			out.print(jsonArray.toString());
    			out.flush();  
    	        out.close();
    			}catch(Exception ex){
            		System.err.println(ex.getMessage());
            	}finally {
        			if (sqlSession!=null) {
        				sqlSession.close();
        			}
        			}
    		}
    }

