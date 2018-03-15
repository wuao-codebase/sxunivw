package com.learn.mapper;


import java.util.HashMap;
import java.util.List;
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
import com.learn.po.Bkzy;
import com.learn.po.Csb;
import com.learn.po.Czy;
import com.learn.po.Gzzy;
import com.learn.po.Hydm;
import com.learn.po.XYXXB;
import com.learn.po.XYZYPZB;
import com.learn.po.Xxm;
import com.learn.po.Xyxx;
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
import com.learn.po.Zymc;
import com.learn.po.Zypz;
import com.sun.javafx.collections.MappingChange.Map;




public interface UnivMapper {
	//校友
	public List<Hydm> getHYDMYIJI()throws Exception;
	public List<Hydm> getHYDMERJI(String HYYIJIDM)throws Exception;
	public List<XYXXB> getXYXXB(XYXXB XYXXB)throws Exception;
	public int insertXYXXB(XYXXB XYXXB)throws Exception;
	public int deleteXYXXB(XYXXB XYXXB)throws Exception;
	public int upXYXXB(XYXXB XYXXB)throws Exception;
	public int upXyid(String XYID)throws Exception;
	

	//临时
	public int getbktemp(String xxdm)throws Exception;
	public int getzktemp(String xxdm)throws Exception;
	
	//未填报专业查询
	public List<XYZYPZB> getbkunreport(String XXDM,String TBYEAR)throws Exception;
	public List<XYZYPZB> getzkunreport(String XXDM,String TBYEAR)throws Exception;

	//本科专业信息填报
	public int insertBKTBJYJBXX(BKTBJYJBXX BKTBJYJBXX)throws Exception;
	public int deleteBKTBJYJBXX(BKTBJYJBXX BKTBJYJBXX)throws Exception;
	public int deleteBKTBJYJBXXO(BKTBJYJBXX BKTBJYJBXX)throws Exception;
	public BKTBJYJBXX getBKTBJYJBXX(BKTBJYJBXX BKTBJYJBXX)throws Exception;
	public HashMap<String, String> getBKTBJYJBXXMAP(BKTBJYJBXX BKTBJYJBXX)throws Exception;
	public int deleteXYBKTBJYJBXX(String xydm)throws Exception;
	public int upBKTBJYJBXX(BKTBJYJBXX BKTBJYJBXX)throws Exception;
	
	public int insertBKTBSYB(BKTBSYB BKTBSYB)throws Exception;
	public int deleteBKTBSYB(BKTBSYB BKTBSYB)throws Exception;
	public int deleteBKTBSYBO(BKTBSYB BKTBSYB)throws Exception;
	public BKTBSYB getBKTBSYB(BKTBSYB BKTBSYB)throws Exception;
	public HashMap<String, String> getBKTBSYBMAP(BKTBSYB BKTBSYB)throws Exception;
	public int deleteXYBKTBSYB(String xydm)throws Exception;
	public int upBKTBSYB(BKTBSYB BKTBSYB)throws Exception;
	
	public int insertBKTBPYXG(BKTBPYXG BKTBPYXG)throws Exception;
	public int deleteBKTBPYXG(BKTBPYXG BKTBPYXG)throws Exception;
	public int deleteBKTBPYXGO(BKTBPYXG BKTBPYXG)throws Exception;
	public BKTBPYXG getBKTBPYXG(BKTBPYXG BKTBPYXG)throws Exception;
	public HashMap<String, String> getBKTBPYXGMAP(BKTBPYXG BKTBPYXG)throws Exception;
	public int deleteXYBKTBPYXG(String xydm)throws Exception;
	public int upBKTBPYXG(BKTBPYXG BKTBPYXG)throws Exception;
	
	public int insertBKTBJIUYE(BKTBJIUYE BKTBJIUYE)throws Exception;
	public int deleteBKTBJIUYE(BKTBJIUYE BKTBJIUYE)throws Exception;
	public int deleteBKTBJIUYEO(BKTBJIUYE BKTBJIUYE)throws Exception;
	public BKTBJIUYE getBKTBJIUYE(BKTBJIUYE BKTBJIUYE)throws Exception;
	public HashMap<String, String> getBKTBJIUYEMAP(BKTBJIUYE BKTBJIUYE)throws Exception;
	public int deleteXYBKTBJIUYE(String xydm)throws Exception;
	
	public int insertBKTBZYXYL(BKTBZYXYL BKTBZYXYL)throws Exception;
	public int deleteBKTBZYXYL(BKTBZYXYL BKTBZYXYL)throws Exception;
	public int deleteBKTBZYXYLO(BKTBZYXYL BKTBZYXYL)throws Exception;
	public BKTBZYXYL getBKTBZYXYL(BKTBZYXYL BKTBZYXYL)throws Exception;
	public HashMap<String, String> getBKTBZYXYLMAP(BKTBZYXYL BKTBZYXYL)throws Exception;
	public int deleteXYBKTBZYXYL(String xydm)throws Exception;
	
	public int insertBKTBPYFA(BKTBPYFA BKTBPYFA)throws Exception;
	public int deleteBKTBPYFA(BKTBPYFA BKTBPYFA)throws Exception;
	public int deleteBKTBPYFAO(BKTBPYFA BKTBPYFA)throws Exception;
	public BKTBPYFA getBKTBPYFA(BKTBPYFA BKTBPYFA)throws Exception;
	public HashMap<String, String> getBKTBPYFAMAP(BKTBPYFA BKTBPYFA)throws Exception;
	public int deleteXYBKTBPYFA(String xydm)throws Exception;
	public int upBKTBPYFA(BKTBPYFA BKTBPYFA)throws Exception;
	
	public int insertBKTBJIAOSHI(BKTBJIAOSHI BKTBJIAOSHI)throws Exception;
	public int deleteBKTBJIAOSHI(BKTBJIAOSHI BKTBJIAOSHI)throws Exception;
	public int deleteBKTBJIAOSHIO(BKTBJIAOSHI BKTBJIAOSHI)throws Exception;
	public BKTBJIAOSHI getBKTBJIAOSHI(BKTBJIAOSHI BKTBJIAOSHI)throws Exception;
	public HashMap<String, String> getBKTBJIAOSHIMAP(BKTBJIAOSHI BKTBJIAOSHI)throws Exception;
	public int deleteXYBKTBJIAOSHI(String xydm)throws Exception;
	
	public int insertBKTBJXTJ(BKTBJXTJ BKTBJXTJ)throws Exception;
	public int deleteBKTBJXTJ(BKTBJXTJ BKTBJXTJ)throws Exception;
	public int deleteBKTBJXTJO(BKTBJXTJ BKTBJXTJ)throws Exception;
	public BKTBJXTJ getBKTBJXTJ(BKTBJXTJ BKTBJXTJ)throws Exception;
	public HashMap<String, String> getBKTBJXTJMAP(BKTBJXTJ BKTBJXTJ)throws Exception;
	public int deleteXYBKTBJXTJ(String xydm)throws Exception;
	
	public int insertBKTBSJJX(BKTBSJJX BKTBSJJX)throws Exception;
	public int deleteBKTBSJJX(BKTBSJJX BKTBSJJX)throws Exception;
	public int deleteBKTBSJJXO(BKTBSJJX BKTBSJJX)throws Exception;
	public BKTBSJJX getBKTBSJJX(BKTBSJJX BKTBSJJX)throws Exception;
	public HashMap<String, String> getBKTBSJJXMAP(BKTBSJJX BKTBSJJX)throws Exception;
	public int deleteXYBKTBSJJX(String xydm)throws Exception;
	
	public int insertBKTBCXCY(BKTBCXCY BKTBCXCY)throws Exception;
	public int deleteBKTBCXCY(BKTBCXCY BKTBCXCY)throws Exception;
	public int deleteBKTBCXCYO(BKTBCXCY BKTBCXCY)throws Exception;
	public BKTBCXCY getBKTBCXCY(BKTBCXCY BKTBCXCY)throws Exception;
	public HashMap<String, String> getBKTBCXCYMAP(BKTBCXCY BKTBCXCY)throws Exception;
	public int deleteXYBKTBCXCY(String xydm)throws Exception;
	
	public int insertBKTBJXGG(BKTBJXGG BKTBJXGG)throws Exception;
	public int deleteBKTBJXGG(BKTBJXGG BKTBJXGG)throws Exception;
	public int deleteBKTBJXGGO(BKTBJXGG BKTBJXGG)throws Exception;
	public BKTBJXGG getBKTBJXGG(BKTBJXGG BKTBJXGG)throws Exception;
	public HashMap<String, String> getBKTBJXGGMAP(BKTBJXGG BKTBJXGG)throws Exception;
	public int deleteXYBKTBJXGG(String xydm)throws Exception;
	
	public int insertBKTBJSSZSP(BKTBJSSZSP BKTBJSSZSP)throws Exception;
	public int deleteBKTBJSSZSP(BKTBJSSZSP BKTBJSSZSP)throws Exception;
	public int deleteBKTBJSSZSPO(BKTBJSSZSP BKTBJSSZSP)throws Exception;
	public BKTBJSSZSP getBKTBJSSZSP(BKTBJSSZSP BKTBJSSZSP)throws Exception;
	public HashMap<String, String> getBKTBJSSZSPMAP(BKTBJSSZSP BKTBJSSZSP)throws Exception;
	public int deleteXYBKTBJSSZSP(String xydm)throws Exception;
	
	public int insertBKTBZLBZ(BKTBZLBZ BKTBZLBZ)throws Exception;
	public int deleteBKTBZLBZ(BKTBZLBZ BKTBZLBZ)throws Exception;
	public int deleteBKTBZLBZO(BKTBZLBZ BKTBZLBZ)throws Exception;
	public BKTBZLBZ getBKTBZLBZ(BKTBZLBZ BKTBZLBZ)throws Exception;
	public HashMap<String, String> getBKTBZLBZMAP(BKTBZLBZ BKTBZLBZ)throws Exception;
	public int deleteXYBKTBZLBZ(String xydm)throws Exception;
	
	//专科专业信息填报
		public int insertZKTBJYJBXX(ZKTBJYJBXX ZKTBJYJBXX)throws Exception;
		public int deleteZKTBJYJBXX(ZKTBJYJBXX ZKTBJYJBXX)throws Exception;
		public int deleteZKTBJYJBXXO(ZKTBJYJBXX ZKTBJYJBXX)throws Exception;
		public ZKTBJYJBXX getZKTBJYJBXX(ZKTBJYJBXX ZKTBJYJBXX)throws Exception;
		public HashMap<String, String> getZKTBJYJBXXMAP(ZKTBJYJBXX ZKTBJYJBXX)throws Exception;
		public int deleteXYZKTBJYJBXX(String xydm)throws Exception;
		public int upZKTBJYJBXX(ZKTBJYJBXX ZKTBJYJBXX)throws Exception;
	
		public int insertZKTBSYB(ZKTBSYB ZKTBSYB)throws Exception;
		public int deleteZKTBSYB(ZKTBSYB ZKTBSYB)throws Exception;
		public int deleteZKTBSYBO(ZKTBSYB ZKTBSYB)throws Exception;
		public ZKTBSYB getZKTBSYB(ZKTBSYB ZKTBSYB)throws Exception;
		public HashMap<String, String> getZKTBSYBMAP(ZKTBSYB ZKTBSYB)throws Exception;
		public int deleteXYZKTBSYB(String xydm)throws Exception;
		public int upZKTBSYB(ZKTBSYB ZKTBSYB)throws Exception;
		
		public int insertZKTBPYXG(ZKTBPYXG ZKTBPYXG)throws Exception;
		public int deleteZKTBPYXG(ZKTBPYXG ZKTBPYXG)throws Exception;
		public int deleteZKTBPYXGO(ZKTBPYXG ZKTBPYXG)throws Exception;
		public ZKTBPYXG getZKTBPYXG(ZKTBPYXG ZKTBPYXG)throws Exception;
		public HashMap<String, String> getZKTBPYXGMAP(ZKTBPYXG ZKTBPYXG)throws Exception;
		public int deleteXYZKTBPYXG(String xydm)throws Exception;
		public int upZKTBPYXG(ZKTBPYXG ZKTBPYXG)throws Exception;
		
		public int insertZKTBJIUYE(ZKTBJIUYE ZKTBJIUYE)throws Exception;
		public int deleteZKTBJIUYE(ZKTBJIUYE ZKTBJIUYE)throws Exception;
		public int deleteZKTBJIUYEO(ZKTBJIUYE ZKTBJIUYE)throws Exception;
		public ZKTBJIUYE getZKTBJIUYE(ZKTBJIUYE ZKTBJIUYE)throws Exception;
		public HashMap<String, String> getZKTBJIUYEMAP(ZKTBJIUYE ZKTBJIUYE)throws Exception;
		public int deleteXYZKTBJIUYE(String xydm)throws Exception;
		
		public int insertZKTBZYXYL(ZKTBZYXYL ZKTBZYXYL)throws Exception;
		public int deleteZKTBZYXYL(ZKTBZYXYL ZKTBZYXYL)throws Exception;
		public int deleteZKTBZYXYLO(ZKTBZYXYL ZKTBZYXYL)throws Exception;
		public ZKTBZYXYL getZKTBZYXYL(ZKTBZYXYL ZKTBZYXYL)throws Exception;
		public HashMap<String, String> getZKTBZYXYLMAP(ZKTBZYXYL ZKTBZYXYL)throws Exception;
		public int deleteXYZKTBZYXYL(String xydm)throws Exception;
		
		public int insertZKTBPYFA(ZKTBPYFA ZKTBPYFA)throws Exception;
		public int deleteZKTBPYFA(ZKTBPYFA ZKTBPYFA)throws Exception;
		public int deleteZKTBPYFAO(ZKTBPYFA ZKTBPYFA)throws Exception;
		public ZKTBPYFA getZKTBPYFA(ZKTBPYFA ZKTBPYFA)throws Exception;
		public HashMap<String, String> getZKTBPYFAMAP(ZKTBPYFA ZKTBPYFA)throws Exception;
		public int deleteXYZKTBPYFA(String xydm)throws Exception;
		public int upZKTBPYFA(ZKTBPYFA ZKTBPYFA)throws Exception;
		
		public int insertZKTBJIAOSHI(ZKTBJIAOSHI ZKTBJIAOSHI)throws Exception;
		public int deleteZKTBJIAOSHI(ZKTBJIAOSHI ZKTBJIAOSHI)throws Exception;
		public int deleteZKTBJIAOSHIO(ZKTBJIAOSHI ZKTBJIAOSHI)throws Exception;
		public ZKTBJIAOSHI getZKTBJIAOSHI(ZKTBJIAOSHI ZKTBJIAOSHI)throws Exception;
		public HashMap<String, String> getZKTBJIAOSHIMAP(ZKTBJIAOSHI ZKTBJIAOSHI)throws Exception;
		public int deleteXYZKTBJIAOSHI(String xydm)throws Exception;
		
		public int insertZKTBJXTJ(ZKTBJXTJ ZKTBJXTJ)throws Exception;
		public int deleteZKTBJXTJ(ZKTBJXTJ ZKTBJXTJ)throws Exception;
		public int deleteZKTBJXTJO(ZKTBJXTJ ZKTBJXTJ)throws Exception;
		public ZKTBJXTJ getZKTBJXTJ(ZKTBJXTJ ZKTBJXTJ)throws Exception;
		public HashMap<String, String> getZKTBJXTJMAP(ZKTBJXTJ ZKTBJXTJ)throws Exception;
		public int deleteXYZKTBJXTJ(String xydm)throws Exception;
		
		public int insertZKTBSJJX(ZKTBSJJX ZKTBSJJX)throws Exception;
		public int deleteZKTBSJJX(ZKTBSJJX ZKTBSJJX)throws Exception;
		public int deleteZKTBSJJXO(ZKTBSJJX ZKTBSJJX)throws Exception;
		public ZKTBSJJX getZKTBSJJX(ZKTBSJJX ZKTBSJJX)throws Exception;
		public HashMap<String, String> getZKTBSJJXMAP(ZKTBSJJX ZKTBSJJX)throws Exception;
		public int deleteXYZKTBSJJX(String xydm)throws Exception;
		
		public int insertZKTBCXCY(ZKTBCXCY ZKTBCXCY)throws Exception;
		public int deleteZKTBCXCY(ZKTBCXCY ZKTBCXCY)throws Exception;
		public int deleteZKTBCXCYO(ZKTBCXCY ZKTBCXCY)throws Exception;
		public ZKTBCXCY getZKTBCXCY(ZKTBCXCY ZKTBCXCY)throws Exception;
		public HashMap<String, String> getZKTBCXCYMAP(ZKTBCXCY ZKTBCXCY)throws Exception;
		public int deleteXYZKTBCXCY(String xydm)throws Exception;
		
		public int insertZKTBJXGG(ZKTBJXGG ZKTBJXGG)throws Exception;
		public int deleteZKTBJXGG(ZKTBJXGG ZKTBJXGG)throws Exception;
		public int deleteZKTBJXGGO(ZKTBJXGG ZKTBJXGG)throws Exception;
		public ZKTBJXGG getZKTBJXGG(ZKTBJXGG ZKTBJXGG)throws Exception;
		public HashMap<String, String> getZKTBJXGGMAP(ZKTBJXGG ZKTBJXGG)throws Exception;
		public int deleteXYZKTBJXGG(String xydm)throws Exception;
		
		public int insertZKTBJSSZSP(ZKTBJSSZSP ZKTBJSSZSP)throws Exception;
		public int deleteZKTBJSSZSP(ZKTBJSSZSP ZKTBJSSZSP)throws Exception;
		public int deleteZKTBJSSZSPO(ZKTBJSSZSP ZKTBJSSZSP)throws Exception;
		public ZKTBJSSZSP getZKTBJSSZSP(ZKTBJSSZSP ZKTBJSSZSP)throws Exception;
		public HashMap<String, String> getZKTBJSSZSPMAP(ZKTBJSSZSP ZKTBJSSZSP)throws Exception;
		public int deleteXYZKTBJSSZSP(String xydm)throws Exception;
		
		public int insertZKTBZLBZ(ZKTBZLBZ ZKTBZLBZ)throws Exception;
		public int deleteZKTBZLBZ(ZKTBZLBZ ZKTBZLBZ)throws Exception;
		public int deleteZKTBZLBZO(ZKTBZLBZ ZKTBZLBZ)throws Exception;
		public ZKTBZLBZ getZKTBZLBZ(ZKTBZLBZ ZKTBZLBZ)throws Exception;
		public HashMap<String, String> getZKTBZLBZMAP(ZKTBZLBZ ZKTBZLBZ)throws Exception;
		public int deleteXYZKTBZLBZ(String xydm)throws Exception;
	
	//专业信息
	public int insertZYpz(Zypz Zypz)throws Exception;
	public int deleteZYpz(String czydm)throws Exception;
	public Zypz getZYpzxx(String czydm)throws Exception;
	public int deleteXYzy(String xydm)throws Exception;
	public int deleteXYzyone(Zypz Zypz)throws Exception;
	public Zypz getZYpzxxone(Zypz Zypz)throws Exception;
	//操作人员管理
	public List<Czy> getCzys(List<String> czylb);
	public int insertCzy(Czy cry)throws Exception;
	public int insertCzyxy(Czy cry)throws Exception;
	public List<Xxm> getAllxxm()throws Exception;
	public int deleteCzy(String czyzgh)throws Exception;
	public int deleteXYCzy(String xydm)throws Exception;
	public int upCzy(Czy cry)throws Exception;
	public List<Czy> getXYCzys(HashMap<String,Object> wu)throws Exception;
	public int upMima(Czy cry)throws Exception;
	
	//学院专业
	public int insertXYZYPZB(XYZYPZB XYZYPZB)throws Exception; 
	public List<XYZYPZB> getXYZYPZB(String xxdm)throws Exception;
	public int deleteXYZYPZB(XYZYPZB XYZYPZB)throws Exception;
	public List<XYZYPZB> getXYzyxm(XYZYPZB XYZYPZB)throws Exception;
	public int deleteXY(String xydm)throws Exception;

	//高职三级菜单
	public List<Gzzy> getYijmc()throws Exception;
	public List<Gzzy> getErjmc(String zymc)throws Exception;
	public List<Gzzy> getSanjmc(String zymc)throws Exception;
	public Gzzy getZyidlsh(String zyidlsh)throws Exception;

	//本科三级菜单
		public List<Gzzy> getYijmcb()throws Exception;
		public List<Gzzy> getErjmcb(String zymc)throws Exception;
		public List<Gzzy> getSanjmcb(String zymc)throws Exception;
		public Bkzy getZyidlshb(String zyidlsh)throws Exception;
	//系统参数表
	public Csb getCsb()throws Exception;
	public int upXylh(String Xylh)throws Exception;
	public int upCzyxlh(String Czyxlh)throws Exception;
	public int upTbLSH(String TBWJXLH)throws Exception;
	public int upZKTbLSH(String TBWJXLH)throws Exception;
	
	//学院信息
	public int insertXyxx(Xyxx Xyxx)throws Exception;
	public List<Xyxx> getXyxx(String XXDM)throws Exception;
	public int upXyxx(Xyxx Xyxx)throws Exception;
	public int deleteXyxx(String xydm)throws Exception;
	public Xyxx getXyxm(String xydm)throws Exception;
	
	
	
	public int insertZymc(Zymc Zymc)throws Exception;
	public int insertZymc1(Zymc Zymc)throws Exception;
	public int insertZymc2(Zymc Zymc)throws Exception;
	public int insertZymc3(Zymc Zymc)throws Exception;
	
	//用户登录
	public Czy getCzy(String CZYZGH)throws Exception;
	//学校查询
	public Xxm getXxm(String XXDM)throws Exception;
	public List<Czy> selectRole()throws Exception;


	
}
