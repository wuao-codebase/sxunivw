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
import com.learn.po.Czy;
import com.learn.po.Gzzy;
import com.learn.po.XYZYPZB;
import com.learn.po.Zymc;
import com.learn.util.SqlSessionFactoryUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/Xyzyfiad")
public class Xyzyfiad extends HttpServlet {
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
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		HttpSession session = request.getSession(false);
    		Czy use = (Czy)session.getAttribute("user");
        	String id = request.getParameter("id");
        	String zylb = request.getParameter("zylb");
        	if (id == null || id == "") {
        		XYZYPZB xyzypzb = new XYZYPZB();
            	xyzypzb.setXydm(use.getXydm());
            	xyzypzb.setZylb(zylb);
            	List<XYZYPZB> xyzys = univMapper.getXYzyxm(xyzypzb);
            	if (zylb.equals("1")) {
            		for(XYZYPZB xyzy:xyzys){
            			Bkzy zymc = univMapper.getZyidlshb(xyzy.getZyidxlsh());
    					xyzy.setYijizy(zymc.getYijimc());
    					xyzy.setSanjizy(zymc.getSanjmc());
    					xyzy.setErjizy(zymc.getErjdmmc());
            		}	
				}
            	if (zylb.equals("2")) {
            		for(XYZYPZB xyzy:xyzys){
            		Gzzy zymc = univMapper.getZyidlsh(xyzy.getZyidxlsh());
					xyzy.setYijizy(zymc.getYijmc());
					xyzy.setSanjizy(zymc.getSanjmc());
					xyzy.setErjizy(zymc.getErjmc());
            		}
            	}
            	JSONArray strJson=JSONArray.fromObject(xyzys);  		
       		 	out.print(strJson);
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
