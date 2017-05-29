package com.ltsh.admin.mvc.sys.role;


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

import com.ltsh.admin.mvc.sys.role.SysRole;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

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
		sysRoleService.insert(sysRole);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,SysRole sysRole) {
		SysRole dbEntity =sysRoleService.unique(sysRole.getId());
		Beans.copyProperties(sysRole, dbEntity);
		sysRoleService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		sysRoleService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add.html")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("nameDisabled", true);
		return viewPath+"/sysRoleAddOrEdit";
	}
	@RequestMapping("/edit.html")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysRole sysRole) {
		SysRole dbEntity=sysRoleService.unique(sysRole.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("nameDisplayNone", true);
	   	request.setAttribute("codeDisplayNone", true);
	   	request.setAttribute("statusDisplayNone", true);
	   	request.setAttribute("createByDisplayNone", true);
	   	request.setAttribute("createDateDisplayNone", true);
	   	request.setAttribute("updateByDisplayNone", true);
	   	request.setAttribute("updateDateDisplayNone", true);
	   	request.setAttribute("remarksDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("nameDisabled", true);
	   	request.setAttribute("codeDisabled", true);
	   	request.setAttribute("statusDisabled", true);
	   	request.setAttribute("createByDisabled", true);
	   	request.setAttribute("createDateDisabled", true);
	   	request.setAttribute("updateByDisabled", true);
	   	request.setAttribute("updateDateDisabled", true);
	   	request.setAttribute("remarksDisabled", true);
		return viewPath+"/sysRoleAddOrEdit";
	}
}





