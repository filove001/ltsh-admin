package com.ltsh.admin.mvc.base;

import java.util.List;

import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.mapper.BaseMapper;

import com.fjz.util.Assert;
import com.fjz.util.Empty;


public abstract class BaseServiceImpl<T> implements BaseService<T>{
	public abstract BaseMapper<T> getDao();
	  /* insert */
	public void insert(T entity){
		getDao().insert(entity);
	}
	public void insert(T entity,boolean assignKey){
		getDao().insert(entity,assignKey);
	}
	public KeyHolder insertReturnKey(T entity){
		return getDao().insertReturnKey(entity);
	}
	
	/*update*/
	public int updateById(T entity){
		return getDao().updateById(entity);
	}
	public int updateTemplateById(T entity){
		return getDao().updateTemplateById(entity);
	}
	
	/*delete*/
	public int deleteById(Object... key){
		Assert.notEmpty(key,"id不能 为空");
		for (Object object : key) {
			getDao().deleteById(object);
		}
		return 1;
	}
	public int deleteById(String... key) {
		Assert.notEmpty(key,"id不能 为空");
		for (Object object : key) {
			getDao().deleteById(object);
		}
		return 1;
	}
	/*select */
	
	public T unique(Object key){
		return getDao().unique(key);
	}
	public T getOne(T entity){
		List<T> ls=template(entity);
		if(Empty.not(ls)){
			Assert.isTrue(ls.size()==1, "查询出来的数据大于1个。");
			return ls.get(0);
		}
		return  null;
//		getDao().unique(key);
	}
	public List<T> all(){
		return getDao().all();
	}
	public List<T> all(int start,int size){
		return getDao().all(start, size);
	}
	public long allCount(){
		return getDao().allCount();
	}
	
	
	public List<T> template(T entity){
		return getDao().template(entity);
	}
	public List<T> template(T entity,int start,int size){
		return getDao().template(entity, start, size);
	}
	public long templateCount(T entity){
		return getDao().templateCount(entity);
	}
	
	
	/*sql ready*/
	
	public List<T> execute(String sql,Object... args){
		return getDao().execute(sql, args);
	}
	
	public int executeUpdate(String sql,Object... args ){
		return getDao().executeUpdate(sql, args);
	}
		
}
