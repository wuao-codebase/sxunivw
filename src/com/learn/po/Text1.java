package com.learn.po;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.learn.mapper.UnivMapper;
import com.learn.util.SqlSessionFactoryUtil;
import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NamedMethodGenerator;
import com.sun.swing.internal.plaf.basic.resources.basic;

import net.sf.json.JSONArray;

public class Text1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
    	SqlSession sqlSession = null;
    	try{
    		
    		sqlSession = SqlSessionFactoryUtil.openSqlSession();
    		UnivMapper univMapper = sqlSession.getMapper(UnivMapper.class);

    		

    	
    	
    	
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
