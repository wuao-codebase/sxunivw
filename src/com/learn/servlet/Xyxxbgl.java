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
import com.learn.po.XYXXB;
import com.learn.po.Xxm;
import com.learn.po.Xyxx;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/Xyxxbgl")
public class Xyxxbgl extends HttpServlet {
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
    		
    		String xyid = request.getParameter("xyid");
    		String id = request.getParameter("id");
    		String xyxm = request.getParameter("xyxm");
    		String xb = request.getParameter("xb");
    		String rxnf = request.getParameter("rxnf");
    		String gzdw = request.getParameter("gzdw");
    		String yijizy = request.getParameter("yijizy");
    		String erjizy = request.getParameter("erjizy");
    		String ZYDM = request.getParameter("ZYDM");
    		String XZYDM = request.getParameter("XZYDM");
    		String XYDM = request.getParameter("XYDM");
    		String XXDM = request.getParameter("XXDM");
    		HttpSession session = request.getSession(false);
    		Czy use = (Czy)session.getAttribute("user");
    		String Xxdm=use.getXxdm();
    		String Xydm=use.getXydm();
    		String Zydm=use.getZydm();
    		if (Zydm==null && ZYDM==null) {
    			Zydm=XZYDM;
			}else {
				if (Zydm==null)
				{
					Zydm=ZYDM;
				}
			}
    		if (Xydm==null || Xydm == ""){
    			Xydm=XYDM;
    		}
    		if (Xxdm.equals("99999")){
    			Xxdm=XXDM;
    		}
    		if(id == null || id == ""){
    			XYXXB XYXXB =new XYXXB();
    			XYXXB.setXXDM(Xxdm);
    			XYXXB.setXYDM(Xydm);
    			XYXXB.setZYIDLSH(Zydm);
    			List<XYXXB> list =univMapper.getXYXXB(XYXXB);
    			list.get(0).setSIZE(String.valueOf(list.size()));
        		JSONArray jsonArray = JSONArray.fromObject(list);
    			out.print(jsonArray.toString());
    			 out.flush();  
    	            out.close();
    		}
    		if(id.equals("1")){
    			String ID = XYLSH();
    			XYXXB XYXXB =new XYXXB();
    			XYXXB.setID(ID);
    			XYXXB.setHYERJIDM(erjizy);
    			XYXXB.setHYYIJIDM(yijizy);
    			XYXXB.setRXNF(rxnf);
    			XYXXB.setXB(xb);
    			XYXXB.setXGZDW(gzdw);
    			XYXXB.setXM(xyxm);
    			XYXXB.setXXDM(Xxdm);
    			XYXXB.setXYDM(Xydm);
    			XYXXB.setZYIDLSH(Zydm);
    			univMapper.insertXYXXB(XYXXB);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
    		}
    		if(id.equals("2")){
    			XYXXB XYXXB =new XYXXB();
    			XYXXB.setID(xyid);
    			XYXXB.setHYERJIDM(erjizy);
    			XYXXB.setHYYIJIDM(yijizy);
    			XYXXB.setRXNF(rxnf);
    			XYXXB.setXB(xb);
    			XYXXB.setXGZDW(gzdw);
    			XYXXB.setXM(xyxm);
    			univMapper.upXYXXB(XYXXB);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
    		}
    		if(id.equals("3")){
    			XYXXB XYXXB =new XYXXB();
    			XYXXB.setID(xyid);
    			univMapper.deleteXYXXB(XYXXB);
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
    
    public String XYLSH() {
    	SqlSession sqlSession = null;
    	String  XYlsh = null;
    	try{
  		sqlSession = SqlSessionFactoryUtil.openSqlSession();
		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
		 XYlsh = univMapper.getCsb().getXYID();
			univMapper.upXyid(String.valueOf(Integer.parseInt(XYlsh)+1));
				sqlSession.commit();
    	}catch(Exception ex){
    		System.err.println(ex.getMessage());
    		sqlSession.rollback();
    	}finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return XYlsh;
	

    }
    
    }
