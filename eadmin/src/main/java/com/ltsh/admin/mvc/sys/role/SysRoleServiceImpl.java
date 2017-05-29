package com.ltsh.admin.mvc.sys.role;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 角色 service
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService{
	@Autowired
	private SysRoleDao sysRoleDao;
	@Override
	public BaseMapper<SysRole> getDao(){
		return sysRoleDao;
	}
	@Override
	public PageQuery<SysRole> page(PageQuery<SysRole> query) {
		sysRoleDao.page(query);
		return query;
	}
}
