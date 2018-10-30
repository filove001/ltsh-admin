package com.ltsh.admin.mvc.sys.role;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;

import java.util.List;

/**
 * 角色 service
 */
public interface SysRoleService extends BaseService<SysRole>{
	public PageQuery<SysRole> page(PageQuery<SysRole> query);

	public int updateRoleAndPrivilege(SysRole sysRole,String menuIds);
	public List<SysRole> getRoleByUserName(String userName);
}
