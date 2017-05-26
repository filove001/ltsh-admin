package com.fjz.util;

import java.util.List;
import java.util.Map;



/**
 * sql语句生成. 该类提供了对数据库的查询,修改,增加,删除等sql语句生成
 * 
 * @author fjz
 * 
 */
public class Sql {
	public final static String select_from="select * from ";
	public final static String select="select * ";
	public final static String and=" and ";
	public final static String or=" or ";
	public final static String update="update ";
	public final static String delete="delete from ";
	private String sql;
	private Object[] param;
	private String where;
	public Sql(String sql, Object[] param,String where) {
		super();
		this.sql = sql;
//		this.param = Empty.is(param)?null:param;
		this.param=param;
		this.where=where;
	}
	
	public static Sql select(Map<String,Object> map,Class<?> clazz,String groupBy){
		return  select(map,Names.toUnderlineName(clazz.getSimpleName()),groupBy);
	}
	public static Sql select(Map<String,Object> map,String tableName){
		return select(map,tableName,null);
	}
	public static Sql select(Map<String,Object> map,String tableName,String groupBy){
		StringBuilder sb=new StringBuilder("select * from "+tableName+" ");
		List<Object> param=Lists.newList();
		StringBuilder where=new StringBuilder(" where 1=1 ");
		for (Map.Entry<String,Object> en: map.entrySet()) {
			if(Empty.not(en.getValue())){
				where.append(" and ").append(Names.toUnderlineName(en.getKey())).append("=? ");
				param.add(en.getValue());
			}
		}
		sb.append(where);
		if(groupBy!=null)
			sb.append(groupBy);
		return  new Sql(sb.toString(),param.toArray(),where.toString());
	}
	
	public static Sql where(Map<String,Object> map){
		List<Object> param=Lists.newList();
		StringBuilder where=new StringBuilder(" where 1=1 ");
		for (Map.Entry<String,Object> en: map.entrySet()) {
			if(Empty.not(en.getValue())){
				where.append(" and ").append(Names.toUnderlineName(en.getKey())).append("=? ");
				param.add(en.getValue());
			}
		}
		return  new Sql(null,param.toArray(),where.toString());
	}
	
	public static <T>Sql select(T t){
		return select(Maps.beanToMap(t),t.getClass(),null);
	}
	
	
	

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
	public Object[] getParam() {
		return param;
	}

	public void setParam(Object[] param) {
		this.param = param;
	}

	/** Prevent instantiation */
	private Sql() {
	}
}

