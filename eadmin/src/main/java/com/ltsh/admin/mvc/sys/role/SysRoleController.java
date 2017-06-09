package com.ltsh.admin.mvc.sys.role;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjz.util.Jsons;
import com.fjz.util.Lists;
import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.menu.SysMenuBo;
import com.ltsh.admin.mvc.sys.menu.SysMenuService;
import com.ltsh.admin.security.UserDetailsImpl;
import com.ltsh.admin.util.SpringSecuritys;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;












import com.fjz.util.BaseMsg;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.util.Beans;

import com.ltsh.admin.mvc.sys.role.SysRole;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

import java.util.Date;
import java.util.List;

/**
 * 角色 Controller
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {
	public final static String ADD_TITLE = "添加"+SysRole.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysRole.tableRemarks;
	public final static String viewPath = "sys/role";
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/role/sysRole";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<SysRole> list(HttpServletRequest request,HttpServletResponse response,SysRole queryEntity,PageQuery<SysRole> query) {
		query.setParas(queryEntity);
		query=sysRoleService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,SysRole sysRole) {
		sysRole.setCreateDate(new Date());
		sysRole.setCreateBy(SpringSecuritys.getCurrentName());
		sysRoleService.insert(sysRole);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,SysRole sysRole,String sysRoleMenu) {
		SysRole dbEntity =sysRoleService.unique(sysRole.getId());
		Beans.copyProperties(sysRole, dbEntity);
//		sysRoleService.updateById(dbEntity);
		sysRoleService.updateRoleAndPrivilege(dbEntity,sysRoleMenu);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		sysRoleService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("createByDisplayNone", true);
		request.setAttribute("createDateDisplayNone", true);
		request.setAttribute("updateByDisplayNone", true);
		request.setAttribute("updateDateDisplayNone", true);
		request.setAttribute("createByDisabled", true);
		request.setAttribute("createDateDisabled", true);
		request.setAttribute("updateByDisabled", true);
		request.setAttribute("updateDateDisabled", true);

		List<SysMenuBo> bos=SpringSecuritys.getSysMenuBos();
//		SysMenuBo.foreach(bos,(bo)->bo.setChecked(true));
		request.setAttribute("ztree", Jsons.toJsonString(bos));

//		request.setAttribute("nameDisabled", true);
		return viewPath+"/sysRoleAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysRole sysRole) {
		SysRole dbEntity=sysRoleService.unique(sysRole.getId());
		List<SysMenu> sysMenus= sysMenuService.getMenu(SpringSecuritys.getGrantedAuthoritys(Lists.as(dbEntity)));
		List<SysMenuBo> bos=sysMenuService.getSysMenuBoTree(sysMenus);
		SysMenuBo.foreach(bos,(bo)->bo.setChecked(true));
		request.setAttribute("ztree", Jsons.toJsonString(bos));
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
//	   	request.setAttribute("nameDisplayNone", true);
//	   	request.setAttribute("codeDisplayNone", true);
//	   	request.setAttribute("statusDisplayNone", true);
	   	request.setAttribute("createByDisplayNone", true);
	   	request.setAttribute("createDateDisplayNone", true);
	   	request.setAttribute("updateByDisplayNone", true);
	   	request.setAttribute("updateDateDisplayNone", true);
//	   	request.setAttribute("remarksDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
//	   	request.setAttribute("nameDisabled", true);
//	   	request.setAttribute("codeDisabled", true);
//	   	request.setAttribute("statusDisabled", true);
	   	request.setAttribute("createByDisabled", true);
	   	request.setAttribute("createDateDisabled", true);
	   	request.setAttribute("updateByDisabled", true);
	   	request.setAttribute("updateDateDisabled", true);
//	   	request.setAttribute("remarksDisabled", true);
		return viewPath+"/sysRoleAddOrEdit";
	}
}





