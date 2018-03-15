package com.learn.po;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.jasper.tagplugins.jstl.core.Set;

import com.learn.mapper.UnivMapper;
import com.learn.util.SqlSessionFactoryUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Aaaa {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
    	SqlSession sqlSession = null;
    	try{
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);
    		Calendar time=Calendar.getInstance();
    		String  TBYEAR = String.valueOf(time.get(Calendar.YEAR));
    		List<Xxm> xxms = univMapper.getAllxxm();
    		JSONArray result = new JSONArray();
    		for(Xxm xxm :xxms){
    			int a=univMapper.getbktemp(xxm.getXxdm());
    			int b=univMapper.getzktemp(xxm.getXxdm());
    			List<XYZYPZB> c = univMapper.getXYZYPZB(xxm.getXxdm());
    			int sucsess =a+b;
    			int sum = c.size();
    			
    			List<XYZYPZB> bkxyzys = univMapper.getbkunreport(xxm.getXxdm(),TBYEAR);
    			List<XYZYPZB> zkxyzys = univMapper.getzkunreport(xxm.getXxdm(),TBYEAR);	
    			int bk =bkxyzys.size();
    			int  zk =zkxyzys.size();
    			int fals =  bk+  zk;
    			JSONObject temp =new JSONObject();
    			temp.put("xxxm", xxm.getXxxm());
    			temp.put("sum", sum);
    			temp.put("sucsess", sucsess);
    			temp.put("fals", fals);
    			if(sucsess>sum){ temp.put("re",sucsess-sum ); }
    			else{temp.put("re",0 );}
    			result.add(temp);
    		}
    		for(int i=0;i<result.size();i++){
    		    JSONObject job = result.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
    		    System.out.println(job.get("xxxm")+":  总:"+job.get("sum")+",  以填报数:"+job.get("sucsess")+",  未填报数:"+job.get("fals")+",  错误数据:"+job.get("re"));
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
