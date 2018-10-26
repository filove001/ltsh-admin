//package com.ltsh.admin.mvc.controller;
//
//
//import com.fjz.util.log.Logs;
//import com.ltsh.admin.config.GlobalConf;
//import com.ltsh.admin.management.aop.LongTimeAop;
//import com.ltsh.admin.mvc.base.BaseController;
//import com.ltsh.admin.mvc.sys.user.SysUserService;
//import com.ltsh.admin.util.Jsoups;
//import com.ltsh.admin.util.SpringContextHolder;
//import com.ltsh.admin.util.SpringSecuritys;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//import java.util.Map;
//
//import static javafx.scene.input.KeyCode.J;
//
///**
// * 小说
// * c Controller
// */
//@Controller
//@RequestMapping(value = "book")
//public class BookController extends BaseController {
//	protected final static String ADD_TITLE = "添加用户信息";
//	protected final static String UPDATE_TITLE = "编辑用户信息";
//	@Autowired
//	public SysUserService sysUserService;
//	@RequestMapping({"/{href}"})
//	public String layout(HttpServletRequest request,HttpServletResponse response,@PathVariable String  href) {
//		return "book/"+href;
//	}
//
//
//	@RequestMapping("/searchName")
//	public String searchName(HttpServletRequest request,HttpServletResponse response,String searchName) {
//		Jsoups.getText("https://www.qidian.com/search?kw="+searchName,"");
//		return null;
//	}
//
//	@RequestMapping("/test")
//	public String test(HttpServletRequest request,HttpServletResponse response) {
//		return null;
//	}
//}