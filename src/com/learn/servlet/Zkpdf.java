package com.learn.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
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
import com.learn.util.SqlSessionFactoryUtil;

@WebServlet(name="Zkpdf",urlPatterns={"/Zkpdf"}) 
public class Zkpdf extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    this.doPost(request, response);  
}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	response.setContentType("application/pdf;charset=UTF-8");
	    	request.setCharacterEncoding("UTF-8");   
	    	String XXMC=request.getParameter("XXMC");
	    	String XYMC=request.getParameter("XYMC");
	    	String ZYMC=request.getParameter("ZYMC");
	    	String XXDM=request.getParameter("XXDM");
    		String XYDM=request.getParameter("XYDM");
    		String ZYIDLSH = request.getParameter("ZYDM");
    		Calendar a=Calendar.getInstance();
    		String  TBYEAR = String.valueOf(a.get(Calendar.YEAR));
    		response.setHeader("Content-Type", "application/x-msdownload" );
    		response.setHeader("Content-Disposition", "attachment; filename="+"zhuanke"+XXDM+ZYIDLSH+".pdf");
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    try { 
	    	String fileName = "F:\\SXUNIVAPP\\code\\zktemplate.pdf"; // pdf模板
			PdfReader reader = new PdfReader(fileName);
			/* 将要生成的目标PDF文件名称 */ 
			PdfStamper ps = new PdfStamper(reader, bos);
//			PdfContentByte under = ps.getUnderContent(1);   
			
			
	        
	        /* 取出报表模板中的所有字段 */  
			AcroFields fields = ps.getAcroFields();
			
			fillData(fields, data(XXDM,XYDM,ZYIDLSH,TBYEAR,XXMC,XYMC,ZYMC));
			
	        /* 必须要调用这个，否则文档不会生成的 */  
			ps.setFormFlattening(true);
			ps.close();
			reader.close();
	    	 } catch (DocumentException e) {  
	    	        e.printStackTrace();  
	    	    }  
	    OutputStream sos = response.getOutputStream();  
	    bos.writeTo(sos);  
	    sos.flush();  
	    sos.close();  
	    }

		public static void fillData(AcroFields fields, Map<String, String> data)
				throws IOException, DocumentException {
			  /* 使用中文字体 */  
	        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.EMBEDDED);
			for (String key : data.keySet()) {
				fields.setFieldProperty(key, "textfont", bf, null); 
				String value = data.get(key);
				fields.setField(key, value); // 为字段赋值,注意字段名称是区分大小写的
			}
		}

		public static Map<String, String> data(String XXDM,String XYDM,String ZYIDLSH,String TBYEAR,String XXMC,String XYMC,String ZYMC) {
			
    		HashMap<String, String> data = new HashMap<String, String>();
		SqlSession sqlSession = null;
    	try{  
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		
    		
			//ZKTBCXCY
    		ZKTBCXCY ZKTBCXCY=new ZKTBCXCY();
    		ZKTBCXCY.setTBYEAR(TBYEAR);
    		ZKTBCXCY.setXXDM(XXDM);
    		ZKTBCXCY.setXYDM(XYDM);
    		ZKTBCXCY.setZYIDLSH(ZYIDLSH);
    		HashMap<String, String> ZKTBCXCY1=univMapper.getZKTBCXCYMAP(ZKTBCXCY);
    		for (Map.Entry<String, String> entry : ZKTBCXCY1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBJIAOSHI
    		ZKTBJIAOSHI ZKTBJIAOSHI = new ZKTBJIAOSHI();
    		ZKTBJIAOSHI.setTBYEAR(TBYEAR);
    		ZKTBJIAOSHI.setXXDM(XXDM);
    		ZKTBJIAOSHI.setXYDM(XYDM);
    		ZKTBJIAOSHI.setZKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> ZKTBJIAOSHI1 =univMapper.getZKTBJIAOSHIMAP(ZKTBJIAOSHI);
    		for (Map.Entry<String, String> entry : ZKTBJIAOSHI1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBJIUYE
    		ZKTBJIUYE ZKTBJIUYE =new ZKTBJIUYE();
    		ZKTBJIUYE.setZKZYLSH(ZYIDLSH);
    		ZKTBJIUYE.setTBYEAR(TBYEAR);
    		ZKTBJIUYE.setXXDM(XXDM);
    		ZKTBJIUYE.setXYDM(XYDM);
    		HashMap<String, String> ZKTBJIUYE1=univMapper.getZKTBJIUYEMAP(ZKTBJIUYE);
    		for (Map.Entry<String, String> entry : ZKTBJIUYE1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBJSSZSP
    		ZKTBJSSZSP ZKTBJSSZSP =new ZKTBJSSZSP();
    		ZKTBJSSZSP.setTBYEAR(TBYEAR);
    		ZKTBJSSZSP.setXXDM(XXDM);
    		ZKTBJSSZSP.setXYDM(XYDM);
    		ZKTBJSSZSP.setZKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> ZKTBJSSZSP1=univMapper.getZKTBJSSZSPMAP(ZKTBJSSZSP);
    		for (Map.Entry<String, String> entry : ZKTBJSSZSP1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBJXGG
    		ZKTBJXGG ZKTBJXGG =new ZKTBJXGG();
    		ZKTBJXGG.setTBYEAR(TBYEAR);
    		ZKTBJXGG.setXXDM(XXDM);
    		ZKTBJXGG.setXYDM(XYDM);
    		ZKTBJXGG.setZKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> ZKTBJXGG1=univMapper.getZKTBJXGGMAP(ZKTBJXGG);
    		for (Map.Entry<String, String> entry : ZKTBJXGG1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBJXTJ
    		ZKTBJXTJ ZKTBJXTJ =new ZKTBJXTJ();
    		ZKTBJXTJ.setTBYEAR(TBYEAR);
    		ZKTBJXTJ.setXXDM(XXDM);
    		ZKTBJXTJ.setXYDM(XYDM);
    		ZKTBJXTJ.setZKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> ZKTBJXTJ1=univMapper.getZKTBJXTJMAP(ZKTBJXTJ);
    		for (Map.Entry<String, String> entry : ZKTBJXTJ1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBJYJBXX
    		ZKTBJYJBXX ZKTBJYJBXX =new ZKTBJYJBXX();
    		ZKTBJYJBXX.setZKZYIDLSH(ZYIDLSH);
    		ZKTBJYJBXX.setXXDM(XXDM);
    		ZKTBJYJBXX.setXYDM(XYDM);
    		ZKTBJYJBXX.setTBYEAR(TBYEAR);
    		HashMap<String, String> ZKTBJYJBXX1=univMapper.getZKTBJYJBXXMAP(ZKTBJYJBXX);
    		for (Map.Entry<String, String> entry : ZKTBJYJBXX1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBPYFA
    		ZKTBPYFA ZKTBPYFA = new ZKTBPYFA();
    		ZKTBPYFA.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYFA.setTBYEAR(TBYEAR);
    		ZKTBPYFA.setXXDM(XXDM);
    		ZKTBPYFA.setXYDM(XYDM);
    		HashMap<String, String> ZKTBPYFA1=univMapper.getZKTBPYFAMAP(ZKTBPYFA);
    		for (Map.Entry<String, String> entry : ZKTBPYFA1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBPYXG
    		ZKTBPYXG ZKTBPYXG =new ZKTBPYXG();
    		ZKTBPYXG.setZKZYIDLSH(ZYIDLSH);
    		ZKTBPYXG.setTBYEAR(TBYEAR);
    		ZKTBPYXG.setXXDM(XXDM);
    		ZKTBPYXG.setXYDM(XYDM);
    		HashMap<String, String> ZKTBPYXG1=univMapper.getZKTBPYXGMAP(ZKTBPYXG);
    		for (Map.Entry<String, String> entry : ZKTBPYXG1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBSJJX
    		ZKTBSJJX ZKTBSJJX = new ZKTBSJJX();
    		ZKTBSJJX.setTBYEAR(TBYEAR);
    		ZKTBSJJX.setXXDM(XXDM);
    		ZKTBSJJX.setXYDM(XYDM);
    		ZKTBSJJX.setZKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> ZKTBSJJX1=univMapper.getZKTBSJJXMAP(ZKTBSJJX);
    		for (Map.Entry<String, String> entry : ZKTBSJJX1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBSYB
    		ZKTBSYB ZKTBSYB =new ZKTBSYB();
    		ZKTBSYB.setZKZYIDLSH(ZYIDLSH);
    		ZKTBSYB.setTBYEAR(TBYEAR);
    		ZKTBSYB.setXXDM(XXDM);
    		ZKTBSYB.setXYDM(XYDM);
    		HashMap<String, String> ZKTBSYB1=univMapper.getZKTBSYBMAP(ZKTBSYB);
    		for (Map.Entry<String, String> entry : ZKTBSYB1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBZYXYL
    		ZKTBZYXYL ZKTBZYXYL =new ZKTBZYXYL();
    		ZKTBZYXYL.setZKZYIDLSH(ZYIDLSH);
    		ZKTBZYXYL.setTBYEAR(TBYEAR);
    		ZKTBZYXYL.setXXDM(XXDM);
    		ZKTBZYXYL.setXYDM(XYDM);
    		HashMap<String, String> ZKTBZYXYL1=univMapper.getZKTBZYXYLMAP(ZKTBZYXYL);
    		for (Map.Entry<String, String> entry : ZKTBZYXYL1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//ZKTBZLBZ
    		ZKTBZLBZ ZKTBZLBZ = new ZKTBZLBZ();
    		ZKTBZLBZ.setTBYEAR(TBYEAR);
    		ZKTBZLBZ.setXXDM(XXDM);
    		ZKTBZLBZ.setXYDM(XYDM);
    		ZKTBZLBZ.setZKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> ZKTBZLBZ1=univMapper.getZKTBZLBZMAP(ZKTBZLBZ);
    		for (Map.Entry<String, String> entry : ZKTBZLBZ1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
			sqlSession.commit();
			data.put("XXMC",XXMC);
			data.put("XYMC",XYMC);
			data.put("ZYMC",ZYMC);
			if(data.get("SJZHGGBZ").equals("1")){
				data.put("SJZHGGBZ", "有");
			}else{data.put("SJZHGGBZ", "无");}
			
			if(data.get("GCRZBZ").equals("1")){
				data.put("GCRZBZ", "通过");
			}else{data.put("GCRZBZ", "未通过");}
			if(data.get("SXYLZYBZ").equals("2")){
				data.put("SXYLZYBZ", "有");
			}else{
				if (data.get("SXYLZYBZ").equals("1")) {
					data.put("SXYLZYBZ", "培养");
				} else {
					data.put("SXYLZYBZ", "无");
				}}
			
			if(data.get("GJJJXZYKBZ").equals("1")){
				data.put("GJJJXZYKBZ", "有");
			}else{data.put("GJJJXZYKBZ", "无");}
			if(data.get("SJJXZYKBZ").equals("1")){
				data.put("SJJXZYKBZ", "有");
			}else{data.put("SJJXZYKBZ", "无");}
			
			
			if(data.get("TXSZBZ").equals("1")){
				data.put("TXSZBZ", "是");
			}else{data.put("TXSZBZ", "否");}
			if(data.get("CYKCBZ").equals("1")){
				data.put("CYKCBZ", "是");
			}else{data.put("CYKCBZ", "否");}
			if(data.get("JXDDBZ").equals("1")){
				data.put("JXDDBZ", "是");
			}else{data.put("JXDDBZ", "否");}
			if(data.get("ZLBZBZ").equals("1")){
				data.put("ZLBZBZ", "是");
			}else{data.put("ZLBZBZ", "否");}
			if(data.get("ZLBZBZ").equals("1")){
				data.put("ZLBZBZ", "是");
			}else{data.put("ZLBZBZ", "否");}
			if(data.get("XWSYQ").equals("1")){
				data.put("XWSYQ", "是");
			}else{data.put("XWSYQ", "否");}
			if(data.get("YSZYLX").equals("2")){
				data.put("YSZYLX", "国家特色专业");
			}else{
				if (data.get("YSZYLX").equals("1")) {
					data.put("YSZYLX", "国家综合改革试点专业");
				} else {
					data.put("YSZYLX", "省部级优势专业");
				}}
			
	    	}catch(Exception ex){
	    		System.err.println(ex.getMessage());
	    	}finally {
				if (sqlSession!=null) {
					sqlSession.close();
				}
			}
    	return data;
		}
	}
	