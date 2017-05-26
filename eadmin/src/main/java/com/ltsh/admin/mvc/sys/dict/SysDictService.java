package com.ltsh.admin.mvc.sys.dict;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 字典 service
 */
public interface SysDictService extends BaseService<SysDict>{
	public PageQuery<SysDict> page(PageQuery<SysDict> query);
}
