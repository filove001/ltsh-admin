package com.ltsh.admin.mvc.sys.menu;

import com.ltsh.admin.mvc.sys.privilege.SysPrivilege;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilegeDao;
import com.ltsh.admin.mvc.sys.role.SysRole;
import com.ltsh.admin.mvc.sys.role.SysRoleDao;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;

import java.util.*;

/**
 * 菜单 service
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	SysPrivilegeDao sysPrivilegeDao;
	@Autowired
	SysRoleDao sysRoleDao;
	@Override
	public BaseMapper<SysMenu> getDao(){
		return sysMenuDao;
	}
	@Override
	public PageQuery<SysMenu> page(PageQuery<SysMenu> query) {
		sysMenuDao.page(query);
		return query;
	}

	@Override
	public List<SysMenuBo> getSysMenuBoTree(List<SysMenu> list) {
		List<SysMenuBo> nodeList = new ArrayList();
		list.forEach((e)->{nodeList.add(SysMenuBo.getSysMenuBo(e));});
		List<SysMenuBo> ztree = SysMenuBo.getSysMenuBos(nodeList);
		return ztree;
	}
	public static SysMenu searchSysMenu = new SysMenu();
	public static SysPrivilege searchSysPrivilege = new SysPrivilege();
	static {
		searchSysMenu.setStatus(1);
		searchSysPrivilege.setAccess(SysMenu.tableName);
	}

	@Override
	public List<SysMenu> getMenuAll() {
		return sysMenuDao.all();
	}
	@Override
	public List<SysMenu> getMenu(Collection<? extends GrantedAuthority> roleCodes) {
		List<SysMenu> sysMenus = sysMenuDao.template(searchSysMenu);
		List<SysPrivilege> sysPrivileges = sysPrivilegeDao.template(searchSysPrivilege);
		List<SysRole> sysRoles = sysRoleDao.all();
		List<SysMenu> tmpMenuList = new ArrayList<SysMenu>();
		Map<String, Object> menuIdMap = new HashMap<String, Object>();
		if (sysPrivileges != null && sysRoles != null && sysMenus != null) {
			for (SysPrivilege sysPrivilege : sysPrivileges) {
				for (SysRole role : sysRoles) {
					for (GrantedAuthority grantedAuthority : roleCodes) {
						if (grantedAuthority.getAuthority().equals(role.getCode()) && sysPrivilege.getMasterValue().equals(String.valueOf(role.getId()))) {
							menuIdMap.put(sysPrivilege.getAccessValue(), sysPrivilege.getMasterValue());
						}
					}

				}
			}
			for (SysMenu menu :
					sysMenus) {
				if (menuIdMap.get(String.valueOf(menu.getId())) != null) {
					tmpMenuList.add(menu);
				}
			}
			Collections.sort(tmpMenuList, (o1, o2) -> {
				int compareResult = 0;
				if (o1.getSort() != null && o2.getSort() != null) {
					if (o1.getSort() > o2.getSort()) {
						compareResult = 1;
					} else if (o1.getSort() < o2.getSort()) {
						compareResult = -1;
					}
				}
				return compareResult;
			});
		}
		return tmpMenuList;
	}
}
