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

@WebServlet("/Xx_Zkzyxxexport")
public class Xx_Zkzyxxexport extends HttpServlet {
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
    		String XYDM=request.getParameter("xydm");
    		String ZYIDLSH = request.getParameter("zydm");
    		Calendar a=Calendar.getInstance();
    		String  TBYEAR = String.valueOf(a.get(Calendar.YEAR));
    		
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		

    		//ZKTBCXCY
    		ZKTBCXCY ZKTBCXCY=new ZKTBCXCY();
    		ZKTBCXCY.setTBYEAR(TBYEAR);
    		ZKTBCXCY.setXXDM(XXDM);
    		ZKTBCXCY.setXYDM(XYDM);
    		ZKTBCXCY.setZYIDLSH(ZYIDLSH);
    		ZKTBCXCY ZKTBCXCY1=univMapper.getZKTBCXCY(ZKTBCXCY);

    		
    		//ZKTBJIAOSHI
    		ZKTBJIAOSHI ZKTBJIAOSHI = new ZKTBJIAOSHI();
    		ZKTBJIAOSHI.setTBYEAR(TBYEAR);
    		ZKTBJIAOSHI.setXXDM(XXDM);
    		ZKTBJIAOSHI.setXYDM(XYDM);
    		ZKTBJIAOSHI.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJIAOSHI ZKTBJIAOSHI1 =univMapper.getZKTBJIAOSHI(ZKTBJIAOSHI);
    		
    		//ZKTBJIUYE
    		ZKTBJIUYE ZKTBJIUYE =new ZKTBJIUYE();
    		ZKTBJIUYE.setZKZYLSH(ZYIDLSH);
    		ZKTBJIUYE.setTBYEAR(TBYEAR);
    		ZKTBJIUYE.setXXDM(XXDM);
    		ZKTBJIUYE.setXYDM(XYDM);
    		ZKTBJIUYE ZKTBJIUYE1=univMapper.getZKTBJIUYE(ZKTBJIUYE);
    		
    		//ZKTBJSSZSP
    		ZKTBJSSZSP ZKTBJSSZSP =new ZKTBJSSZSP();
    		ZKTBJSSZSP.setTBYEAR(TBYEAR);
    		ZKTBJSSZSP.setXXDM(XXDM);
    		ZKTBJSSZSP.setXYDM(XYDM);
    		ZKTBJSSZSP.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJSSZSP ZKTBJSSZSP1=univMapper.getZKTBJSSZSP(ZKTBJSSZSP);
    	
    		
    		//ZKTBJXGG
    		ZKTBJXGG ZKTBJXGG =new ZKTBJXGG();
    		ZKTBJXGG.setTBYEAR(TBYEAR);
    		ZKTBJXGG.setXXDM(XXDM);
    		ZKTBJXGG.setXYDM(XYDM);
    		ZKTBJXGG.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJXGG ZKTBJXGG1=univMapper.getZKTBJXGG(ZKTBJXGG);
    		
    		//ZKTBJXTJ
    		ZKTBJXTJ ZKTBJXTJ =new ZKTBJXTJ();
    		ZKTBJXTJ.setTBYEAR(TBYEAR);
    		ZKTBJXTJ.setXXDM(XXDM);
    		ZKTBJXTJ.setXYDM(XYDM);
    		ZKTBJXTJ.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJXTJ ZKTBJXTJ1=univMapper.getZKTBJXTJ(ZKTBJXTJ);
    		
    		//ZKTBJYJBXX
    		ZKTBJYJBXX ZKTBJYJBXX =new ZKTBJYJBXX();
    		ZKTBJYJBXX.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJYJBXX.setXXDM(XXDM);
    		ZKTBJYJBXX.setXYDM(XYDM);
    		ZKTBJYJBXX.setTBYEAR(TBYEAR);
    		ZKTBJYJBXX ZKTBJYJBXX1=univMapper.getZKTBJYJBXX(ZKTBJYJBXX);
    		
    		//ZKTBPYFA
    		ZKTBPYFA ZKTBPYFA = new ZKTBPYFA();
    		ZKTBPYFA.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYFA.setTBYEAR(TBYEAR);
    		ZKTBPYFA.setXXDM(XXDM);
    		ZKTBPYFA.setXYDM(XYDM);
    		ZKTBPYFA ZKTBPYFA1=univMapper.getZKTBPYFA(ZKTBPYFA);
    		
    		
    		//ZKTBPYXG
    		ZKTBPYXG ZKTBPYXG =new ZKTBPYXG();
    		ZKTBPYXG.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYXG.setTBYEAR(TBYEAR);
    		ZKTBPYXG.setXXDM(XXDM);
    		ZKTBPYXG.setXYDM(XYDM);
    		ZKTBPYXG ZKTBPYXG1=univMapper.getZKTBPYXG(ZKTBPYXG);
    		
    		//ZKTBSJJX
    		ZKTBSJJX ZKTBSJJX = new ZKTBSJJX();
    		ZKTBSJJX.setTBYEAR(TBYEAR);
    		ZKTBSJJX.setXXDM(XXDM);
    		ZKTBSJJX.setXYDM(XYDM);
    		ZKTBSJJX.setZKZYIDLSH(ZYIDLSH);
    		ZKTBSJJX ZKTBSJJX1=univMapper.getZKTBSJJX(ZKTBSJJX);
  
    		//ZKTBSYB
    		ZKTBSYB ZKTBSYB =new ZKTBSYB();
    		ZKTBSYB.setZKZYIDLSH(ZYIDLSH);
    		ZKTBSYB.setTBYEAR(TBYEAR);
    		ZKTBSYB.setXXDM(XXDM);
    		ZKTBSYB.setXYDM(XYDM);
    		ZKTBSYB ZKTBSYB1=univMapper.getZKTBSYB(ZKTBSYB);
    		
    		//ZKTBZYXYL
    		ZKTBZYXYL ZKTBZYXYL =new ZKTBZYXYL();
    		ZKTBZYXYL.setZKZYIDLSH(ZYIDLSH);
    		ZKTBZYXYL.setTBYEAR(TBYEAR);
    		ZKTBZYXYL.setXXDM(XXDM);
    		ZKTBZYXYL.setXYDM(XYDM);
    		ZKTBZYXYL ZKTBZYXYL1=univMapper.getZKTBZYXYL(ZKTBZYXYL);
    		
    		//ZKTBZLBZ
    		ZKTBZLBZ ZKTBZLBZ = new ZKTBZLBZ();
    		ZKTBZLBZ.setTBYEAR(TBYEAR);
    		ZKTBZLBZ.setXXDM(XXDM);
    		ZKTBZLBZ.setXYDM(XYDM);
    		ZKTBZLBZ.setZKZYIDLSH(ZYIDLSH);
    		ZKTBZLBZ ZKTBZLBZ1=univMapper.getZKTBZLBZ(ZKTBZLBZ);
    		
    		 JSONArray jsonArray = new JSONArray();
    		 jsonArray.add(0,ZKTBCXCY1);
    		 jsonArray.add(1,ZKTBJIAOSHI1);
    		 jsonArray.add(2,ZKTBJIUYE1);
    		 jsonArray.add(3,ZKTBJSSZSP1);
    		 jsonArray.add(4,ZKTBJXGG1);
    		 jsonArray.add(5,ZKTBJXTJ1);
    		 jsonArray.add(6,ZKTBJYJBXX1);
    		 jsonArray.add(7,ZKTBPYFA1);
    		 jsonArray.add(8,ZKTBPYXG1);
    		 jsonArray.add(9,ZKTBSJJX1);
    		 jsonArray.add(10,ZKTBSYB1);
    		 jsonArray.add(11,ZKTBZYXYL1);
    		 jsonArray.add(12,ZKTBZLBZ1);
			
            System.out.println(jsonArray.toString());  

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
    
