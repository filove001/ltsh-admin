package com.ltsh.admin.mvc.sys.user;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 用户信息 service
 */
public interface SysUserService extends BaseService<SysUser>{
	public SysUser getByUsername(String  username);
	public PageQuery<SysUser> page(PageQuery<SysUser> query);
	public SysUser checkLogin(String username,String password);
	public SysUserBo getBoByUserId(Long id);
}
