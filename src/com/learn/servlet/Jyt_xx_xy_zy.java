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
import com.learn.po.Bkzy;
import com.learn.po.Csb;
import com.learn.po.Czy;
import com.learn.po.Gzzy;
import com.learn.po.XYZYPZB;
import com.learn.po.Xyxx;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/Jyt_xx_xy_zy")
public class Jyt_xx_xy_zy extends HttpServlet {
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
    		String id = request.getParameter("id");
    		String xydm = request.getParameter("xydm");
    		String xxdm = request.getParameter("xxdm");
    
    		
    		if(id == null || id == ""){
    			List<Xyxx> list = univMapper.getXyxx(xxdm);
    			JSONArray jsonArray = JSONArray.fromObject(list);
    			out.print(jsonArray.toString());
    			 out.flush();  
    	            out.close();  
    		}
    		if(id.equals("1")){
    			XYZYPZB xyzypzb = new XYZYPZB();
            	xyzypzb.setXydm(xydm);
            	xyzypzb.setZylb("1");
            	List<XYZYPZB> xyzys = univMapper.getXYzyxm(xyzypzb);
            	for(XYZYPZB xyzy:xyzys){
        			Bkzy zymc = univMapper.getZyidlshb(xyzy.getZyidxlsh());
        			xyzy.setZymc(zymc.getYijimc()+"-"+zymc.getErjdmmc()+"-"+zymc.getSanjmc());
        		}
    		 JSONArray jsonArray = JSONArray.fromObject(xyzys);
    		 out.print(jsonArray.toString());
			 out.flush();  
	         out.close();
    		}
    		if(id.equals("2")){
    			XYZYPZB xyzypzb = new XYZYPZB();
            	xyzypzb.setXydm(xydm);
            	xyzypzb.setZylb("2");
            	List<XYZYPZB> xyzys = univMapper.getXYzyxm(xyzypzb);
            	for(XYZYPZB xyzy:xyzys){
            	Gzzy zymc = univMapper.getZyidlsh(xyzy.getZyidxlsh());
            	xyzy.setZymc(zymc.getYijmc()+"-"+zymc.getErjmc()+"-"+zymc.getSanjmc());
            	}
        		 JSONArray jsonArray = JSONArray.fromObject(xyzys);
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