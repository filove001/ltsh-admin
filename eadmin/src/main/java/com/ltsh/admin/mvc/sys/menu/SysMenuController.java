package com.ltsh.admin.mvc.sys.menu;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;












import com.fjz.util.BaseMsg;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.util.Beans;

import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

/**
 * 菜单 Controller
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {
	public final static String ADD_TITLE = "添加"+SysMenu.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysMenu.tableRemarks;
	public final static String viewPath = "sys/menu";
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/menu/sysMenu";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<SysMenu> list(HttpServletRequest request,HttpServletResponse response,SysMenu queryEntity,PageQuery<SysMenu> query) {
		query.setParas(queryEntity);
		query=sysMenuService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,SysMenu sysMenu) {
		sysMenuService.insert(sysMenu);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,SysMenu sysMenu) {
		SysMenu dbEntity =sysMenuService.unique(sysMenu.getId());
		Beans.copyProperties(sysMenu, dbEntity);
		sysMenuService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		sysMenuService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("nameDisabled", true);
		return viewPath+"/sysMenuAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysMenu sysMenu) {
		SysMenu dbEntity=sysMenuService.unique(sysMenu.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("parentIdDisplayNone", true);
	   	request.setAttribute("parentIdsDisplayNone", true);
	   	request.setAttribute("levelDisplayNone", true);
	   	request.setAttribute("typeDisplayNone", true);
	   	request.setAttribute("nameDisplayNone", true);
	   	request.setAttribute("sortDisplayNone", true);
	   	request.setAttribute("hrefDisplayNone", true);
	   	request.setAttribute("targetDisplayNone", true);
	   	request.setAttribute("iconDisplayNone", true);
	   	request.setAttribute("permissionDisplayNone", true);
	   	request.setAttribute("statusDisplayNone", true);
	   	request.setAttribute("createByDisplayNone", true);
	   	request.setAttribute("createDateDisplayNone", true);
	   	request.setAttribute("updateByDisplayNone", true);
	   	request.setAttribute("updateDateDisplayNone", true);
	   	request.setAttribute("remarksDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("parentIdDisabled", true);
	   	request.setAttribute("parentIdsDisabled", true);
	   	request.setAttribute("levelDisabled", true);
	   	request.setAttribute("typeDisabled", true);
	   	request.setAttribute("nameDisabled", true);
	   	request.setAttribute("sortDisabled", true);
	   	request.setAttribute("hrefDisabled", true);
	   	request.setAttribute("targetDisabled", true);
	   	request.setAttribute("iconDisabled", true);
	   	request.setAttribute("permissionDisabled", true);
	   	request.setAttribute("statusDisabled", true);
	   	request.setAttribute("createByDisabled", true);
	   	request.setAttribute("createDateDisabled", true);
	   	request.setAttribute("updateByDisabled", true);
	   	request.setAttribute("updateDateDisabled", true);
	   	request.setAttribute("remarksDisabled", true);
		return viewPath+"/sysMenuAddOrEdit";
	}
}





