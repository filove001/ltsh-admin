package com.ltsh.admin.mvc.sys.privilege;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface SysPrivilegeDao extends BaseDaoMapper<SysPrivilege>{
	public void page(PageQuery<SysPrivilege> query);
}
