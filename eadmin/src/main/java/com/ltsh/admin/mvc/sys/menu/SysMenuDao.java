package com.ltsh.admin.mvc.sys.menu;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface SysMenuDao extends BaseDaoMapper<SysMenu>{
	public void page(PageQuery<SysMenu> query);
}
