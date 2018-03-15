package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.tools.zip.Zip64Mode;

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
import com.learn.po.Czy;
import com.learn.po.Gzzy;
import com.learn.po.Xxm;
import com.learn.po.Zymc;
import com.learn.po.Zypz;
import com.learn.util.SqlSessionFactoryUtil;
import com.sun.jmx.snmp.internal.SnmpSecuritySubSystem;
import com.sun.xml.internal.bind.v2.runtime.Name;

import javassist.compiler.ast.NewExpr;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/Zyxxdelete")
public class Zyxxdelete extends HttpServlet {
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
    		HttpSession session = request.getSession(false);
    		Czy use = (Czy)session.getAttribute("user");
    		String XXDM= use.getXxdm();
    		String XYDM=use.getXydm();
    		Calendar a=Calendar.getInstance();
    		String  TBYEAR = String.valueOf(a.get(Calendar.YEAR));
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		Zypz xyzy = univMapper.getZYpzxx(use.getCzyzgh());
    		String ZYIDLSH = xyzy.getZydilsh();
    		

    		//BKTBCXCY
    		BKTBCXCY BKTBCXCY=new BKTBCXCY();
    		BKTBCXCY.setTBYEAR(TBYEAR);
    		BKTBCXCY.setXXDM(XXDM);
    		BKTBCXCY.setXYDM(XYDM);
    		BKTBCXCY.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBCXCY(BKTBCXCY);

    		
    		//BKTBJIAOSHI
    		BKTBJIAOSHI BKTBJIAOSHI = new BKTBJIAOSHI();
    		BKTBJIAOSHI.setTBYEAR(TBYEAR);
    		BKTBJIAOSHI.setXXDM(XXDM);
    		BKTBJIAOSHI.setXYDM(XYDM);
    		BKTBJIAOSHI.setBKZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBJIAOSHI(BKTBJIAOSHI);
    		
    		//BKTBJIUYE
    		BKTBJIUYE BKTBJIUYE =new BKTBJIUYE();
    		BKTBJIUYE.setBKZYLSH(ZYIDLSH);
    		BKTBJIUYE.setTBYEAR(TBYEAR);
    		BKTBJIUYE.setXXDM(XXDM);
    		BKTBJIUYE.setXYDM(XYDM);
    		univMapper.deleteBKTBJIUYE(BKTBJIUYE);
    		
    		//BKTBJSSZSP
    		BKTBJSSZSP BKTBJSSZSP =new BKTBJSSZSP();
    		BKTBJSSZSP.setTBYEAR(TBYEAR);
    		BKTBJSSZSP.setXXDM(XXDM);
    		BKTBJSSZSP.setXYDM(XYDM);
    		BKTBJSSZSP.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBJSSZSP(BKTBJSSZSP);
    	
    		
    		//BKTBJXGG
    		BKTBJXGG BKTBJXGG =new BKTBJXGG();
    		BKTBJXGG.setTBYEAR(TBYEAR);
    		BKTBJXGG.setXXDM(XXDM);
    		BKTBJXGG.setXYDM(XYDM);
    		BKTBJXGG.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBJXGG(BKTBJXGG);
    		
    		//BKTBJXTJ
    		BKTBJXTJ BKTBJXTJ =new BKTBJXTJ();
    		BKTBJXTJ.setTBYEAR(TBYEAR);
    		BKTBJXTJ.setXXDM(XXDM);
    		BKTBJXTJ.setXYDM(XYDM);
    		BKTBJXTJ.setBKZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBJXTJ(BKTBJXTJ);
    		
    		//BKTBJYJBXX
    		BKTBJYJBXX BKTBJYJBXX =new BKTBJYJBXX();
    		BKTBJYJBXX.setBKZYIDLSH(ZYIDLSH);
    		BKTBJYJBXX.setXXDM(XXDM);
    		BKTBJYJBXX.setXYDM(XYDM);
    		BKTBJYJBXX.setTBYEAR(TBYEAR);
    		univMapper.deleteBKTBJYJBXX(BKTBJYJBXX);
    		
    		//BKTBPYFA
    		BKTBPYFA BKTBPYFA = new BKTBPYFA();
    		BKTBPYFA.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYFA.setTBYEAR(TBYEAR);
    		BKTBPYFA.setXXDM(XXDM);
    		BKTBPYFA.setXYDM(XYDM);
    		univMapper.deleteBKTBPYFA(BKTBPYFA);
    		
    		
    		//BKTBPYXG
    		BKTBPYXG BKTBPYXG =new BKTBPYXG();
    		BKTBPYXG.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYXG.setTBYEAR(TBYEAR);
    		BKTBPYXG.setXXDM(XXDM);
    		BKTBPYXG.setXYDM(XYDM);
    		univMapper.deleteBKTBPYXG(BKTBPYXG);
    		
    		//BKTBSJJX
    		BKTBSJJX BKTBSJJX = new BKTBSJJX();
    		BKTBSJJX.setTBYEAR(TBYEAR);
    		BKTBSJJX.setXXDM(XXDM);
    		BKTBSJJX.setXYDM(XYDM);
    		BKTBSJJX.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBSJJX(BKTBSJJX);
  
    		//BKTBSYB
    		BKTBSYB BKTBSYB =new BKTBSYB();
    		BKTBSYB.setBKZYIDLSH(ZYIDLSH);
    		BKTBSYB.setTBYEAR(TBYEAR);
    		BKTBSYB.setXXDM(XXDM);
    		BKTBSYB.setXYDM(XYDM);
    		univMapper.deleteBKTBSYB(BKTBSYB);
    		
    		//BKTBZYXYL
    		BKTBZYXYL BKTBZYXYL =new BKTBZYXYL();
    		BKTBZYXYL.setBKZYIDLSH(ZYIDLSH);
    		BKTBZYXYL.setTBYEAR(TBYEAR);
    		BKTBZYXYL.setXXDM(XXDM);
    		BKTBZYXYL.setXYDM(XYDM);
    		univMapper.deleteBKTBZYXYL(BKTBZYXYL);
    		
    		//BKTBZLBZ
    		BKTBZLBZ BKTBZLBZ = new BKTBZLBZ();
    		BKTBZLBZ.setTBYEAR(TBYEAR);
    		BKTBZLBZ.setXXDM(XXDM);
    		BKTBZLBZ.setXYDM(XYDM);
    		BKTBZLBZ.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBZLBZ(BKTBZLBZ);
    		 JSONArray jsonArray = JSONArray.fromObject("[]");
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
    
