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
import com.learn.po.BKTBCXCY;
import com.learn.po.BKTBJIAOSHI;
import com.learn.po.BKTBJIUYE;
import com.learn.po.BKTBJSSZSP;
import com.learn.po.BKTBJXGG;
import com.learn.po.BKTBJXTJ;
import com.learn.po.BKTBJYJBXX;
import com.learn.po.BKTBPYFA;
import com.learn.po.BKTBPYXG;
import com.learn.po.BKTBSJJX;
import com.learn.po.BKTBSYB;
import com.learn.po.BKTBZLBZ;
import com.learn.po.BKTBZYXYL;
import com.learn.po.Bkzy;
import com.learn.po.Czy;
import com.learn.po.Gzzy;
import com.learn.po.XYZYPZB;
import com.learn.po.Xxm;
import com.learn.po.Xyxx;
import com.learn.po.ZKTBCXCY;
import com.learn.po.ZKTBJIAOSHI;
import com.learn.po.ZKTBJIUYE;
import com.learn.po.ZKTBJSSZSP;
import com.learn.po.ZKTBJXGG;
import com.learn.po.ZKTBJXTJ;
import com.learn.po.ZKTBJYJBXX;
import com.learn.po.ZKTBPYFA;
import com.learn.po.ZKTBPYXG;
import com.learn.po.ZKTBSJJX;
import com.learn.po.ZKTBSYB;
import com.learn.po.ZKTBZLBZ;
import com.learn.po.ZKTBZYXYL;
import com.learn.po.Zypz;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/Xxxyzysz")
public class Xx_xyzy_sz extends HttpServlet {
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
    		String XYDM = request.getParameter("xydm");
    		String zylb = request.getParameter("zylb");
    		String zylsh = request.getParameter("zylsh");
    		String ZYIDLSH = request.getParameter("zyidxlshs");
    		HttpSession session = request.getSession(false);
    		Czy use = (Czy)session.getAttribute("user");

    		if(id == null || id == ""){
    			
    			List<XYZYPZB> xyzys = univMapper.getXYZYPZB(use.getXxdm());
    			for(XYZYPZB xyzy:xyzys){
    				 Xyxx xyxm = univMapper.getXyxm(xyzy.getXydm());
    				
    					xyzy.setXyxm(xyxm.getXymc());
        				if(xyzy.getZylb().equals("1"))
        				{	
        					xyzy.setZylb("本科");
        					Bkzy zymc = univMapper.getZyidlshb(xyzy.getZyidxlsh());
        					xyzy.setYijizy(zymc.getYijimc());
        					xyzy.setSanjizy(zymc.getSanjmc());
        					xyzy.setErjizy(zymc.getErjdmmc());
        				}
        				if(xyzy.getZylb().equals("2"))
        				{
        					
        					xyzy.setZylb("高职");
        					Gzzy zymc = univMapper.getZyidlsh(xyzy.getZyidxlsh());
        					xyzy.setYijizy(zymc.getYijmc());
        					xyzy.setSanjizy(zymc.getSanjmc());
        					xyzy.setErjizy(zymc.getErjmc());
        				}
    			
    				
    				}
        		JSONArray jsonArray = JSONArray.fromObject(xyzys);
    			out.print(jsonArray.toString());
    			 out.flush();  
    	            out.close();
    				}
    
    		if(id.equals("1"))
    		{
    		XYZYPZB xyzypzb = new XYZYPZB();
    		xyzypzb.setXxdm(use.getXxdm());
    		xyzypzb.setXydm(XYDM);
    		xyzypzb.setZyidxlsh(zylsh);
    		xyzypzb.setZylb(zylb);
    		univMapper.insertXYZYPZB(xyzypzb);
    		JSONArray jsonArray = JSONArray.fromObject("[]");
			out.print(jsonArray.toString());
			 out.flush();  
	            out.close();

    		}
    		if(id.equals("2")){
    			String XXDM=use.getXxdm();
    			XYZYPZB xyzypzb = new XYZYPZB();
        		xyzypzb.setXxdm(XXDM);
        		xyzypzb.setXydm(XYDM);
        		xyzypzb.setZyidxlsh(ZYIDLSH);
        		univMapper.deleteXYZYPZB(xyzypzb);
        		Zypz Zypz =new Zypz();
        		Zypz.setXxdm(use.getXxdm());
        		Zypz.setXydm(XYDM);
        		Zypz.setZydilsh(ZYIDLSH);
        		Zypz zypzid = univMapper.getZYpzxxone(Zypz);
        		univMapper.deleteXYzyone(Zypz);
        		if(zypzid!=null){
        		univMapper.deleteCzy(zypzid.getCzydm());
        		if(zypzid.getZylb().equals("1")){
        			//BKTBCXCY
            		BKTBCXCY BKTBCXCY=new BKTBCXCY();
            		BKTBCXCY.setXXDM(XXDM);
            		BKTBCXCY.setXYDM(XYDM);
            		BKTBCXCY.setZYIDLSH(ZYIDLSH);
            		univMapper.deleteBKTBCXCYO(BKTBCXCY);

            		
            		//BKTBJIAOSHI
            		BKTBJIAOSHI BKTBJIAOSHI = new BKTBJIAOSHI();
            		BKTBJIAOSHI.setXXDM(XXDM);
            		BKTBJIAOSHI.setXYDM(XYDM);
            		BKTBJIAOSHI.setBKZYIDLSH(ZYIDLSH);
            		univMapper.deleteBKTBJIAOSHIO(BKTBJIAOSHI);
            		
            		//BKTBJIUYE
            		BKTBJIUYE BKTBJIUYE =new BKTBJIUYE();
            		BKTBJIUYE.setBKZYLSH(ZYIDLSH);
            		BKTBJIUYE.setXXDM(XXDM);
            		BKTBJIUYE.setXYDM(XYDM);
            		univMapper.deleteBKTBJIUYEO(BKTBJIUYE);
            		
            		//BKTBJSSZSP
            		BKTBJSSZSP BKTBJSSZSP =new BKTBJSSZSP();
            		BKTBJSSZSP.setXXDM(XXDM);
            		BKTBJSSZSP.setXYDM(XYDM);
            		BKTBJSSZSP.setZYIDLSH(ZYIDLSH);
            		univMapper.deleteBKTBJSSZSPO(BKTBJSSZSP);
            	
            		
            		//BKTBJXGG
            		BKTBJXGG BKTBJXGG =new BKTBJXGG();
            		BKTBJXGG.setXXDM(XXDM);
            		BKTBJXGG.setXYDM(XYDM);
            		BKTBJXGG.setZYIDLSH(ZYIDLSH);
            		univMapper.deleteBKTBJXGGO(BKTBJXGG);
            		
            		//BKTBJXTJ
            		BKTBJXTJ BKTBJXTJ =new BKTBJXTJ();
            		BKTBJXTJ.setXXDM(XXDM);
            		BKTBJXTJ.setXYDM(XYDM);
            		BKTBJXTJ.setBKZYIDLSH(ZYIDLSH);
            		univMapper.deleteBKTBJXTJO(BKTBJXTJ);
            		
            		//BKTBJYJBXX
            		BKTBJYJBXX BKTBJYJBXX =new BKTBJYJBXX();
            		BKTBJYJBXX.setBKZYIDLSH(ZYIDLSH);
            		BKTBJYJBXX.setXXDM(XXDM);
            		BKTBJYJBXX.setXYDM(XYDM);
            		univMapper.deleteBKTBJYJBXXO(BKTBJYJBXX);
            		
            		//BKTBPYFA
            		BKTBPYFA BKTBPYFA = new BKTBPYFA();
            		BKTBPYFA.setBKZYIDLSH(ZYIDLSH);
            		BKTBPYFA.setXXDM(XXDM);
            		BKTBPYFA.setXYDM(XYDM);
            		univMapper.deleteBKTBPYFAO(BKTBPYFA);
            		
            		
            		//BKTBPYXG
            		BKTBPYXG BKTBPYXG =new BKTBPYXG();
            		BKTBPYXG.setBKZYIDLSH(ZYIDLSH);
            		BKTBPYXG.setXXDM(XXDM);
            		BKTBPYXG.setXYDM(XYDM);
            		univMapper.deleteBKTBPYXGO(BKTBPYXG);
            		
            		//BKTBSJJX
            		BKTBSJJX BKTBSJJX = new BKTBSJJX();
            		BKTBSJJX.setXXDM(XXDM);
            		BKTBSJJX.setXYDM(XYDM);
            		BKTBSJJX.setZYIDLSH(ZYIDLSH);
            		univMapper.deleteBKTBSJJXO(BKTBSJJX);
          
            		//BKTBSYB
            		BKTBSYB BKTBSYB =new BKTBSYB();
            		BKTBSYB.setBKZYIDLSH(ZYIDLSH);
            		BKTBSYB.setXXDM(XXDM);
            		BKTBSYB.setXYDM(XYDM);
            		univMapper.deleteBKTBSYBO(BKTBSYB);
            		
            		//BKTBZYXYL
            		BKTBZYXYL BKTBZYXYL =new BKTBZYXYL();
            		BKTBZYXYL.setBKZYIDLSH(ZYIDLSH);
            		BKTBZYXYL.setXXDM(XXDM);
            		BKTBZYXYL.setXYDM(XYDM);
            		univMapper.deleteBKTBZYXYLO(BKTBZYXYL);
            		
            		//BKTBZLBZ
            		BKTBZLBZ BKTBZLBZ = new BKTBZLBZ();
            		BKTBZLBZ.setXXDM(XXDM);
            		BKTBZLBZ.setXYDM(XYDM);
            		BKTBZLBZ.setZYIDLSH(ZYIDLSH);
            		univMapper.deleteBKTBZLBZO(BKTBZLBZ);
        		}
        		if(zypzid.getZylb().equals("2")){
        			//ZKTBCXCY
            		ZKTBCXCY ZKTBCXCY=new ZKTBCXCY();
            		ZKTBCXCY.setXXDM(XXDM);
            		ZKTBCXCY.setXYDM(XYDM);
            		ZKTBCXCY.setZYIDLSH(ZYIDLSH);
            		univMapper.deleteZKTBCXCYO(ZKTBCXCY);

            		
            		//ZKTBJIAOSHI
            		ZKTBJIAOSHI ZKTBJIAOSHI = new ZKTBJIAOSHI();
            		ZKTBJIAOSHI.setXXDM(XXDM);
            		ZKTBJIAOSHI.setXYDM(XYDM);
            		ZKTBJIAOSHI.setZKZYIDLSH(ZYIDLSH);
            		univMapper.deleteZKTBJIAOSHIO(ZKTBJIAOSHI);
            		
            		//ZKTBJIUYE
            		ZKTBJIUYE ZKTBJIUYE =new ZKTBJIUYE();
            		ZKTBJIUYE.setZKZYLSH(ZYIDLSH);
            		ZKTBJIUYE.setXXDM(XXDM);
            		ZKTBJIUYE.setXYDM(XYDM);
            		univMapper.deleteZKTBJIUYEO(ZKTBJIUYE);
            		
            		//ZKTBJSSZSP
            		ZKTBJSSZSP ZKTBJSSZSP =new ZKTBJSSZSP();
            		ZKTBJSSZSP.setXXDM(XXDM);
            		ZKTBJSSZSP.setXYDM(XYDM);
            		ZKTBJSSZSP.setZKZYIDLSH(ZYIDLSH);
            		univMapper.deleteZKTBJSSZSPO(ZKTBJSSZSP);
            	
            		
            		//ZKTBJXGG
            		ZKTBJXGG ZKTBJXGG =new ZKTBJXGG();
            		ZKTBJXGG.setXXDM(XXDM);
            		ZKTBJXGG.setXYDM(XYDM);
            		ZKTBJXGG.setZKZYIDLSH(ZYIDLSH);
            		univMapper.deleteZKTBJXGGO(ZKTBJXGG);
            		
            		//ZKTBJXTJ
            		ZKTBJXTJ ZKTBJXTJ =new ZKTBJXTJ();
            		ZKTBJXTJ.setXXDM(XXDM);
            		ZKTBJXTJ.setXYDM(XYDM);
            		ZKTBJXTJ.setZKZYIDLSH(ZYIDLSH);
            		univMapper.deleteZKTBJXTJO(ZKTBJXTJ);
            		
            		//ZKTBJYJBXX
            		ZKTBJYJBXX ZKTBJYJBXX =new ZKTBJYJBXX();
            		ZKTBJYJBXX.setZKZYIDLSH(ZYIDLSH);
            		ZKTBJYJBXX.setXXDM(XXDM);
            		ZKTBJYJBXX.setXYDM(XYDM);
            		univMapper.deleteZKTBJYJBXXO(ZKTBJYJBXX);
            		
            		//ZKTBPYFA
            		ZKTBPYFA ZKTBPYFA = new ZKTBPYFA();
            		ZKTBPYFA.setZKZYIDLSH(ZYIDLSH);
            		ZKTBPYFA.setXXDM(XXDM);
            		ZKTBPYFA.setXYDM(XYDM);
            		univMapper.deleteZKTBPYFAO(ZKTBPYFA);
            		
            		
            		//ZKTBPYXG
            		ZKTBPYXG ZKTBPYXG =new ZKTBPYXG();
            		ZKTBPYXG.setZKZYIDLSH(ZYIDLSH);
            		ZKTBPYXG.setXXDM(XXDM);
            		ZKTBPYXG.setXYDM(XYDM);
            		univMapper.deleteZKTBPYXGO(ZKTBPYXG);
            		
            		//ZKTBSJJX
            		ZKTBSJJX ZKTBSJJX = new ZKTBSJJX();
            		ZKTBSJJX.setXXDM(XXDM);
            		ZKTBSJJX.setXYDM(XYDM);
            		ZKTBSJJX.setZKZYIDLSH(ZYIDLSH);
            		univMapper.deleteZKTBSJJXO(ZKTBSJJX);
          
            		//ZKTBSYB
            		ZKTBSYB ZKTBSYB =new ZKTBSYB();
            		ZKTBSYB.setZKZYIDLSH(ZYIDLSH);
            		ZKTBSYB.setXXDM(XXDM);
            		ZKTBSYB.setXYDM(XYDM);
            		univMapper.deleteZKTBSYBO(ZKTBSYB);
            		
            		//ZKTBZYXYL
            		ZKTBZYXYL ZKTBZYXYL =new ZKTBZYXYL();
            		ZKTBZYXYL.setZKZYIDLSH(ZYIDLSH);
            		ZKTBZYXYL.setXXDM(XXDM);
            		ZKTBZYXYL.setXYDM(XYDM);
            		univMapper.deleteZKTBZYXYLO(ZKTBZYXYL);
            		
            		//ZKTBZLBZ
            		ZKTBZLBZ ZKTBZLBZ = new ZKTBZLBZ();
            		ZKTBZLBZ.setXXDM(XXDM);
            		ZKTBZLBZ.setXYDM(XYDM);
            		ZKTBZLBZ.setZKZYIDLSH(ZYIDLSH);
            		univMapper.deleteZKTBZLBZO(ZKTBZLBZ);
        		}
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
