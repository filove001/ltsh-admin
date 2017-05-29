package com.ltsh.admin.mvc.sys.privilege;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 角色 service
 */
public interface SysPrivilegeService extends BaseService<SysPrivilege>{
	public PageQuery<SysPrivilege> page(PageQuery<SysPrivilege> query);
}
