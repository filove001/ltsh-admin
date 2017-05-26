package com.fjz.util;


public class Objs {
	
	public static <T>T getObj(T t,T defaultObj){
		if(t==null)
			return defaultObj;
		return t;
	}
	public static <T>T get(T t,T defaultObj){
		if(t==null)
			return defaultObj;
		return t;
	}
	
//	List<BaseSourcePoolDTL> dtls=baseSourcepoolDtlDao.findByExample(q);
//	//没法定位从表号源  只有粗暴的删除
////	isubpooldao.deleteBaseSourcePoolDTL(getRegiDateInfoBo.getSourceID(),
////			getRegiDateInfoBo.getRegistarttime(),getRegiDateInfoBo.getRegiendtime());
//	BaseSourcePoolDTL saveBaseSourcePoolDTL =null;
//	if(Empty.is(dtls)){
//		BaseSourcePoolDTL saveBaseSourcePoolDTL = new BaseSourcePoolDTL();
//	}else{
//			
//	}
}
