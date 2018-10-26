package com.ltsh.admin.mvc.base;

import java.util.List;

import com.ltsh.admin.mvc.book.Book;
import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.engine.PageQuery;

public interface BaseService<T> {
	PageQuery<T> page(PageQuery<T> query);
	/* insert */
	void insert(T entity);
	void insert(T entity,boolean assignKey);
	KeyHolder insertReturnKey(T entity);
	
	/*update*/
	int updateById(T entity);
	int updateTemplateById(T entity);
	
	int deleteById(String... key);
	/*delete*/
	int deleteById(Object... key);
	/*select */
	
	T unique(Object key);
	T getOne(T entity);
	List<T> all();
	List<T> all(int start,int size);
	long allCount();
	
	
	List<T> template(T entity);
	List<T> template(T entity,int start,int size);
	long templateCount(T entity);
	
	
	/*sql ready*/
	
	List<T> execute(String sql,Object... args);
	
	int executeUpdate(String sql,Object... args );

}
