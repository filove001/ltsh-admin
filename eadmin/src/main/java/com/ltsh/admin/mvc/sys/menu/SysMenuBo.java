package com.ltsh.admin.mvc.sys.menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjz.util.Dates;
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

}
