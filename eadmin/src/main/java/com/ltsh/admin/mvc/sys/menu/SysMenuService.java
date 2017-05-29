package com.ltsh.admin.mvc.sys.menu;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 菜单 service
 */
public interface SysMenuService extends BaseService<SysMenu>{
	public PageQuery<SysMenu> page(PageQuery<SysMenu> query);
}
