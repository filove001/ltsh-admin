package com.ltsh.admin.mvc.sys.user;


import com.fjz.util.Lists;
import com.fjz.util.log.Logs;
import com.ltsh.admin.mvc.base.CrudController;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * c Controller
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController extends CrudController<SysUser> {
	protected final static String ADD_TITLE = "添加用户信息";
	protected final static String UPDATE_TITLE = "编辑用户信息";
	@Autowired
	public SysUserService sysUserService;
//	@RequestMapping("/login")
//	public String login(HttpServletRequest request,HttpServletResponse response) {
//		return "layout/login";
//	}
//	@RequestMapping("/layout.html")
//	public String layout(HttpServletRequest request,HttpServletResponse response) {
//		return "layout/index";
//	}
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/user/sysUser";
	}
	@RequestMapping("/name")
	public String name(HttpServletRequest request,HttpServletResponse response,String name) {
		List<String> list = new ArrayList();
		request.setAttribute("all", Lists.as(sysUserService.getByUsername(name)));
		return "sys/user/sysUser";
	}

	@RequestMapping("/test")
	@ResponseBody
	public Object test(HttpServletRequest request,HttpServletResponse response,SysUser queryEntity,PageQuery<SysUser> query) {
		Logs.info("===================test");
		return sysUserService.all();
	}
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("nameDisabled", true);
		request.setAttribute("obj", null);
		return "sys/user/sysUseraddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysUser entity) {
		SysUser dbEntity=sysUserService.unique(entity.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		return "sys/user/sysUseraddOrEdit";
	}

//	@RequestMapping("/delete")
//	@ResponseBody
//	public BaseMsg delete(HttpServletRequest request,HttpServletResponse response) {
//		sysUserService.deleteById(request.getParameter("id").split(","));
//		return BaseMsg.success;
//	}
}





