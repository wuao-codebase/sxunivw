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

@WebServlet("/ZKZyxxdelete")
public class ZKZyxxdelete extends HttpServlet {
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
    		

    		//ZKTBCXCY
    		ZKTBCXCY ZKTBCXCY=new ZKTBCXCY();
    		ZKTBCXCY.setTBYEAR(TBYEAR);
    		ZKTBCXCY.setXXDM(XXDM);
    		ZKTBCXCY.setXYDM(XYDM);
    		ZKTBCXCY.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBCXCY(ZKTBCXCY);

    		
    		//ZKTBJIAOSHI
    		ZKTBJIAOSHI ZKTBJIAOSHI = new ZKTBJIAOSHI();
    		ZKTBJIAOSHI.setTBYEAR(TBYEAR);
    		ZKTBJIAOSHI.setXXDM(XXDM);
    		ZKTBJIAOSHI.setXYDM(XYDM);
    		ZKTBJIAOSHI.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBJIAOSHI(ZKTBJIAOSHI);
    		
    		//ZKTBJIUYE
    		ZKTBJIUYE ZKTBJIUYE =new ZKTBJIUYE();
    		ZKTBJIUYE.setZKZYLSH(ZYIDLSH);
    		ZKTBJIUYE.setTBYEAR(TBYEAR);
    		ZKTBJIUYE.setXXDM(XXDM);
    		ZKTBJIUYE.setXYDM(XYDM);
    		univMapper.deleteZKTBJIUYE(ZKTBJIUYE);
    		
    		//ZKTBJSSZSP
    		ZKTBJSSZSP ZKTBJSSZSP =new ZKTBJSSZSP();
    		ZKTBJSSZSP.setTBYEAR(TBYEAR);
    		ZKTBJSSZSP.setXXDM(XXDM);
    		ZKTBJSSZSP.setXYDM(XYDM);
    		ZKTBJSSZSP.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBJSSZSP(ZKTBJSSZSP);
    	
    		
    		//ZKTBJXGG
    		ZKTBJXGG ZKTBJXGG =new ZKTBJXGG();
    		ZKTBJXGG.setTBYEAR(TBYEAR);
    		ZKTBJXGG.setXXDM(XXDM);
    		ZKTBJXGG.setXYDM(XYDM);
    		ZKTBJXGG.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBJXGG(ZKTBJXGG);
    		
    		//ZKTBJXTJ
    		ZKTBJXTJ ZKTBJXTJ =new ZKTBJXTJ();
    		ZKTBJXTJ.setTBYEAR(TBYEAR);
    		ZKTBJXTJ.setXXDM(XXDM);
    		ZKTBJXTJ.setXYDM(XYDM);
    		ZKTBJXTJ.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBJXTJ(ZKTBJXTJ);
    		
    		//ZKTBJYJBXX
    		ZKTBJYJBXX ZKTBJYJBXX =new ZKTBJYJBXX();
    		ZKTBJYJBXX.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJYJBXX.setXXDM(XXDM);
    		ZKTBJYJBXX.setXYDM(XYDM);
    		ZKTBJYJBXX.setTBYEAR(TBYEAR);
    		univMapper.deleteZKTBJYJBXX(ZKTBJYJBXX);
    		
    		//ZKTBPYFA
    		ZKTBPYFA ZKTBPYFA = new ZKTBPYFA();
    		ZKTBPYFA.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYFA.setTBYEAR(TBYEAR);
    		ZKTBPYFA.setXXDM(XXDM);
    		ZKTBPYFA.setXYDM(XYDM);
    		univMapper.deleteZKTBPYFA(ZKTBPYFA);
    		
    		
    		//ZKTBPYXG
    		ZKTBPYXG ZKTBPYXG =new ZKTBPYXG();
    		ZKTBPYXG.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYXG.setTBYEAR(TBYEAR);
    		ZKTBPYXG.setXXDM(XXDM);
    		ZKTBPYXG.setXYDM(XYDM);
    		univMapper.deleteZKTBPYXG(ZKTBPYXG);
    		
    		//ZKTBSJJX
    		ZKTBSJJX ZKTBSJJX = new ZKTBSJJX();
    		ZKTBSJJX.setTBYEAR(TBYEAR);
    		ZKTBSJJX.setXXDM(XXDM);
    		ZKTBSJJX.setXYDM(XYDM);
    		ZKTBSJJX.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBSJJX(ZKTBSJJX);
  
    		//ZKTBSYB
    		ZKTBSYB ZKTBSYB =new ZKTBSYB();
    		ZKTBSYB.setZKZYIDLSH(ZYIDLSH);
    		ZKTBSYB.setTBYEAR(TBYEAR);
    		ZKTBSYB.setXXDM(XXDM);
    		ZKTBSYB.setXYDM(XYDM);
    		univMapper.deleteZKTBSYB(ZKTBSYB);
    		
    		//ZKTBZYXYL
    		ZKTBZYXYL ZKTBZYXYL =new ZKTBZYXYL();
    		ZKTBZYXYL.setZKZYIDLSH(ZYIDLSH);
    		ZKTBZYXYL.setTBYEAR(TBYEAR);
    		ZKTBZYXYL.setXXDM(XXDM);
    		ZKTBZYXYL.setXYDM(XYDM);
    		univMapper.deleteZKTBZYXYL(ZKTBZYXYL);
    		
    		//ZKTBZLBZ
    		ZKTBZLBZ ZKTBZLBZ = new ZKTBZLBZ();
    		ZKTBZLBZ.setTBYEAR(TBYEAR);
    		ZKTBZLBZ.setXXDM(XXDM);
    		ZKTBZLBZ.setXYDM(XYDM);
    		ZKTBZLBZ.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBZLBZ(ZKTBZLBZ);
    		
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
    
