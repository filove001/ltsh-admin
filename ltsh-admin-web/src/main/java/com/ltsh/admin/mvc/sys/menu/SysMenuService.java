package com.ltsh.admin.mvc.sys.menu;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;

import java.util.Collection;
import java.util.List;

/**
 * 菜单 service
 */
public interface SysMenuService extends BaseService<SysMenu>{
	PageQuery<SysMenu> page(PageQuery<SysMenu> query);

	/**
	 * 对应的菜单树
	 * @param list
	 * @return
	 */
	List<SysMenuBo> getSysMenuBoTree(List<SysMenu> list);

	List<SysMenu> getMenuAll();

	/**
	 * 通过权限获取对应的菜单权限
	 * @param roleCodes
	 * @return
	 */
//	List<SysMenu> getMenu(Collection<? extends GrantedAuthority> roleCodes);

	List<SysMenu> getMenu(Collection<String> roleCodes);
}
