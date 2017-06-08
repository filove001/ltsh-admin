package com.ltsh.admin.mvc.sys.menu;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
import org.beetl.sql.core.engine.PageQuery;
public interface SysMenuDao extends BaseDaoMapper<SysMenu>{
	public void page(PageQuery<SysMenu> query);
}
