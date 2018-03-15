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

@WebServlet("/Bkzyxxbu")
public class Bkzyxxbu extends HttpServlet {
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
    		String ds = request.getParameter("ds");  
    		JSONArray json=JSONArray.fromObject(ds);
    		HttpSession session = request.getSession(false);
    		Czy use = (Czy)session.getAttribute("user");
    		String XXDM= use.getXxdm();
    		String XYDM=use.getXydm();
    		Calendar a=Calendar.getInstance();
    		String  TBYEAR = String.valueOf(a.get(Calendar.YEAR));
    		HashMap<String, String> result = new HashMap<String, String>();
    		for(int i=0;i<json.size();i++){
    			JSONObject jsonOne = json.getJSONObject(i); 
    			result.put(jsonOne.get("name").toString(), jsonOne.get("value").toString());
    		}  
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		Zypz xyzy = univMapper.getZYpzxx(use.getCzyzgh());
    		String ZYIDLSH = xyzy.getZydilsh();
    		//BKTBJYJBXX
    		BKTBJYJBXX BKTBJYJBXX =new BKTBJYJBXX();
    		BKTBJYJBXX.setBKZYIDLSH(ZYIDLSH);
    		BKTBJYJBXX.setXXDM(XXDM);
    		BKTBJYJBXX.setXYDM(XYDM);
    		BKTBJYJBXX.setTBYEAR(TBYEAR);
    		BKTBJYJBXX BKTBJYJBXX1=univMapper.getBKTBJYJBXX(BKTBJYJBXX);
    		BKTBJYJBXX1.setYSZYLX(result.get("YSZYLX"));
    		BKTBJYJBXX1.setXWSYQ(result.get("XWSYQ"));
    		univMapper.upBKTBJYJBXX(BKTBJYJBXX1);
    		
    		//BKTBPYFA
    		BKTBPYFA BKTBPYFA = new BKTBPYFA();
    		BKTBPYFA.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYFA.setTBYEAR(TBYEAR);
    		BKTBPYFA.setXXDM(XXDM);
    		BKTBPYFA.setXYDM(XYDM);
    		BKTBPYFA BKTBPYFA1=univMapper.getBKTBPYFA(BKTBPYFA);
    		BKTBPYFA1.setPYFAXDNF(result.get("PYFAXDNF"));
    		univMapper.upBKTBPYFA(BKTBPYFA1);
    		
    		
    		//BKTBPYXG
    		BKTBPYXG BKTBPYXG =new BKTBPYXG();
    		BKTBPYXG.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYXG.setTBYEAR(TBYEAR);
    		BKTBPYXG.setXXDM(XXDM);
    		BKTBPYXG.setXYDM(XYDM);
    		BKTBPYXG BKTBPYXG1=univMapper.getBKTBPYXG(BKTBPYXG);
    		BKTBPYXG1.setXJXSGBRS(result.get("XJXSGBRS"));
    		BKTBPYXG1.setSJXKJSCJRS(result.get("SJXKJSCJRS"));
    		BKTBPYXG1.setSJXKJSHJRS(result.get("SJXKJSHJRS"));
    		BKTBPYXG1.setWTJSHJRS(result.get("WTJSHJRS"));
    		BKTBPYXG1.setGJHYRS(result.get("GJHYRS"));
    		BKTBPYXG1.setXSRDJJFZ(result.get("XSRDJJFZ"));
    		BKTBPYXG1.setXSYBDYS(result.get("XSYBDYS"));
    		BKTBPYXG1.setXSZSDYS(result.get("XSZSDYS"));
    		BKTBPYXG1.setXSCJGYHDRS(result.get("XSCJGYHDRS"));
    		BKTBPYXG1.setJCXYRS(result.get("JCXYRS"));
    		univMapper.upBKTBPYXG(BKTBPYXG1);
    		
    		
    		//BKTBSYB
    		BKTBSYB BKTBSYB =new BKTBSYB();
    		BKTBSYB.setBKZYIDLSH(ZYIDLSH);
    		BKTBSYB.setTBYEAR(TBYEAR);
    		BKTBSYB.setXXDM(XXDM);
    		BKTBSYB.setXYDM(XYDM);
    		BKTBSYB BKTBSYB1=univMapper.getBKTBSYB(BKTBSYB);
    		BKTBSYB1.setZXSRS(result.get("ZXSRS"));
    		BKTBSYB1.setSJZSRS(result.get("SJZSRS"));
    		BKTBSYB1.setJNZRS(result.get("JNZRS"));
    		BKTBSYB1.setGATZRS(result.get("GATZRS"));
    		BKTBSYB1.setLXSZRS(result.get("LXSZRS"));
    		BKTBSYB1.setSJLQS(result.get("SJLQS"));
    		BKTBSYB1.setZZZSRS(result.get("ZZZSRS"));
    		BKTBSYB1.setZTCSRS(result.get("ZTCSRS"));
    		univMapper.upBKTBSYB(BKTBSYB1);
    		
    		
    		
    		
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
    
