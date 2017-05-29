package com.ltsh.admin.mvc.sys.privilege;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 角色 service
 */
@Service
public class SysPrivilegeServiceImpl extends BaseServiceImpl<SysPrivilege> implements SysPrivilegeService{
	@Autowired
	private SysPrivilegeDao sysPrivilegeDao;
	@Override
	public BaseMapper<SysPrivilege> getDao(){
		return sysPrivilegeDao;
	}
	@Override
	public PageQuery<SysPrivilege> page(PageQuery<SysPrivilege> query) {
		sysPrivilegeDao.page(query);
		return query;
	}
}
