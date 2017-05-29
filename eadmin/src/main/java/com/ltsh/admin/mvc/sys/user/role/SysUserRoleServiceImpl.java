package com.ltsh.admin.mvc.sys.user.role;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 用户角色 service
 */
@Service
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRole> implements SysUserRoleService{
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public BaseMapper<SysUserRole> getDao(){
		return sysUserRoleDao;
	}
	@Override
	public PageQuery<SysUserRole> page(PageQuery<SysUserRole> query) {
		sysUserRoleDao.page(query);
		return query;
	}
}
