package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.learn.mapper.UnivMapper;
import com.learn.po.Bkzy;
import com.learn.po.Czy;
import com.learn.po.Gzzy;
import com.learn.po.XYZYPZB;
import com.learn.po.Xxm;
import com.learn.po.Zypz;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;

@WebServlet("/Xyczygl")
public class xy_czy_gl extends HttpServlet {
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
    		HttpSession session = request.getSession(false);
    		Czy use = (Czy)session.getAttribute("user");
    		String id = request.getParameter("id");
    		String czyxm = request.getParameter("lxr");
    		String czylxdh = request.getParameter("lxdh");
    		String czyzghs = request.getParameter("czyzghs");
    		String zyidxlsh = request.getParameter("zyidxlsh");
    		String czylba = request.getParameter("czylb");
    		String czyzgh = request.getParameter("czyzgh");
    		String zylb = request.getParameter("zylb");
    		
		
    		if(id == null || id == ""){
        		List<String> czylb = new ArrayList<String>();
        		czylb.add("1");
        		czylb.add("2");      		
        		String xydm = use.getXydm();
        		HashMap<String,Object> param = new HashMap<String,Object>();
        		param.put("list",czylb);
        		param.put("xydm",xydm);
        		 List<Czy> xxms = univMapper.getXYCzys(param);
        		for(Czy czy: xxms)
        		{		
        			if (czy.getCzylb().equals("1")) {

            			czy.setCzyzl("专业管理员");
            			Zypz xyzy = univMapper.getZYpzxx(czy.getCzyzgh());
                    	if (xyzy.getZylb().equals("1")) {
                    			Bkzy zymc = univMapper.getZyidlshb(xyzy.getZydilsh());
                    			czy.setZymc(zymc.getYijimc()+"-"+zymc.getErjdmmc()+"-"+zymc.getSanjmc());
        				}
                    	if (xyzy.getZylb().equals("2")) {
                    		Gzzy zymc = univMapper.getZyidlsh(xyzy.getZydilsh());
                    		czy.setZymc(zymc.getYijmc()+"-"+zymc.getErjmc()+"-"+zymc.getSanjmc());
                    	}
    				}
        			if(czy.getCzylb().equals("2")){
            			czy.setCzyzl("学院管理员");
        			}
        		}
        		
        		JSONArray jsonArray = JSONArray.fromObject(xxms);
    			out.print(jsonArray.toString());
    			 out.flush();  
    	            out.close();
    		}
    		if(id.equals("1")){

    			Czy cry = new Czy();
    			cry.setCzykl("12345678");
    			cry.setCzylb("1");
    			cry.setCzyxm(czyxm);
    			String czyxlh = univMapper.getCsb().getCzyxlh();		
    			univMapper.upCzyxlh(String.valueOf(Integer.parseInt(univMapper.getCsb().getCzyxlh())+1));
    			cry.setCzyzgh(use.getXxdm()+czyxlh);
    			cry.setXxdm(use.getXxdm());
    			cry.setLxdh(czylxdh);
    			cry.setXydm(use.getXydm());
    			univMapper.insertCzyxy(cry);
    			
    			Zypz zypz =new Zypz();
    			zypz.setCzydm(use.getXxdm()+czyxlh);
    			zypz.setCzylb("1");
    			zypz.setXxdm(use.getXxdm());
    			zypz.setXydm(use.getXydm());
    			zypz.setZydilsh(zyidxlsh);
    			zypz.setZylb(zylb);
    			univMapper.insertZYpz(zypz);
    			
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
    		}
    		if(id.equals("2")){

    			Czy cry = new Czy();
    			cry.setCzykl("12345678");
    			cry.setCzylb("2");
    			cry.setCzyxm(czyxm);
    			String czyxlh = univMapper.getCsb().getCzyxlh();		
    			univMapper.upCzyxlh(String.valueOf(Integer.parseInt(univMapper.getCsb().getCzyxlh())+1));
    			cry.setCzyzgh(use.getXxdm()+czyxlh);
    			cry.setXxdm(use.getXxdm());
    			cry.setLxdh(czylxdh);
    			cry.setXydm(use.getXydm());
    			univMapper.insertCzyxy(cry);
    			JSONArray jsonArray = JSONArray.fromObject("[]");
	       		 out.print(jsonArray.toString());
	   			 out.flush();  
	   	         out.close();
    		}
    		
    		if(id.equals("3")){       	
        		if (czylba.equals("1")) {
        			univMapper.deleteZYpz(czyzgh);
        			univMapper.deleteCzy(czyzgh);
				}
        		if (czylba.equals("2")) {
        			univMapper.deleteCzy(czyzgh);
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
