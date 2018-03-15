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
import com.learn.util.SqlSessionFactoryUtil;

@WebServlet(name="Bkpdf",urlPatterns={"/Bkpdf"}) 
public class Bkpdf extends HttpServlet {
private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    this.doPost(request, response);  
}  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    		response.setHeader("Content-Disposition", "attachment; filename="+"benke"+XXDM+ZYIDLSH+".pdf");
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    try { 
	    	String fileName = "F:\\SXUNIVAPP\\code\\bktemplate.pdf"; // pdf模板
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
				String value = data.get(key);
				fields.setFieldProperty(key, "textfont", bf, null); 
				fields.setField(key, value); // 为字段赋值,注意字段名称是区分大小写的
			}
		}

		public static Map<String, String> data(String XXDM,String XYDM,String ZYIDLSH,String TBYEAR,String XXMC,String XYMC,String ZYMC) {
			
    		HashMap<String, String> data = new HashMap<String, String>();
		SqlSession sqlSession = null;
    	try{  
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		//BKTBCXCY
    		BKTBCXCY BKTBCXCY=new BKTBCXCY();
    		BKTBCXCY.setTBYEAR(TBYEAR);
    		BKTBCXCY.setXXDM(XXDM);
    		BKTBCXCY.setXYDM(XYDM);
    		BKTBCXCY.setZYIDLSH(ZYIDLSH);
    		HashMap<String, String> BKTBCXCY1=univMapper.getBKTBCXCYMAP(BKTBCXCY);
			for (Map.Entry<String, String> entry : BKTBCXCY1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBJIAOSHI
    		BKTBJIAOSHI BKTBJIAOSHI = new BKTBJIAOSHI();
    		BKTBJIAOSHI.setTBYEAR(TBYEAR);
    		BKTBJIAOSHI.setXXDM(XXDM);
    		BKTBJIAOSHI.setXYDM(XYDM);
    		BKTBJIAOSHI.setBKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> BKTBJIAOSHI1 =univMapper.getBKTBJIAOSHIMAP(BKTBJIAOSHI);
    		for (Map.Entry<String, String> entry : BKTBJIAOSHI1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBJIUYE
    		BKTBJIUYE BKTBJIUYE =new BKTBJIUYE();
    		BKTBJIUYE.setBKZYLSH(ZYIDLSH);
    		BKTBJIUYE.setTBYEAR(TBYEAR);
    		BKTBJIUYE.setXXDM(XXDM);
    		BKTBJIUYE.setXYDM(XYDM);
    		HashMap<String, String> BKTBJIUYE1=univMapper.getBKTBJIUYEMAP(BKTBJIUYE);
    		for (Map.Entry<String, String> entry : BKTBJIUYE1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
   		
    		//BKTBJSSZSP
    		BKTBJSSZSP BKTBJSSZSP =new BKTBJSSZSP();
    		BKTBJSSZSP.setTBYEAR(TBYEAR);
    		BKTBJSSZSP.setXXDM(XXDM);
    		BKTBJSSZSP.setXYDM(XYDM);
    		BKTBJSSZSP.setZYIDLSH(ZYIDLSH);
    		HashMap<String, String> BKTBJSSZSP1=univMapper.getBKTBJSSZSPMAP(BKTBJSSZSP);
    		for (Map.Entry<String, String> entry : BKTBJSSZSP1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBJXGG
    		BKTBJXGG BKTBJXGG =new BKTBJXGG();
    		BKTBJXGG.setTBYEAR(TBYEAR);
    		BKTBJXGG.setXXDM(XXDM);
    		BKTBJXGG.setXYDM(XYDM);
    		BKTBJXGG.setZYIDLSH(ZYIDLSH);
    		HashMap<String, String> BKTBJXGG1=univMapper.getBKTBJXGGMAP(BKTBJXGG);
    		for (Map.Entry<String, String> entry : BKTBJXGG1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBJXTJ
    		BKTBJXTJ BKTBJXTJ =new BKTBJXTJ();
    		BKTBJXTJ.setTBYEAR(TBYEAR);
    		BKTBJXTJ.setXXDM(XXDM);
    		BKTBJXTJ.setXYDM(XYDM);
    		BKTBJXTJ.setBKZYIDLSH(ZYIDLSH);
    		HashMap<String, String> BKTBJXTJ1=univMapper.getBKTBJXTJMAP(BKTBJXTJ);
    		for (Map.Entry<String, String> entry : BKTBJXTJ1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBJYJBXX
    		BKTBJYJBXX BKTBJYJBXX =new BKTBJYJBXX();
    		BKTBJYJBXX.setBKZYIDLSH(ZYIDLSH);
    		BKTBJYJBXX.setXXDM(XXDM);
    		BKTBJYJBXX.setXYDM(XYDM);
    		BKTBJYJBXX.setTBYEAR(TBYEAR);
    		HashMap<String, String> BKTBJYJBXX1=univMapper.getBKTBJYJBXXMAP(BKTBJYJBXX);
    		for (Map.Entry<String, String> entry : BKTBJYJBXX1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBPYFA
    		BKTBPYFA BKTBPYFA = new BKTBPYFA();
    		BKTBPYFA.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYFA.setTBYEAR(TBYEAR);
    		BKTBPYFA.setXXDM(XXDM);
    		BKTBPYFA.setXYDM(XYDM);
    		HashMap<String, String> BKTBPYFA1=univMapper.getBKTBPYFAMAP(BKTBPYFA);
    		for (Map.Entry<String, String> entry : BKTBPYFA1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		
    		//BKTBPYXG
    		BKTBPYXG BKTBPYXG =new BKTBPYXG();
    		BKTBPYXG.setBKZYIDLSH(ZYIDLSH);
    		BKTBPYXG.setTBYEAR(TBYEAR);
    		BKTBPYXG.setXXDM(XXDM);
    		BKTBPYXG.setXYDM(XYDM);
    		HashMap<String, String> BKTBPYXG1=univMapper.getBKTBPYXGMAP(BKTBPYXG);
    		for (Map.Entry<String, String> entry : BKTBPYXG1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBSJJX
    		BKTBSJJX BKTBSJJX = new BKTBSJJX();
    		BKTBSJJX.setTBYEAR(TBYEAR);
    		BKTBSJJX.setXXDM(XXDM);
    		BKTBSJJX.setXYDM(XYDM);
    		BKTBSJJX.setZYIDLSH(ZYIDLSH);
    		HashMap<String, String> BKTBSJJX1=univMapper.getBKTBSJJXMAP(BKTBSJJX);
    		for (Map.Entry<String, String> entry : BKTBSJJX1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBSYB
    		BKTBSYB BKTBSYB =new BKTBSYB();
    		BKTBSYB.setBKZYIDLSH(ZYIDLSH);
    		BKTBSYB.setTBYEAR(TBYEAR);
    		BKTBSYB.setXXDM(XXDM);
    		BKTBSYB.setXYDM(XYDM);
    		HashMap<String, String> BKTBSYB1=univMapper.getBKTBSYBMAP(BKTBSYB);
    		for (Map.Entry<String, String> entry : BKTBSYB1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBZYXYL
    		BKTBZYXYL BKTBZYXYL =new BKTBZYXYL();
    		BKTBZYXYL.setBKZYIDLSH(ZYIDLSH);
    		BKTBZYXYL.setTBYEAR(TBYEAR);
    		BKTBZYXYL.setXXDM(XXDM);
    		BKTBZYXYL.setXYDM(XYDM);
    		HashMap<String, String> BKTBZYXYL1=univMapper.getBKTBZYXYLMAP(BKTBZYXYL);
    		for (Map.Entry<String, String> entry : BKTBZYXYL1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
    		
    		//BKTBZLBZ
    		BKTBZLBZ BKTBZLBZ = new BKTBZLBZ();
    		BKTBZLBZ.setTBYEAR(TBYEAR);
    		BKTBZLBZ.setXXDM(XXDM);
    		BKTBZLBZ.setXYDM(XYDM);
    		BKTBZLBZ.setZYIDLSH(ZYIDLSH);
    		HashMap<String, String> BKTBZLBZ1=univMapper.getBKTBZLBZMAP(BKTBZLBZ);
    		for (Map.Entry<String, String> entry : BKTBZLBZ1.entrySet()) {
				data.put(entry.getKey() , String.valueOf(entry.getValue()));
			}
			sqlSession.commit();
			data.put("XXMC",XXMC);
			data.put("XYMC",XYMC);
			data.put("ZYMC",ZYMC);
			if(data.get("SSDBZ").equals("1")){
				data.put("SSDBZ", "有");
			}else{data.put("SSDBZ", "无");}
			if(data.get("BSDBZ").equals("1")){
				data.put("BSDBZ", "有");
			}else{data.put("BSDBZ", "无");}
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
			if(data.get("XWSYQ").equals("1")){
				data.put("XWSYQ", "是");
			}else{data.put("XWSYQ", "否");}
			if(data.get("YSZYLX").equals("3")){
				data.put("YSZYLX", "国家特色专业");
			}else{
				if (data.get("YSZYLX").equals("2")) {
					data.put("YSZYLX", "国家综合改革试点专业");
				} else {
					if(data.get("YSZYLX").equals("1")) {
					data.put("YSZYLX", "省部级优势专业");
				  } else{
					  data.put("YSZYLX", "无");
					}
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
	