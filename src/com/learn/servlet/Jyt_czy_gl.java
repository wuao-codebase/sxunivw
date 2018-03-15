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

@WebServlet("/Jytgl")
public class Jyt_czy_gl extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    this.doPost(request, response);  
}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    		SqlSession sqlSession = null;
    		response.setContentType("application/json;charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		String id = request.getParameter("id");
    		 int ip = Integer.parseInt(id);
    		String czyxm = request.getParameter("lxr");
    		String czylxdh = request.getParameter("lxdh");
    		String xxdm = request.getParameter("xxdm");
    		String czyzghs = request.getParameter("czyzghs");
    		String czyzgh1 = request.getParameter("czygh");

    		if(ip==1){
    			Czy cry = new Czy();
    			try{
        		sqlSession = SqlSessionFactoryUtil.openSqlSession();
            	UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    			cry.setCzykl("12345678");
    			cry.setCzylb("4");
    			cry.setCzyxm(czyxm);
    			String czyxlh = univMapper.getCsb().getCzyxlh();		
    			univMapper.upCzyxlh(String.valueOf(Integer.parseInt(czyxlh)+1));
    			cry.setCzyzgh("99999"+czyxlh);
    			cry.setXxdm("99999");
    			cry.setLxdh(czylxdh);
    			sqlSession.commit();
    			}catch(Exception ex){
            		System.err.println(ex.getMessage());
            		sqlSession.rollback();
            	}finally {
        			if (sqlSession!=null) {
        				sqlSession.close();
        			}
        			}
    			try{
            		sqlSession = SqlSessionFactoryUtil.openSqlSession();
                	UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    			univMapper.insertCzy(cry);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
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
    		if(ip==2){
    			Czy cry = new Czy();
    		try{
            	sqlSession = SqlSessionFactoryUtil.openSqlSession();
                UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    			cry.setCzykl("12345678");
    			cry.setCzylb("3");
    			cry.setCzyxm(czyxm);
    			String czyxlh = univMapper.getCsb().getCzyxlh();		
    			univMapper.upCzyxlh(String.valueOf(Integer.parseInt(czyxlh)+1));
    			cry.setCzyzgh(xxdm+czyxlh);
    			cry.setXxdm(xxdm);
    			cry.setLxdh(czylxdh);
    			sqlSession.commit();
			}catch(Exception ex){
        		System.err.println(ex.getMessage());
        		sqlSession.rollback();
        	}finally {
    			if (sqlSession!=null) {
    				sqlSession.close();
    			}
    			}
    		try{
            	sqlSession = SqlSessionFactoryUtil.openSqlSession();
                UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    			univMapper.insertCzy(cry);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
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
    		if(ip==3){
    		try{
                sqlSession = SqlSessionFactoryUtil.openSqlSession();
                 UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    			Czy cry = new Czy();
    			cry.setCzyxm(czyxm);
    			cry.setLxdh(czylxdh);
    			cry.setCzyzgh(czyzgh1); 			
    			univMapper.upCzy(cry);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
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
    		if(ip==4){
    			try{
                    sqlSession = SqlSessionFactoryUtil.openSqlSession();
                     UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
        		String[] czyzgh = czyzghs.split(",");
        		for(String x:czyzgh){		
        			univMapper.deleteCzy(x);
        		}
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
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
    
    }
