package com.ltsh.admin.mvc.controller;


import com.fjz.util.BaseMsg;
import com.fjz.util.Lists;
import com.fjz.util.log.Logs;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.util.Caches;
import com.ltsh.admin.util.SpringSecuritys;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * c Controller
 */
@Controller
public class IndexController extends BaseController {
	protected final static String ADD_TITLE = "添加用户信息";
	protected final static String UPDATE_TITLE = "编辑用户信息";
	@Autowired
	public SysUserService sysUserService;
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		return "layout/login";
	}
	@RequestMapping({"/layout","/"})
	public String layout(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("me", SpringSecuritys.getCurrentUser());
		request.setAttribute("sysMenuBos", SpringSecuritys.getSysMenuBos());
		return "layout/index";
	}
}





