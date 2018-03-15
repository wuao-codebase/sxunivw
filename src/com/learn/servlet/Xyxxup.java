package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.learn.mapper.UnivMapper;
import com.learn.po.Csb;
import com.learn.po.Czy;
import com.learn.po.Xyxx;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/Xyxxup")
public class Xyxxup extends HttpServlet {
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
    		String id = request.getParameter("id");
    		Czy use = (Czy)session.getAttribute("user");
    		String jxdwmc = request.getParameter("jxdwmc");
    		String clnf = request.getParameter("clnf");
    		String lxr = request.getParameter("lxr");
    		String lxdh = request.getParameter("lxdh");
    		
    		if(id == null || id == ""){
    			List<Xyxx> list = univMapper.getXyxx(use.getXxdm());
    			JSONArray jsonArray = JSONArray.fromObject(list);
    			out.print(jsonArray.toString());
    			 out.flush();  
    	            out.close();  
    		}
    		if(id.equals("1")){
    		Csb csb=univMapper.getCsb();
    		univMapper.upXylh(String.valueOf(Integer.parseInt(csb.getYxsbxlh())+1));
    		 Xyxx xyxx = new Xyxx();
    		 xyxx.setXymc(jxdwmc);
    		 xyxx.setXydm(csb.getYxsbxlh());
    		 xyxx.setXxdm(use.getXxdm());
    		 xyxx.setLxr(lxr);
    		 xyxx.setLxrdh(lxdh);
    		 xyxx.setChenlinian(clnf);
    		 univMapper.insertXyxx(xyxx);
    		 JSONArray jsonArray = JSONArray.fromObject("[]");
    		 out.print(jsonArray.toString());
			 out.flush();  
	         out.close();
    		}
    		if(id.equals("2")){
    			String xydm = request.getParameter("xydm");
        		 Xyxx xyxx = new Xyxx();
        		 xyxx.setXymc(jxdwmc);
        		 xyxx.setLxr(lxr);
        		 xyxx.setLxrdh(lxdh);
        		 xyxx.setChenlinian(clnf);     		 
        		 xyxx.setXydm(xydm);
        		 univMapper.upXyxx(xyxx);
        		 JSONArray jsonArray = JSONArray.fromObject("[]");
        		 out.print(jsonArray.toString());
    			 out.flush();  
    	         out.close();
        		}
    		if(id.equals("3")){
    			String xydms = request.getParameter("xydms");
        		String[] xydm = xydms.split(",");
        		for(String x:xydm){		
        			univMapper.deleteXyxx(x);
        			univMapper.deleteXY(x);
        			univMapper.deleteXYzy(x);
        			univMapper.deleteXYCzy(x);
        			univMapper.deleteXYBKTBJYJBXX(x);
        			univMapper.deleteXYBKTBSYB(x);
        			univMapper.deleteXYBKTBPYXG(x);
        			univMapper.deleteXYBKTBJIUYE(x);
        			univMapper.deleteXYBKTBZYXYL(x);
        			univMapper.deleteXYBKTBPYFA(x);
        			univMapper.deleteXYBKTBJIAOSHI(x);
        			univMapper.deleteXYBKTBJXTJ(x);
        			univMapper.deleteXYBKTBSJJX(x);
        			univMapper.deleteXYBKTBCXCY(x);
        			univMapper.deleteXYBKTBJXGG(x);
        			univMapper.deleteXYBKTBJSSZSP(x);
        			univMapper.deleteXYBKTBZLBZ(x);
        			univMapper.deleteXYZKTBJYJBXX(x);
        			univMapper.deleteXYZKTBSYB(x);
        			univMapper.deleteXYZKTBPYXG(x);
        			univMapper.deleteXYZKTBJIUYE(x);
        			univMapper.deleteXYZKTBZYXYL(x);
        			univMapper.deleteXYZKTBPYFA(x);
        			univMapper.deleteXYZKTBJIAOSHI(x);
        			univMapper.deleteXYZKTBJXTJ(x);
        			univMapper.deleteXYZKTBSJJX(x);
        			univMapper.deleteXYZKTBCXCY(x);
        			univMapper.deleteXYZKTBJXGG(x);
        			univMapper.deleteXYZKTBJSSZSP(x);
        			univMapper.deleteXYZKTBZLBZ(x);
        			
        			
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