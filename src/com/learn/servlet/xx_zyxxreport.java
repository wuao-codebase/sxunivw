package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import com.learn.po.Xxm;
import com.learn.po.Xyxx;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/xx_zyxxreport")
public class xx_zyxxreport extends HttpServlet {
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
    		Calendar a=Calendar.getInstance();
    		String  TBYEAR = String.valueOf(a.get(Calendar.YEAR));
    		List<XYZYPZB> sum =new ArrayList<XYZYPZB>();
    			List<XYZYPZB> bkxyzys = univMapper.getbkunreport(use.getXxdm(),TBYEAR);
    			if(bkxyzys!=null){
    			for(XYZYPZB xyzy:bkxyzys){
   				 Xyxx xyxm = univMapper.getXyxm(xyzy.getXydm());
   					xyzy.setXyxm(xyxm.getXymc());
       				xyzy.setZylb("本科");
       				Bkzy zymc = univMapper.getZyidlshb(xyzy.getZyidxlsh());
       				xyzy.setYijizy(zymc.getYijimc());
       				xyzy.setSanjizy(zymc.getSanjmc());
       				xyzy.setErjizy(zymc.getErjdmmc());
   				}
    			}
    			
    			List<XYZYPZB> zkxyzys = univMapper.getzkunreport(use.getXxdm(),TBYEAR);	
    			if (zkxyzys!=null) {
    			for(XYZYPZB xyzy:zkxyzys){
   				 Xyxx xyxm = univMapper.getXyxm(xyzy.getXydm());
   					xyzy.setXyxm(xyxm.getXymc());
   					xyzy.setZylb("高职");
					Gzzy zymc = univMapper.getZyidlsh(xyzy.getZyidxlsh());
					xyzy.setYijizy(zymc.getYijmc());
					xyzy.setSanjizy(zymc.getSanjmc());
					xyzy.setErjizy(zymc.getErjmc());
   				}
    			}
    			String bk =String.valueOf(bkxyzys.size());
    			String zk =String.valueOf(zkxyzys.size());
    			if(bkxyzys!=null){
    			sum.addAll(bkxyzys);
    			}
    			if(zkxyzys!=null){
    			sum.addAll(zkxyzys);
    			}
    			sum.get(0).setXxdm(bk);
    			sum.get(0).setXydm(zk);
    			JSONArray jsonArray = JSONArray.fromObject(sum);
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
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
