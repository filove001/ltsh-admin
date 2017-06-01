package com.ltsh.admin.mvc.sys.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjz.util.BaseMsg;
import com.fjz.util.Lists;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.util.Caches;
import com.ltsh.admin.util.SpringContextHolder;

/**
 * c Controller
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {
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
		request.setAttribute("all", Lists.as(sysUserService.getByUsername(name)));
		return "sys/user/sysUser";
	}
	
	@RequestMapping("/all")
	@ResponseBody
	public Object all(HttpServletRequest request,HttpServletResponse response,SysUser queryEntity,PageQuery<SysUser> query) {
		return Caches.getAll();
	}
	@RequestMapping("/clearAll")
	@ResponseBody
	public Object clearAll(HttpServletRequest request,HttpServletResponse response,SysUser queryEntity,PageQuery<SysUser> query) {
		return Caches.removeAll();
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<SysUser> list(HttpServletRequest request,HttpServletResponse response,SysUser queryEntity,PageQuery<SysUser> query) {
		query.setParas(queryEntity);
		query=sysUserService.page(query);
		return query;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		sysUserService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
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
//	
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> insert(HttpServletRequest request,HttpServletResponse response,SysUser sysUser) {
//		SysUserBo user=Webs.getSysUser();
//		sysUser.setCreateBy(user.getUsername());
//		sysUser.setCreateTime(new Date());
//		sysUser.setStatus("1");
//		sysUser.setId(SysUserAutoIds.getId());
//		sysUser.setPassword(Passwords.entryptPassword(sysUser.getPassword()));
		sysUserService.insert(sysUser);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,SysUser sysUser) {
		SysUser user =sysUserService.unique(sysUser.getId());
		Beans.copyProperties(sysUser, user);
		sysUserService.updateById(user);
		return BaseMsg.successMsg;
	}
//	@RequestMapping("/delete")
//	@ResponseBody
//	public BaseMsg delete(HttpServletRequest request,HttpServletResponse response) {
//		sysUserService.deleteById(request.getParameter("id").split(","));
//		return BaseMsg.success;
//	}
}





