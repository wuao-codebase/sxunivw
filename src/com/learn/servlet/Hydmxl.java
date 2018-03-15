package com.learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import com.learn.mapper.UnivMapper;
import com.learn.po.Gzzy;
import com.learn.po.Hydm;
import com.learn.po.Zymc;
import com.learn.util.SqlSessionFactoryUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/Hydmxl")
public class Hydmxl extends HttpServlet {
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
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		
        	String id = request.getParameter("id");
        	String zydm = request.getParameter("zydm");
        	List<Hydm> ds = null;
        	if (id.equals("1")) {
        		 ds = univMapper.getHYDMYIJI();
			}
        	if (id.equals("2")) {
       		 ds = univMapper.getHYDMERJI(zydm);
			}

    		JSONArray strJson=JSONArray.fromObject(ds);
    		
    		 out.print(strJson);

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
    
