package com.ltsh.admin.mvc.sys.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjz.util.Dates;
import com.fjz.util.log.Logs;
import com.ltsh.admin.util.Beans;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

/**
 *  sys_menu bo 菜单
 * @author fjz
 */
public class SysMenuBo extends  SysMenu{
	public List<SysMenuBo> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenuBo> children) {
		this.children = children;
	}

	private List<SysMenuBo> children=new ArrayList<>();

	/**
	 * SysMenu 转为 SysMenuBo
	 * @param sysMenu
	 * @return
	 */
	public static SysMenuBo getSysMenuBo(SysMenu sysMenu){
		SysMenuBo bo= new SysMenuBo();
		Beans.copyProperties(sysMenu,bo);
		return bo;
	}
	/**
	 * 把list变成tree
	 * @param nodeList
	 * @return
	 */
	public static List<SysMenuBo> getSysMenuBos(List<SysMenuBo> nodeList){
		List<SysMenuBo> ztree = new ArrayList<>();
		for(SysMenuBo node1 : nodeList){//taskDTOList 是数据库获取的List列表数据或者来自其他数据源的List
			boolean mark = false;
			for(SysMenuBo node2 : nodeList){
				if(node1.getParentId()!=null && node1.getParentId().equals(node2.getId())){
					mark = true;
					if(node2.getChildren() == null)
						node2.setChildren(new ArrayList<SysMenuBo>());
					node2.getChildren().add(node1);
					break;
				}
			}
			if(!mark){
				ztree.add(node1);
			}
		}
		return ztree;
	}
}
