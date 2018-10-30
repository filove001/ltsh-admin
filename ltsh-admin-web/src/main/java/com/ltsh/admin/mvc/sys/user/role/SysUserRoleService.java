package com.ltsh.admin.mvc.sys.user.role;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 用户角色 service
 */
public interface SysUserRoleService extends BaseService<SysUserRole>{
	public PageQuery<SysUserRole> page(PageQuery<SysUserRole> query);
}
