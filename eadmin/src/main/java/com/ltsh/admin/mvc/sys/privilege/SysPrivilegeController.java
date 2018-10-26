package com.ltsh.admin.mvc.sys.privilege;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.BaseService;
import com.ltsh.admin.mvc.base.CrudController;

/**
 * 权限连接 Controller
 */
@Controller
@RequestMapping("/sys/privilege")
public class SysPrivilegeController extends CrudController<SysPrivilege> {
	public final static String ADD_TITLE = "添加"+SysPrivilege.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysPrivilege.tableRemarks;
	public final static String viewPath = "sys/privilege";
	@Autowired
	private SysPrivilegeService sysPrivilegeService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/privilege/sysPrivilege";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/sysPrivilegeAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysPrivilege sysPrivilege) {
		SysPrivilege dbEntity=sysPrivilegeService.unique(sysPrivilege.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);//编号
	   	request.setAttribute("masterDisplayNone", true);//主体
	   	request.setAttribute("masterValueDisplayNone", true);//控制值
	   	request.setAttribute("accessDisplayNone", true);//领域 
	   	request.setAttribute("accessValueDisplayNone", true);//领域值
	   	request.setAttribute("operationDisplayNone", true);//权限
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);//编号
	   	request.setAttribute("masterDisabled", true);//主体
	   	request.setAttribute("masterValueDisabled", true);//控制值
	   	request.setAttribute("accessDisabled", true);//领域 
	   	request.setAttribute("accessValueDisabled", true);//领域值
	   	request.setAttribute("operationDisabled", true);//权限
		return viewPath+"/sysPrivilegeAddOrEdit";
	}
}





