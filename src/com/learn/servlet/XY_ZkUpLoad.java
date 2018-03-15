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

@WebServlet("/XY_ZkUpLoad")
public class XY_ZkUpLoad extends HttpServlet {
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
    		String ZYIDLSH=result.get("ZYDM");
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		
    	

  
    		//ZKTBCXCY
    		ZKTBCXCY ZKTBCXCY=new ZKTBCXCY();
    		ZKTBCXCY.setZKTBLSH(TBLSH);
    		ZKTBCXCY.setCYKCBZ(result.get("CYKCBZ"));
    		ZKTBCXCY.setCYZDJSRS(result.get("CYZDJSRS"));
    		ZKTBCXCY.setGZRS(result.get("GZRS"));
    		ZKTBCXCY.setTBYEAR(TBYEAR);
    		ZKTBCXCY.setTXSZBZ(result.get("TXSZBZ"));
    		ZKTBCXCY.setXXDM(XXDM);
    		ZKTBCXCY.setXYDM(XYDM);
    		ZKTBCXCY.setZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBCXCY(ZKTBCXCY);
    		univMapper.insertZKTBCXCY(ZKTBCXCY);
    		
    		//ZKTBJIAOSHI
    		ZKTBJIAOSHI ZKTBJIAOSHI = new ZKTBJIAOSHI();
    		ZKTBJIAOSHI.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJIAOSHI.setBSJSZS(result.get("BSJSZS"));
    		ZKTBJIAOSHI.setFGJSZS(result.get("FGJSZS"));
    		ZKTBJIAOSHI.setJSZS(result.get("JSZS"));
    		ZKTBJIAOSHI.setMEDIANJSZS(result.get("MEDIANJSZS"));
    		ZKTBJIAOSHI.setSYJSZS(result.get("SYJSZS"));
    		ZKTBJIAOSHI.setTBYEAR(TBYEAR);
    		ZKTBJIAOSHI.setWPJSZS(result.get("WPJSZS"));
    		ZKTBJIAOSHI.setXXDM(XXDM);
    		ZKTBJIAOSHI.setXYDM(XYDM);
    		ZKTBJIAOSHI.setYOUNGJSZS(result.get("YOUNGJSZS"));
    		ZKTBJIAOSHI.setZGJSZS(result.get("ZGJSZS"));
    		ZKTBJIAOSHI.setZKTBIDLSH(TBLSH);
    		univMapper.deleteZKTBJIAOSHI(ZKTBJIAOSHI);
    		univMapper.insertZKTBJIAOSHI(ZKTBJIAOSHI);
    		
    		//ZKTBJIUYE
    		ZKTBJIUYE ZKTBJIUYE =new ZKTBJIUYE();
    		ZKTBJIUYE.setZKTBLSH(TBLSH);
    		ZKTBJIUYE.setZKZYLSH(ZYIDLSH);
    		ZKTBJIUYE.setBYSCCJYL(result.get("BYSCCJYL"));
    		ZKTBJIUYE.setBYSMYD(result.get("BYSMYD"));
    		ZKTBJIUYE.setTBYEAR(TBYEAR);
    		ZKTBJIUYE.setXXDM(XXDM);
    		ZKTBJIUYE.setXYDM(XYDM);
    		ZKTBJIUYE.setZZCYRS(result.get("ZZCYRS"));
    		univMapper.deleteZKTBJIUYE(ZKTBJIUYE);
    		univMapper.insertZKTBJIUYE(ZKTBJIUYE);
    		
    		//ZKTBJSSZSP
    		ZKTBJSSZSP ZKTBJSSZSP =new ZKTBJSSZSP();
    		ZKTBJSSZSP.setZKTBIDLSH(TBLSH);
    		ZKTBJSSZSP.setDNCGFXS(result.get("DNCGFXS"));
    		ZKTBJSSZSP.setDNCSCD(result.get("DNCSCD"));
    		ZKTBJSSZSP.setDNCSSCI(result.get("DNCSSCI"));
    		ZKTBJSSZSP.setDNEI(result.get("DNEI"));
    		ZKTBJSSZSP.setDNGJJXJS(result.get("DNGJJXJS"));
    		ZKTBJSSZSP.setDNGJJXMS(result.get("DNGJJXMS"));
    		ZKTBJSSZSP.setDNGJKJJS(result.get("DNGJKJJS"));
    		ZKTBJSSZSP.setDNHXDK(result.get("DNHXDK"));
    		ZKTBJSSZSP.setDNISTP(result.get("DNISTP"));
    		ZKTBJSSZSP.setDNSCI(result.get("DNSCI"));
    		ZKTBJSSZSP.setDNSJJXJS(result.get("DNSJJXJS"));
    		ZKTBJSSZSP.setDNSJKJJS(result.get("DNSJKJJS"));
    		ZKTBJSSZSP.setDNSKZGJSS(result.get("DNSKZGJSS"));
    		ZKTBJSSZSP.setDNSSCI(result.get("DNSSCI"));
    		ZKTBJSSZSP.setDNZXDK(result.get("DNZXDK"));
    		ZKTBJSSZSP.setGJJJXTDS(result.get("GJJJXTDS"));
    		ZKTBJSSZSP.setGJJKYTDS(result.get("GJJKYTDS"));
    		ZKTBJSSZSP.setGSPJSS(result.get("GSPJSS"));
    		ZKTBJSSZSP.setSJJXTDS(result.get("SJJXTDS"));
    		ZKTBJSSZSP.setSJKYTDS(result.get("SJKYTDS"));
    		ZKTBJSSZSP.setDNSBXMS(result.get("DNSBXMS"));
    		ZKTBJSSZSP.setDNZLS(result.get("DNZLS"));
    		ZKTBJSSZSP.setDNRJZZQS(result.get("DNRJZZQS"));
    		ZKTBJSSZSP.setTBYEAR(TBYEAR);
    		ZKTBJSSZSP.setXXDM(XXDM);
    		ZKTBJSSZSP.setXYDM(XYDM);
    		ZKTBJSSZSP.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBJSSZSP(ZKTBJSSZSP);
    		univMapper.insertZKTBJSSZSP(ZKTBJSSZSP);
    		
    		//ZKTBJXGG
    		ZKTBJXGG ZKTBJXGG =new ZKTBJXGG();
    		ZKTBJXGG.setZKTBIDLSH(TBLSH);
    		ZKTBJXGG.setDNGJJJCS(result.get("DNGJJJCS"));
    		ZKTBJXGG.setDNGJJJPKCS(result.get("DNGJJJPKCS"));
    		ZKTBJXGG.setDNGJJJXCGJ(result.get("DNGJJJXCGJ"));
    		ZKTBJXGG.setDNJGLWS(result.get("DNJGLWS"));
    		ZKTBJXGG.setDNQTJCS(result.get("DNQTJCS"));
    		ZKTBJXGG.setDNSJJJXCGJ(result.get("DNSJJJXCGJ"));
    		ZKTBJXGG.setDNSJJPKCS(result.get("DNSJJPKCS"));
    		ZKTBJXGG.setDNSJJXCGJS(result.get("DNSJJXCGJS"));
    		ZKTBJXGG.setDNSJJXYJS(result.get("DNSJJXYJS"));
    		ZKTBJXGG.setDNSJYXJCS(result.get("DNSJYXJCS"));
    		ZKTBJXGG.setSJRCPYSYCS(result.get("SJRCPYSYCS"));
    		ZKTBJXGG.setGJJJXZYKBZ(result.get("GJJJXZYKBZ"));
    		ZKTBJXGG.setSJJXZYKBZ(result.get("SJJXZYKBZ"));
    		ZKTBJXGG.setTBYEAR(TBYEAR);
    		ZKTBJXGG.setXXDM(XXDM);
    		ZKTBJXGG.setXYDM(XYDM);
    		ZKTBJXGG.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBJXGG(ZKTBJXGG);
    		univMapper.insertZKTBJXGG(ZKTBJXGG);
    		
    		//ZKTBJXTJ
    		ZKTBJXTJ ZKTBJXTJ =new ZKTBJXTJ();
    		ZKTBJXTJ.setZKZYTBLSH(TBLSH);
    		ZKTBJXTJ.setDNJXJF(result.get("DNJXJF"));
    		ZKTBJXTJ.setDNRJF(result.get("DNRJF"));
    		ZKTBJXTJ.setDNSBF(result.get("DNSBF"));
    		ZKTBJXTJ.setTBYEAR(TBYEAR);
    		ZKTBJXTJ.setXXDM(XXDM);
    		ZKTBJXTJ.setXYDM(XYDM);
    		ZKTBJXTJ.setZRJF(result.get("ZRJF"));
    		ZKTBJXTJ.setZSBF(result.get("ZSBF"));
    		ZKTBJXTJ.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJXTJ.setZYTUSHU(result.get("ZYTUSHU"));
    		univMapper.deleteZKTBJXTJ(ZKTBJXTJ);
    		univMapper.insertZKTBJXTJ(ZKTBJXTJ);
    		
    		//ZKTBJYJBXX
    		ZKTBJYJBXX ZKTBJYJBXX =new ZKTBJYJBXX();
    		ZKTBJYJBXX.setZKTBLSH(TBLSH);
    		ZKTBJYJBXX.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJYJBXX.setSJZHGGBZ(result.get("SJZHGGBZ"));
    		ZKTBJYJBXX.setGCRZBZ(result.get("GCRZBZ"));
    		ZKTBJYJBXX.setCXFAXMS(result.get("CXFAXMS"));
    		ZKTBJYJBXX.setSXYLZYBZ(result.get("SXYLZYBZ"));
    		ZKTBJYJBXX.setXXDM(XXDM);
    		ZKTBJYJBXX.setXYDM(XYDM);
    		ZKTBJYJBXX.setZYBXRQ(result.get("ZYBXRQ"));
    		ZKTBJYJBXX.setTBYEAR(TBYEAR);
    		ZKTBJYJBXX.setYSZYLX(result.get("YSZYLX"));
    		ZKTBJYJBXX.setXWSYQ(result.get("XWSYQ"));
    		univMapper.deleteZKTBJYJBXX(ZKTBJYJBXX);
    		univMapper.insertZKTBJYJBXX(ZKTBJYJBXX);
    		
    		//ZKTBPYFA
    		ZKTBPYFA ZKTBPYFA = new ZKTBPYFA();
    		ZKTBPYFA.setZKTBIDLSH(TBLSH);
    		ZKTBPYFA.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYFA.setBYXFZS(result.get("BYXFZS"));
    		ZKTBPYFA.setLLXFZS(result.get("LLXFZS"));
    		ZKTBPYFA.setPYFAURL("PYFA"+XXDM+XYDM+ZYIDLSH+".rar");
    		ZKTBPYFA.setTBYEAR(TBYEAR);
    		ZKTBPYFA.setXXDM(XXDM);
    		ZKTBPYFA.setXXKXFZS(result.get("XXKXFZS"));
    		ZKTBPYFA.setXYDM(XYDM);
    		ZKTBPYFA.setSJKXFZS(result.get("SJKXFZS"));
    		ZKTBPYFA.setCXXFZS(result.get("CXXFZS"));
    		ZKTBPYFA.setPYFAXDNF(result.get("PYFAXDNF"));
    		univMapper.deleteZKTBPYFA(ZKTBPYFA);
    		univMapper.insertZKTBPYFA(ZKTBPYFA);
    		
    		
    		//ZKTBPYXG
    		ZKTBPYXG ZKTBPYXG =new ZKTBPYXG();
    		ZKTBPYXG.setZKTBLSH(TBLSH);
    		ZKTBPYXG.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYXG.setGJDCS(result.get("GJDCS"));
    		ZKTBPYXG.setJXJS(result.get("JXJS"));
    		ZKTBPYXG.setYINGYUA(result.get("YINGYUA"));
    		ZKTBPYXG.setLWS(result.get("LWS"));
    		ZKTBPYXG.setSJDCS(result.get("SJDCS"));
    		ZKTBPYXG.setSJJLS(result.get("SJJLS"));
    		ZKTBPYXG.setYINGYUB(result.get("YINGYUB"));
    		ZKTBPYXG.setSNGJHLWDJS(result.get("SNGJHLWDJS"));
    		ZKTBPYXG.setSNSXHLWDJS(result.get("SNSXHLWDJS"));
    		ZKTBPYXG.setTBYEAR(TBYEAR);
    		ZKTBPYXG.setXXDM(XXDM);
    		ZKTBPYXG.setXYDM(XYDM);
    		ZKTBPYXG.setZLS(result.get("ZLS"));
    		ZKTBPYXG.setZYZSHQL(result.get("ZYZSHQL"));
    		ZKTBPYXG.setGJJNJSCJRS(result.get("GJJNJSCJRS"));
    		ZKTBPYXG.setSXJNJSCJRS(result.get("SXJNJSCJRS"));
    		ZKTBPYXG.setGJJNJSDJS(result.get("GJJNJSDJS"));
    		ZKTBPYXG.setSXXKJSDJS(result.get("SXXKJSDJS"));
    		ZKTBPYXG.setXJXSGBRS(result.get("XJXSGBRS"));
    		ZKTBPYXG.setSJXKJSCJRS(result.get("SJXKJSCJRS"));
    		ZKTBPYXG.setSJXKJSHJRS(result.get("SJXKJSHJRS"));
    		ZKTBPYXG.setWTJSHJRS(result.get("WTJSHJRS"));
    		ZKTBPYXG.setGJHYRS(result.get("GJHYRS"));
    		ZKTBPYXG.setXSRDJJFZ(result.get("XSRDJJFZ"));
    		ZKTBPYXG.setXSYBDYS(result.get("XSYBDYS"));
    		ZKTBPYXG.setXSZSDYS(result.get("XSZSDYS"));
    		ZKTBPYXG.setXSCJGYHDRS(result.get("XSCJGYHDRS"));
    		ZKTBPYXG.setJCXYRS(result.get("JCXYRS"));
    		univMapper.deleteZKTBPYXG(ZKTBPYXG);
    		univMapper.insertZKTBPYXG(ZKTBPYXG);
    		
    		//ZKTBSJJX
    		ZKTBSJJX ZKTBSJJX = new ZKTBSJJX();
    		ZKTBSJJX.setZKZYTBLSH(TBLSH);
    		ZKTBSJJX.setBYLWBL(result.get("BYLWBL"));
    		ZKTBSJJX.setDNDDBXSS(result.get("DNDDBXSS"));
    		ZKTBSJJX.setGJJSYSS(result.get("GJJSYSS"));
    		ZKTBSJJX.setGJJXNZSS(result.get("GJJXNZSS"));
    		ZKTBSJJX.setSJJXJF(result.get("SJJXJF"));
    		ZKTBSJJX.setDNXDXTS(result.get("DNXDXTS"));
    		ZKTBSJJX.setSJSYSS(result.get("SJSYSS"));
    		ZKTBSJJX.setSJXNZSS(result.get("SJXNZSS"));
    		ZKTBSJJX.setTBYEAR(TBYEAR);
    		ZKTBSJJX.setXNSXJD(result.get("XNSXJD"));
    		ZKTBSJJX.setXQLHPYXYS(result.get("XQLHPYXYS"));
    		ZKTBSJJX.setXWSXJD(result.get("XWSXJD"));
    		ZKTBSJJX.setGJJSCSXJDS(result.get("GJJSCSXJDS"));
    		ZKTBSJJX.setSJSCSXJDS(result.get("SJSCSXJDS"));
    		ZKTBSJJX.setXXDM(XXDM);
    		ZKTBSJJX.setXYDM(XYDM);
    		ZKTBSJJX.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBSJJX(ZKTBSJJX);
    		univMapper.insertZKTBSJJX(ZKTBSJJX);
  
    		//ZKTBSYB
    		ZKTBSYB ZKTBSYB =new ZKTBSYB();
    		ZKTBSYB.setZKTBLSH(TBLSH);
    		ZKTBSYB.setZKZYIDLSH(ZYIDLSH);
    		ZKTBSYB.setJHZSRS(result.get("JHZSRS"));
    		ZKTBSYB.setSJZSRS(result.get("SJZSRS"));
    		ZKTBSYB.setTBYEAR(TBYEAR);
    		ZKTBSYB.setXXDM(XXDM);
    		ZKTBSYB.setXYDM(XYDM);
    		ZKTBSYB.setZSPJF(result.get("ZSPJF"));
    		ZKTBSYB.setZSPJWC(result.get("ZSPJWC"));
    		ZKTBSYB.setZSZDF(result.get("ZSZDF"));
    		ZKTBSYB.setZSZDWC(result.get("ZSZDWC"));
    		ZKTBSYB.setZSZGF(result.get("ZSZGF"));
    		ZKTBSYB.setZSZGWC(result.get("ZSZGWC"));
    		ZKTBSYB.setZSZSRS(result.get("ZSZSRS"));
    		ZKTBSYB.setZXSRS(result.get("ZXSRS"));
    		ZKTBSYB.setJNZRS(result.get("JNZRS"));
    		ZKTBSYB.setGATZRS(result.get("GATZRS"));
    		ZKTBSYB.setLXSZRS(result.get("LXSZRS"));
    		ZKTBSYB.setSJLQS(result.get("SJLQS"));
    		ZKTBSYB.setZZZSRS(result.get("ZZZSRS"));
    		ZKTBSYB.setZTCSRS(result.get("ZTCSRS"));
    		univMapper.deleteZKTBSYB(ZKTBSYB);
    		univMapper.insertZKTBSYB(ZKTBSYB);
    		
    		//ZKTBZYXYL
    		ZKTBZYXYL ZKTBZYXYL =new ZKTBZYXYL();
    		ZKTBZYXYL.setZKZYTBLSH(TBLSH);
    		ZKTBZYXYL.setZKZYIDLSH(ZYIDLSH);
    		ZKTBZYXYL.setJSLXSRS(result.get("JSLXSRS"));
    		ZKTBZYXYL.setSCLXSRS(result.get("SCLXSRS"));
    		ZKTBZYXYL.setTBYEAR(TBYEAR);
    		ZKTBZYXYL.setXXDM(XXDM);
    		ZKTBZYXYL.setXYDM(XYDM);
    		ZKTBZYXYL.setYJSLQRS(result.get("YJSLQRS"));
    		ZKTBZYXYL.setZCRS(result.get("ZCRS"));
    		ZKTBZYXYL.setZRRS(result.get("ZRRS"));
    		univMapper.deleteZKTBZYXYL(ZKTBZYXYL);
    		univMapper.insertZKTBZYXYL(ZKTBZYXYL);
    		
    		//ZKTBZLBZ
    		ZKTBZLBZ ZKTBZLBZ = new ZKTBZLBZ();
    		ZKTBZLBZ.setZKTBIDLSH(TBLSH);
    		ZKTBZLBZ.setJXDDBZ(result.get("JXDDBZ"));
    		ZKTBZLBZ.setJXJDPJ(result.get("JXJDPJ"));
    		ZKTBZLBZ.setTBYEAR(TBYEAR);
    		ZKTBZLBZ.setXXDM(XXDM);
    		ZKTBZLBZ.setXYDM(XYDM);
    		ZKTBZLBZ.setZLBZBZ(result.get("ZLBZBZ"));
    		ZKTBZLBZ.setZKZYIDLSH(ZYIDLSH);
    		univMapper.deleteZKTBZLBZ(ZKTBZLBZ);
    		univMapper.insertZKTBZLBZ(ZKTBZLBZ);
    
    		
    		
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
		 tblsh = univMapper.getCsb().getZKTBLSH();
			univMapper.upZKTbLSH(String.valueOf(Integer.parseInt(tblsh)+1));
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
    
