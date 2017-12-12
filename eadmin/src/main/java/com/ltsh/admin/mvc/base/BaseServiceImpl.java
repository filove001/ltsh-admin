package com.ltsh.admin.mvc.base;

import java.util.List;

import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;

import com.fjz.util.Assert;
import com.fjz.util.Empty;
import org.springframework.beans.factory.annotation.Autowired;

// BaseServiceImpl<K extends BaseDaoMapper<T>,T>
public abstract class BaseServiceImpl<T> implements BaseService<T>{
	@Autowired
	public BaseDaoMapper<T> dao;
	public PageQuery<T> page(PageQuery<T> query){
		dao.page(query);
		return query;
	}
	  /* insert */
	public void insert(T entity){
		dao.insert(entity);
	}
	public void insert(T entity,boolean assignKey){
		dao.insert(entity,assignKey);
	}
	public KeyHolder insertReturnKey(T entity){
		return dao.insertReturnKey(entity);
	}
	
	/*update*/
	public int updateById(T entity){
		return dao.updateById(entity);
	}
	public int updateTemplateById(T entity){
		return dao.updateTemplateById(entity);
	}
	
	/*delete*/
	public int deleteById(Object... key){
		Assert.notEmpty(key,"id不能 为空");
		for (Object object : key) {
			dao.deleteById(object);
		}
		return 1;
	}
	public int deleteById(String... key) {
		Assert.notEmpty(key,"id不能 为空");
		for (Object object : key) {
			dao.deleteById(object);
		}
		return 1;
	}
	/*select */
	
	public T unique(Object key){
		return dao.unique(key);
	}
	public T getOne(T entity){
		List<T> ls=template(entity);
		if(Empty.not(ls)){
			Assert.isTrue(ls.size()==1, "查询出来的数据大于1个。");
			return ls.get(0);
		}
		return  null;
//		dao.unique(key);
	}
	public List<T> all(){
		return dao.all();
	}
	public List<T> all(int start,int size){
		return dao.all(start, size);
	}
	public long allCount(){
		return dao.allCount();
	}
	
	
	public List<T> template(T entity){
		return dao.template(entity);
	}
	public List<T> template(T entity,int start,int size){
		return dao.template(entity, start, size);
	}
	public long templateCount(T entity){
		return dao.templateCount(entity);
	}
	
	
	/*sql ready*/
	
	public List<T> execute(String sql,Object... args){
		return dao.execute(sql, args);
	}
	
	public int executeUpdate(String sql,Object... args ){
		return dao.executeUpdate(sql, args);
	}
		
}
