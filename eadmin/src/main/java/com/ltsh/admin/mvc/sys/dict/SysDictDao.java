package com.ltsh.admin.mvc.sys.dict;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface SysDictDao extends BaseDaoMapper<SysDict>{
	public void page(PageQuery<SysDict> query);
}
