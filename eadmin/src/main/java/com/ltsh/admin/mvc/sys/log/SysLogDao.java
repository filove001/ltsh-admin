package com.ltsh.admin.mvc.sys.log;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface SysLogDao extends BaseDaoMapper<SysLog>{
	public void page(PageQuery<SysLog> query);
}
