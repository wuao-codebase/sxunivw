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
import com.learn.po.ZKTBJYJBXX;
import com.learn.po.ZKTBPYFA;
import com.learn.po.ZKTBPYXG;
import com.learn.po.BKTBSJJX;
import com.learn.po.ZKTBSYB;
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

@WebServlet("/Zkzyxxbu")
public class Zkzyxxbu extends HttpServlet {
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
    		//ZKTBJYJBXX
    		ZKTBJYJBXX ZKTBJYJBXX =new ZKTBJYJBXX();
    		ZKTBJYJBXX.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJYJBXX.setXXDM(XXDM);
    		ZKTBJYJBXX.setXYDM(XYDM);
    		ZKTBJYJBXX.setTBYEAR(TBYEAR);
    		ZKTBJYJBXX ZKTBJYJBXX1=univMapper.getZKTBJYJBXX(ZKTBJYJBXX);
    		ZKTBJYJBXX1.setYSZYLX(result.get("YSZYLX"));
    		ZKTBJYJBXX1.setXWSYQ(result.get("XWSYQ"));
    		univMapper.upZKTBJYJBXX(ZKTBJYJBXX1);
    		
    		//ZKTBPYFA
    		ZKTBPYFA ZKTBPYFA = new ZKTBPYFA();
    		ZKTBPYFA.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYFA.setTBYEAR(TBYEAR);
    		ZKTBPYFA.setXXDM(XXDM);
    		ZKTBPYFA.setXYDM(XYDM);
    		ZKTBPYFA ZKTBPYFA1=univMapper.getZKTBPYFA(ZKTBPYFA);
    		ZKTBPYFA1.setPYFAXDNF(result.get("PYFAXDNF"));
    		univMapper.upZKTBPYFA(ZKTBPYFA1);
    		
    		
    		//ZKTBPYXG
    		ZKTBPYXG ZKTBPYXG =new ZKTBPYXG();
    		ZKTBPYXG.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYXG.setTBYEAR(TBYEAR);
    		ZKTBPYXG.setXXDM(XXDM);
    		ZKTBPYXG.setXYDM(XYDM);
    		ZKTBPYXG ZKTBPYXG1=univMapper.getZKTBPYXG(ZKTBPYXG);
    		ZKTBPYXG1.setXJXSGBRS(result.get("XJXSGBRS"));
    		ZKTBPYXG1.setSJXKJSCJRS(result.get("SJXKJSCJRS"));
    		ZKTBPYXG1.setSJXKJSHJRS(result.get("SJXKJSHJRS"));
    		ZKTBPYXG1.setWTJSHJRS(result.get("WTJSHJRS"));
    		ZKTBPYXG1.setGJHYRS(result.get("GJHYRS"));
    		ZKTBPYXG1.setXSRDJJFZ(result.get("XSRDJJFZ"));
    		ZKTBPYXG1.setXSYBDYS(result.get("XSYBDYS"));
    		ZKTBPYXG1.setXSZSDYS(result.get("XSZSDYS"));
    		ZKTBPYXG1.setXSCJGYHDRS(result.get("XSCJGYHDRS"));
    		ZKTBPYXG1.setJCXYRS(result.get("JCXYRS"));
    		univMapper.upZKTBPYXG(ZKTBPYXG1);
    		
    		
    		//ZKTBSYB
    		ZKTBSYB ZKTBSYB =new ZKTBSYB();
    		ZKTBSYB.setZKZYIDLSH(ZYIDLSH);
    		ZKTBSYB.setTBYEAR(TBYEAR);
    		ZKTBSYB.setXXDM(XXDM);
    		ZKTBSYB.setXYDM(XYDM);
    		ZKTBSYB ZKTBSYB1=univMapper.getZKTBSYB(ZKTBSYB);
    		ZKTBSYB1.setZXSRS(result.get("ZXSRS"));
    		ZKTBSYB1.setSJZSRS(result.get("SJZSRS"));
    		ZKTBSYB1.setJNZRS(result.get("JNZRS"));
    		ZKTBSYB1.setGATZRS(result.get("GATZRS"));
    		ZKTBSYB1.setLXSZRS(result.get("LXSZRS"));
    		ZKTBSYB1.setSJLQS(result.get("SJLQS"));
    		ZKTBSYB1.setZZZSRS(result.get("ZZZSRS"));
    		ZKTBSYB1.setZTCSRS(result.get("ZTCSRS"));
    		univMapper.upZKTBSYB(ZKTBSYB1);
    		
    		
    		
    		
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
    
