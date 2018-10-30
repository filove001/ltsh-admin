package com.ltsh.admin.mvc.controller;


import com.ltsh.admin.management.aop.LongTimeAop;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 统计
 */
@Controller
@RequestMapping("/count")
public class CountController extends BaseController {
	protected final static String ADD_TITLE = "添加用户信息";
	protected final static String UPDATE_TITLE = "编辑用户信息";
	@Autowired
	public SysUserService sysUserService;
	@RequestMapping("/longTime")
	@ResponseBody
	public Map<String, List<Long>> longTime(HttpServletRequest request, HttpServletResponse response) {
		return LongTimeAop.longTimeMap;
	}
}





