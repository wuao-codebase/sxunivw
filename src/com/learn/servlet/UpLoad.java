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

@WebServlet("/UpLoad")
public class UpLoad extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    this.doPost(request, response);  
}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	SqlSession sqlSession = null;
    	try{  
    		String TBLSH = TBLSH();
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
    		
    	

  
    		//BKTBCXCY
    		BKTBCXCY BKTBCXCY=new BKTBCXCY();
    		BKTBCXCY.setBKTBLSH(TBLSH);
    		BKTBCXCY.setCYKCBZ(result.get("CYKCBZ"));
    		BKTBCXCY.setCYZDJSRS(result.get("CYZDJSRS"));
    		BKTBCXCY.setGZRS(result.get("GZRS"));
    		BKTBCXCY.setTBYEAR(TBYEAR);
    		BKTBCXCY.setTXSZBZ(result.get("TXSZBZ"));
    		BKTBCXCY.setXXDM(XXDM);
    		BKTBCXCY.setXYDM(XYDM);
    		BKTBCXCY.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBCXCY(BKTBCXCY);
    		univMapper.insertBKTBCXCY(BKTBCXCY);
    		
    		//BKTBJIAOSHI
    		BKTBJIAOSHI BKTBJIAOSHI = new BKTBJIAOSHI();
    		BKTBJIAOSHI.setBKZYIDLSH(ZYIDLSH);
    		BKTBJIAOSHI.setBSJSZS(result.get("BSJSZS"));
    		BKTBJIAOSHI.setFGJSZS(result.get("FGJSZS"));
    		BKTBJIAOSHI.setJSZS(result.get("JSZS"));
    		BKTBJIAOSHI.setMEDIANJSZS(result.get("MEDIANJSZS"));
    		BKTBJIAOSHI.setSYJSZS(result.get("SYJSZS"));
    		BKTBJIAOSHI.setTBYEAR(TBYEAR);
    		BKTBJIAOSHI.setWPJSZS(result.get("WPJSZS"));
    		BKTBJIAOSHI.setXXDM(XXDM);
    		BKTBJIAOSHI.setXYDM(XYDM);
    		BKTBJIAOSHI.setYOUNGJSZS(result.get("YOUNGJSZS"));
    		BKTBJIAOSHI.setZGJSZS(result.get("ZGJSZS"));
    		BKTBJIAOSHI.setBKTBIDLSH(TBLSH);
    		univMapper.deleteBKTBJIAOSHI(BKTBJIAOSHI);
    		univMapper.insertBKTBJIAOSHI(BKTBJIAOSHI);
    		
    		//BKTBJIUYE
    		BKTBJIUYE BKTBJIUYE =new BKTBJIUYE();
    		BKTBJIUYE.setBKTBLSH(TBLSH);
    		BKTBJIUYE.setBKZYLSH(ZYIDLSH);
    		BKTBJIUYE.setBYSCCJYL(result.get("BYSCCJYL"));
    		BKTBJIUYE.setBYSMYD(result.get("BYSMYD"));
    		BKTBJIUYE.setTBYEAR(TBYEAR);
    		BKTBJIUYE.setXXDM(XXDM);
    		BKTBJIUYE.setXYDM(XYDM);
    		BKTBJIUYE.setZZCYRS(result.get("ZZCYRS"));
    		univMapper.deleteBKTBJIUYE(BKTBJIUYE);
    		univMapper.insertBKTBJIUYE(BKTBJIUYE);
    		
    		//BKTBJSSZSP
    		BKTBJSSZSP BKTBJSSZSP =new BKTBJSSZSP();
    		BKTBJSSZSP.setBKTBIDLSH(TBLSH);
    		BKTBJSSZSP.setDNCGFXS(result.get("DNCGFXS"));
    		BKTBJSSZSP.setDNCSCD(result.get("DNCSCD"));
    		BKTBJSSZSP.setDNCSSCI(result.get("DNCSSCI"));
    		BKTBJSSZSP.setDNEI(result.get("DNEI"));
    		BKTBJSSZSP.setDNGJJXJS(result.get("DNGJJXJS"));
    		BKTBJSSZSP.setDNGJJXMS(result.get("DNGJJXMS"));
    		BKTBJSSZSP.setDNGJKJJS(result.get("DNGJKJJS"));
    		BKTBJSSZSP.setDNHXDK(result.get("DNHXDK"));
    		BKTBJSSZSP.setDNISTP(result.get("DNISTP"));
    		BKTBJSSZSP.setDNSCI(result.get("DNSCI"));
    		BKTBJSSZSP.setDNSJJXJS(result.get("DNSJJXJS"));
    		BKTBJSSZSP.setDNSJKJJS(result.get("DNSJKJJS"));
    		BKTBJSSZSP.setDNSKZGJSS(result.get("DNSKZGJSS"));
    		BKTBJSSZSP.setDNSSCI(result.get("DNSSCI"));
    		BKTBJSSZSP.setDNZXDK(result.get("DNZXDK"));
    		BKTBJSSZSP.setGJJJXTDS(result.get("GJJJXTDS"));
    		BKTBJSSZSP.setGJJKYTDS(result.get("GJJKYTDS"));
    		BKTBJSSZSP.setGSPJSS(result.get("GSPJSS"));
    		BKTBJSSZSP.setSJJXTDS(result.get("SJJXTDS"));
    		BKTBJSSZSP.setSJKYTDS(result.get("SJKYTDS"));
    		BKTBJSSZSP.setDNSBXMS(result.get("DNSBXMS"));
    		BKTBJSSZSP.setDNZLS(result.get("DNZLS"));
    		BKTBJSSZSP.setDNRJZZQS(result.get("DNRJZZQS"));
    		BKTBJSSZSP.setTBYEAR(TBYEAR);
    		BKTBJSSZSP.setXXDM(XXDM);
    		BKTBJSSZSP.setXYDM(XYDM);
    		BKTBJSSZSP.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBJSSZSP(BKTBJSSZSP);
    		univMapper.insertBKTBJSSZSP(BKTBJSSZSP);
    		
    		//BKTBJXGG
    		BKTBJXGG BKTBJXGG =new BKTBJXGG();
    		BKTBJXGG.setBKTBIDLSH(TBLSH);
    		BKTBJXGG.setDNGJJJCS(result.get("DNGJJJCS"));
    		BKTBJXGG.setDNGJJJPKCS(result.get("DNGJJJPKCS"));
    		BKTBJXGG.setDNGJJJXCGJ(result.get("DNGJJJXCGJ"));
    		BKTBJXGG.setDNJGLWS(result.get("DNJGLWS"));
    		BKTBJXGG.setDNQTJCS(result.get("DNQTJCS"));
    		BKTBJXGG.setDNSJJJXCGJ(result.get("DNSJJJXCGJ"));
    		BKTBJXGG.setDNSJJPKCS(result.get("DNSJJPKCS"));
    		BKTBJXGG.setDNSJJXCGJS(result.get("DNSJJXCGJS"));
    		BKTBJXGG.setDNSJJXYJS(result.get("DNSJJXYJS"));
    		BKTBJXGG.setDNSJYXJCS(result.get("DNSJYXJCS"));
    		BKTBJXGG.setSJRCPYSYCS(result.get("SJRCPYSYCS"));
    		BKTBJXGG.setTBYEAR(TBYEAR);
    		BKTBJXGG.setXXDM(XXDM);
    		BKTBJXGG.setXYDM(XYDM);
    		BKTBJXGG.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBJXGG(BKTBJXGG);
    		univMapper.insertBKTBJXGG(BKTBJXGG);
    		
    		//BKTBJXTJ
    		BKTBJXTJ BKTBJXTJ =new BKTBJXTJ();
    		BKTBJXTJ.setBKZYTBLSH(TBLSH);
    		BKTBJXTJ.setDNJXJF(result.get("DNJXJF"));
    		BKTBJXTJ.setDNRJF(result.get("DNRJF"));
    		BKTBJXTJ.setDNSBF(result.get("DNSBF"));
    		BKTBJXTJ.setTBYEAR(TBYEAR);
    		BKTBJXTJ.setXXDM(XXDM);
    		BKTBJXTJ.setXYDM(XYDM);
    		BKTBJXTJ.setZRJF(result.get("ZRJF"));
    		BKTBJXTJ.setZSBF(result.get("ZSBF"));
    		BKTBJXTJ.setBKZYIDLSH(ZYIDLSH);
    		BKTBJXTJ.setZYTUSHU(result.get("ZYTUSHU"));
    		univMapper.deleteBKTBJXTJ(BKTBJXTJ);
    		univMapper.insertBKTBJXTJ(BKTBJXTJ);
    		
    		//BKTBJYJBXX
    		BKTBJYJBXX BKTBJYJBXX =new BKTBJYJBXX();
    		BKTBJYJBXX.setBKTBLSH(TBLSH);
    		BKTBJYJBXX.setBKZYIDLSH(ZYIDLSH);
    		BKTBJYJBXX.setBSDBZ(result.get("BSDBZ"));
    		BKTBJYJBXX.setGCRZBZ(result.get("GCRZBZ"));
    		BKTBJYJBXX.setSSDBZ(result.get("SSDBZ"));
    		BKTBJYJBXX.setSXYLZYBZ(result.get("SXYLZYBZ"));
    		BKTBJYJBXX.setXXDM(XXDM);
    		BKTBJYJBXX.setXYDM(XYDM);
    		BKTBJYJBXX.setZYBXRQ(result.get("ZYBXRQ"));
    		BKTBJYJBXX.setTBYEAR(TBYEAR);
    		BKTBJYJBXX.setYSZYLX(result.get("YSZYLX"));
    		BKTBJYJBXX.setXWSYQ(result.get("XWSYQ"));
    		univMapper.deleteBKTBJYJBXX(BKTBJYJBXX);
    		univMapper.insertBKTBJYJBXX(BKTBJYJBXX);
    		
    		//BKTBPYFA
    		BKTBPYFA BKTBPYFA = new BKTBPYFA();
    		BKTBPYFA.setBKTBIDLSH(TBLSH);
    		BKTBPYFA.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYFA.setBYXFZS(result.get("BYXFZS"));
    		BKTBPYFA.setLLXFZS(result.get("LLXFZS"));
    		BKTBPYFA.setPYFAURL("PYFA"+XXDM+XYDM+ZYIDLSH+".rar");
    		BKTBPYFA.setTBYEAR(TBYEAR);
    		BKTBPYFA.setXXDM(XXDM);
    		BKTBPYFA.setXXKXFZS(result.get("XXKXFZS"));
    		BKTBPYFA.setXYDM(XYDM);
    		BKTBPYFA.setSJKXFZS(result.get("SJKXFZS"));
    		BKTBPYFA.setCXXFZS(result.get("CXXFZS"));
    		BKTBPYFA.setPYFAXDNF(result.get("PYFAXDNF"));
    		univMapper.deleteBKTBPYFA(BKTBPYFA);
    		univMapper.insertBKTBPYFA(BKTBPYFA);
    		
    		
    		//BKTBPYXG
    		BKTBPYXG BKTBPYXG =new BKTBPYXG();
    		BKTBPYXG.setBKTBLSH(TBLSH);
    		BKTBPYXG.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYXG.setGJDCS(result.get("GJDCS"));
    		BKTBPYXG.setGJXKJSCJRS(result.get("GJXKJSCJRS"));
    		BKTBPYXG.setGJXKJSDJS(result.get("GJXKJSDJS"));
    		BKTBPYXG.setJXJS(result.get("JXJS"));
    		BKTBPYXG.setLJTGL(result.get("LJTGL"));
    		BKTBPYXG.setLWS(result.get("LWS"));
    		BKTBPYXG.setSJDCS(result.get("SJDCS"));
    		BKTBPYXG.setSJJLS(result.get("SJJLS"));
    		BKTBPYXG.setSJTGL(result.get("SJTGL"));
    		BKTBPYXG.setSNGJHLWDJS(result.get("SNGJHLWDJS"));
    		BKTBPYXG.setSNSXHLWDJS(result.get("SNSXHLWDJS"));
    		BKTBPYXG.setSXXKJSCJRS(result.get("SXXKJSCJRS"));
    		BKTBPYXG.setSXXKJSDJS(result.get("SXXKJSDJS"));
    		BKTBPYXG.setTBYEAR(TBYEAR);
    		BKTBPYXG.setXXDM(XXDM);
    		BKTBPYXG.setXYDM(XYDM);
    		BKTBPYXG.setZLS(result.get("ZLS"));
    		BKTBPYXG.setXJXSGBRS(result.get("XJXSGBRS"));
    		BKTBPYXG.setSJXKJSCJRS(result.get("SJXKJSCJRS"));
    		BKTBPYXG.setSJXKJSHJRS(result.get("SJXKJSHJRS"));
    		BKTBPYXG.setWTJSHJRS(result.get("WTJSHJRS"));
    		BKTBPYXG.setGJHYRS(result.get("GJHYRS"));
    		BKTBPYXG.setXSRDJJFZ(result.get("XSRDJJFZ"));
    		BKTBPYXG.setXSYBDYS(result.get("XSYBDYS"));
    		BKTBPYXG.setXSZSDYS(result.get("XSZSDYS"));
    		BKTBPYXG.setXSCJGYHDRS(result.get("XSCJGYHDRS"));
    		BKTBPYXG.setJCXYRS(result.get("JCXYRS"));
    		univMapper.deleteBKTBPYXG(BKTBPYXG);
    		univMapper.insertBKTBPYXG(BKTBPYXG);
    		
    		//BKTBSJJX
    		BKTBSJJX BKTBSJJX = new BKTBSJJX();
    		BKTBSJJX.setBKZYTBLSH(TBLSH);
    		BKTBSJJX.setBYLWBL(result.get("BYLWBL"));
    		BKTBSJJX.setGJJJSZXS(result.get("GJJJSZXS"));
    		BKTBSJJX.setGJJSYSS(result.get("GJJSYSS"));
    		BKTBSJJX.setGJJXNZSS(result.get("GJJXNZSS"));
    		BKTBSJJX.setSJJXJF(result.get("SJJXJF"));
    		BKTBSJJX.setSJJXSXS(result.get("SJJXSXS"));
    		BKTBSJJX.setSJSYSS(result.get("SJSYSS"));
    		BKTBSJJX.setSJXNZSS(result.get("SJXNZSS"));
    		BKTBSJJX.setTBYEAR(TBYEAR);
    		BKTBSJJX.setXNSXJD(result.get("XNSXJD"));
    		BKTBSJJX.setXQLHPYXYS(result.get("XQLHPYXYS"));
    		BKTBSJJX.setXWSXJD(result.get("XWSXJD"));
    		BKTBSJJX.setXXDM(XXDM);
    		BKTBSJJX.setXYDM(XYDM);
    		BKTBSJJX.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBSJJX(BKTBSJJX);
    		univMapper.insertBKTBSJJX(BKTBSJJX);
  
    		//BKTBSYB
    		BKTBSYB BKTBSYB =new BKTBSYB();
    		BKTBSYB.setBKTBLSH(TBLSH);
    		BKTBSYB.setBKZYIDLSH(ZYIDLSH);
    		BKTBSYB.setJHZSRS(result.get("JHZSRS"));
    		BKTBSYB.setSJZSRS(result.get("SJZSRS"));
    		BKTBSYB.setTBYEAR(TBYEAR);
    		BKTBSYB.setXXDM(XXDM);
    		BKTBSYB.setXYDM(XYDM);
    		BKTBSYB.setZSPJF(result.get("ZSPJF"));
    		BKTBSYB.setZSPJWC(result.get("ZSPJWC"));
    		BKTBSYB.setZSZDF(result.get("ZSZDF"));
    		BKTBSYB.setZSZDWC(result.get("ZSZDWC"));
    		BKTBSYB.setZSZGF(result.get("ZSZGF"));
    		BKTBSYB.setZSZGWC(result.get("ZSZGWC"));
    		BKTBSYB.setZSZSRS(result.get("ZSZSRS"));
    		BKTBSYB.setZXSRS(result.get("ZXSRS"));
    		BKTBSYB.setJNZRS(result.get("JNZRS"));
    		BKTBSYB.setGATZRS(result.get("GATZRS"));
    		BKTBSYB.setLXSZRS(result.get("LXSZRS"));
    		BKTBSYB.setSJLQS(result.get("SJLQS"));
    		BKTBSYB.setZZZSRS(result.get("ZZZSRS"));
    		BKTBSYB.setZTCSRS(result.get("ZTCSRS"));
    		univMapper.deleteBKTBSYB(BKTBSYB);
    		univMapper.insertBKTBSYB(BKTBSYB);
    		
    		//BKTBZYXYL
    		BKTBZYXYL BKTBZYXYL =new BKTBZYXYL();
    		BKTBZYXYL.setBKZYTBLSH(TBLSH);
    		BKTBZYXYL.setBKZYIDLSH(ZYIDLSH);
    		BKTBZYXYL.setJSLXSRS(result.get("JSLXSRS"));
    		BKTBZYXYL.setSCLXSRS(result.get("SCLXSRS"));
    		BKTBZYXYL.setTBYEAR(TBYEAR);
    		BKTBZYXYL.setXXDM(XXDM);
    		BKTBZYXYL.setXYDM(XYDM);
    		BKTBZYXYL.setYJSLQRS(result.get("YJSLQRS"));
    		BKTBZYXYL.setZCRS(result.get("ZCRS"));
    		BKTBZYXYL.setZRRS(result.get("ZRRS"));
    		univMapper.deleteBKTBZYXYL(BKTBZYXYL);
    		univMapper.insertBKTBZYXYL(BKTBZYXYL);
    		
    		//BKTBZLBZ
    		BKTBZLBZ BKTBZLBZ = new BKTBZLBZ();
    		BKTBZLBZ.setBKTBIDLSH(TBLSH);
    		BKTBZLBZ.setJXDDBZ(result.get("JXDDBZ"));
    		BKTBZLBZ.setJXJDPJ(result.get("JXJDPJ"));
    		BKTBZLBZ.setTBYEAR(TBYEAR);
    		BKTBZLBZ.setXXDM(XXDM);
    		BKTBZLBZ.setXYDM(XYDM);
    		BKTBZLBZ.setZLBZBZ(result.get("ZLBZBZ"));
    		BKTBZLBZ.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteBKTBZLBZ(BKTBZLBZ);
    		univMapper.insertBKTBZLBZ(BKTBZLBZ);
    
    		
    		
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
    public String TBLSH() {
    	SqlSession sqlSession = null;
    	String tblsh = null;
    	try{
  		sqlSession = SqlSessionFactoryUtil.openSqlSession();
		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
		 tblsh = univMapper.getCsb().getBKTBLSH();
			univMapper.upTbLSH(String.valueOf(Integer.parseInt(tblsh)+1));
				sqlSession.commit();
    	}catch(Exception ex){
    		System.err.println(ex.getMessage());
    		sqlSession.rollback();
    	}finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return tblsh;
	

    }
    
}
    
