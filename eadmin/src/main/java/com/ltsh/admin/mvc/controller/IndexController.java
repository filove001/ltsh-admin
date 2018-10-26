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
	public final static String loginUrl="/login";//登录页地址
	public final static String indexUrl="/layout";//首页地址,登录后默认地址
	public static String index="layui2/index";//首页文件地址
	public static String login="layui2/login";//登录文件地址
	@Autowired
	public SysUserService sysUserService;
	@RequestMapping(loginUrl)
	public String login(HttpServletRequest request,HttpServletResponse response) {
		//判断是否登录登录后不要在登录页
		if(SpringSecuritys.getCurrentUser()!=null){
			return "redirect:"+indexUrl;
		}
		return login;
	}
	@RequestMapping({indexUrl})
	public String layout(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("me", SpringSecuritys.getCurrentUser());
		request.setAttribute("sysMenuBos", SpringSecuritys.getSysMenuBos());
		return index;
	}
}





