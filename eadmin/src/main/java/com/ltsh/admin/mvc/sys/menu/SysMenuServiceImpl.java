package com.ltsh.admin.mvc.sys.menu;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单 service
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService{
	@Autowired
	private SysMenuDao sysMenuDao;
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
}
