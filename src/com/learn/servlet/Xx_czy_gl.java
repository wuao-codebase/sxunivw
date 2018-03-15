package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.learn.po.Xyxx;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/Xxczygl")
public class Xx_czy_gl extends HttpServlet {
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
    		HttpSession session = request.getSession(false);
    		Czy use = (Czy)session.getAttribute("user");
    		String id = request.getParameter("id");
    		String czyxm = request.getParameter("lxr");
    		String czylxdh = request.getParameter("lxdh");
    		String xydm = request.getParameter("xydm");
    		String czyzghs = request.getParameter("czyzghs");
    		String czyzgh1 = request.getParameter("czygh");
		
    		if(id == null || id == ""){
    			
    			List<String> czylbs = Arrays.asList("3","2");
        		List<Czy> czys =univMapper.getCzys((czylbs));
        		List<Object> list = new ArrayList<Object>();
        		for(Czy czy: czys)
        		{
        			if(czy.getXxdm().equals(use.getXxdm())){
        			
        			if (czy.getCzylb().equals("3")) {
        				czy.setXxxm(use.getXxxm());
            			czy.setCzyzl("学校管理员");
    				}
        			if(czy.getCzylb().equals("2")){
        				
        				czy.setXxxm(use.getXxxm());
            			czy.setCzyzl("学院管理员");
            			if(czy.getXydm()!=null)
        				{
            				Xyxx xyxm = univMapper.getXyxm(czy.getXydm());
            				
            				czy.setXyxm(xyxm.getXymc());
            				
        				}
        			}
        			list.add(czy);
        			}
        		}
        		JSONArray jsonArray = JSONArray.fromObject(list);
    			out.print(jsonArray.toString());
    			 out.flush();  
    	            out.close();
    		}
    		if(id.equals("1")){

    			Czy cry = new Czy();
    			cry.setCzykl("12345678");
    			cry.setCzylb("3");
    			cry.setCzyxm(czyxm);
    			String czyxlh = univMapper.getCsb().getCzyxlh();		
    			univMapper.upCzyxlh(String.valueOf(Integer.parseInt(czyxlh)+1));
    			cry.setCzyzgh(use.getXxdm()+czyxlh);
    			cry.setXxdm(use.getXxdm());
    			cry.setLxdh(czylxdh);
    			univMapper.insertCzy(cry);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
    		}
    		if(id.equals("2")){

    			Czy cry = new Czy();
    			cry.setCzykl("12345678");
    			cry.setCzylb("2");
    			cry.setCzyxm(czyxm);
    			String czyxlh = univMapper.getCsb().getCzyxlh();		
    			univMapper.upCzyxlh(String.valueOf(Integer.parseInt(czyxlh)+1));
    			cry.setCzyzgh(use.getXxdm()+czyxlh);
    			cry.setXxdm(use.getXxdm());
    			cry.setLxdh(czylxdh);
    			cry.setXydm(xydm);
    			univMapper.insertCzyxy(cry);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
    		}
    		if(id.equals("3")){
    			Czy cry = new Czy();
    			cry.setCzyxm(czyxm);
    			cry.setLxdh(czylxdh);
    			cry.setCzyzgh(czyzgh1); 			
    			univMapper.upCzy(cry);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
    		}
    		if(id.equals("4")){
        		String[] czyzgh = czyzghs.split(",");
        		for(String x:czyzgh){		
        			univMapper.deleteCzy(x);
        		}
    			JSONArray jsonArray = JSONArray.fromObject("[]");
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
