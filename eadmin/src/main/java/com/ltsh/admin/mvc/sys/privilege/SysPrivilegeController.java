package com.ltsh.admin.mvc.sys.privilege;


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

import com.ltsh.admin.mvc.sys.privilege.SysPrivilege;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

/**
 * 角色 Controller
 */
@Controller
@RequestMapping("/sys/privilege")
public class SysPrivilegeController extends BaseController {
	public final static String ADD_TITLE = "添加"+SysPrivilege.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysPrivilege.tableRemarks;
	public final static String viewPath = "sys/privilege";
	@Autowired
	private SysPrivilegeService sysPrivilegeService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/privilege/sysPrivilege";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<SysPrivilege> list(HttpServletRequest request,HttpServletResponse response,SysPrivilege queryEntity,PageQuery<SysPrivilege> query) {
		query.setParas(queryEntity);
		query=sysPrivilegeService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,SysPrivilege sysPrivilege) {
		sysPrivilegeService.insert(sysPrivilege);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,SysPrivilege sysPrivilege) {
		SysPrivilege dbEntity =sysPrivilegeService.unique(sysPrivilege.getId());
		Beans.copyProperties(sysPrivilege, dbEntity);
		sysPrivilegeService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		sysPrivilegeService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add.html")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("nameDisabled", true);
		return viewPath+"/sysPrivilegeAddOrEdit";
	}
	@RequestMapping("/edit.html")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysPrivilege sysPrivilege) {
		SysPrivilege dbEntity=sysPrivilegeService.unique(sysPrivilege.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("masterDisplayNone", true);
	   	request.setAttribute("masterValueDisplayNone", true);
	   	request.setAttribute("accessDisplayNone", true);
	   	request.setAttribute("accessValueDisplayNone", true);
	   	request.setAttribute("operationDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("masterDisabled", true);
	   	request.setAttribute("masterValueDisabled", true);
	   	request.setAttribute("accessDisabled", true);
	   	request.setAttribute("accessValueDisabled", true);
	   	request.setAttribute("operationDisabled", true);
		return viewPath+"/sysPrivilegeAddOrEdit";
	}
}





