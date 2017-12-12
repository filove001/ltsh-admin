package com.ltsh.admin.mvc.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.sys.menu.SysMenuService;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import com.ltsh.admin.util.Jsoups;
import com.ltsh.admin.util.SpringSecuritys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试
 * c Controller
 */
@Controller
@RequestMapping(value = "test")
public class TestController extends BaseController {
	protected final static String ADD_TITLE = "添加用户信息";
	protected final static String UPDATE_TITLE = "编辑用户信息";
	@Autowired
	private SysMenuService sysMenuService;
	@RequestMapping({"/{href}"})
	public String layout(HttpServletRequest request,HttpServletResponse response,@PathVariable String  href) {
//		request.setAttribute("me", SpringSecuritys.getCurrentUser());
		request.setAttribute("sysMenuBos",sysMenuService.getSysMenuBoTree(sysMenuService.getMenuAll()));
		return href;
	}
	@RequestMapping({"/user"})
	@ResponseBody
	public JSONObject user(HttpServletRequest request,HttpServletResponse response) {
		String temp="{\"code\":0,\"msg\":\"\",\"totalRow\":1000,\"list\":[{\"id\":10000,\"username\":\"user-0\",\"sex\":\"女\",\"city\":\"城市-0\",\"sign\":\"签名-0\",\"experience\":255,\"logins\":24,\"wealth\":82830700,\"classify\":\"作家\",\"score\":57},{\"id\":10001,\"username\":\"user-1\",\"sex\":\"男\",\"city\":\"城市-1\",\"sign\":\"签名-1\",\"experience\":884,\"logins\":58,\"wealth\":64928690,\"classify\":\"词人\",\"score\":27},{\"id\":10002,\"username\":\"user-2\",\"sex\":\"女\",\"city\":\"城市-2\",\"sign\":\"签名-2\",\"experience\":650,\"logins\":77,\"wealth\":6298078,\"classify\":\"酱油\",\"score\":31},{\"id\":10003,\"username\":\"user-3\",\"sex\":\"女\",\"city\":\"城市-3\",\"sign\":\"签名-3\",\"experience\":362,\"logins\":157,\"wealth\":37117017,\"classify\":\"诗人\",\"score\":68},{\"id\":10004,\"username\":\"user-4\",\"sex\":\"男\",\"city\":\"城市-4\",\"sign\":\"签名-4\",\"experience\":807,\"logins\":51,\"wealth\":76263262,\"classify\":\"作家\",\"score\":6},{\"id\":10005,\"username\":\"user-5\",\"sex\":\"女\",\"city\":\"城市-5\",\"sign\":\"签名-5\",\"experience\":173,\"logins\":68,\"wealth\":60344147,\"classify\":\"作家\",\"score\":87},{\"id\":10006,\"username\":\"user-6\",\"sex\":\"女\",\"city\":\"城市-6\",\"sign\":\"签名-6\",\"experience\":982,\"logins\":37,\"wealth\":57768166,\"classify\":\"作家\",\"score\":34},{\"id\":10007,\"username\":\"user-7\",\"sex\":\"男\",\"city\":\"城市-7\",\"sign\":\"签名-7\",\"experience\":727,\"logins\":150,\"wealth\":82030578,\"classify\":\"作家\",\"score\":28},{\"id\":10008,\"username\":\"user-8\",\"sex\":\"男\",\"city\":\"城市-8\",\"sign\":\"签名-8\",\"experience\":951,\"logins\":133,\"wealth\":16503371,\"classify\":\"词人\",\"score\":14},{\"id\":10009,\"username\":\"user-9\",\"sex\":\"女\",\"city\":\"城市-9\",\"sign\":\"签名-9\",\"experience\":484,\"logins\":25,\"wealth\":86801934,\"classify\":\"词人\",\"score\":75}]}";
		JSONObject object =JSON.parseObject(temp);
		return object;
	}
	@RequestMapping({"/{href}/{href1}"})
	public String layout(HttpServletRequest request,HttpServletResponse response,@PathVariable String  href,@PathVariable String  href1) {
//		request.setAttribute("me", SpringSecuritys.getCurrentUser());
		request.setAttribute("sysMenuBos", sysMenuService.getSysMenuBoTree(sysMenuService.getMenuAll()));
		return ""+href+"/"+href1;
	}
}