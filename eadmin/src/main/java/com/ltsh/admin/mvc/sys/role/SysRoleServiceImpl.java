package com.ltsh.admin.mvc.sys.role;

import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilege;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilegeDao;
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
	@Autowired
	private SysPrivilegeDao sysPrivilegeDao;
	@Override
	public BaseMapper<SysRole> getDao(){
		return sysRoleDao;
	}
	@Override
	public PageQuery<SysRole> page(PageQuery<SysRole> query) {
		sysRoleDao.page(query);
		return query;
	}

	@Override
	public int updateRoleAndPrivilege(SysRole sysRole, String menuIds) {
		//删除 SysPrivilege 上对应的权限数据
		sysPrivilegeDao.executeUpdate("delete  from "+ SysPrivilege.tableName+" where access='sys_menu' and master='sys_role' and master_value=?",sysRole.getId());
		String[] menus=menuIds.split(",");
		for (String menuId:menus) {
			SysPrivilege sysPrivilege=new SysPrivilege();
			sysPrivilege.setMaster(SysRole.tableName);
			sysPrivilege.setMasterValue(sysRole.getId()+"");
			sysPrivilege.setAccess(SysMenu.tableName);
			sysPrivilege.setAccessValue(menuId);
			sysPrivilegeDao.insert(sysPrivilege);
		}
		this.updateById(sysRole);
		return 1;
	}
}
