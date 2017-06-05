package com.ltsh.admin.mvc.sys.log;


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

import com.ltsh.admin.mvc.sys.log.SysLog;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

/**
 * 日志 Controller
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController extends BaseController {
	public final static String ADD_TITLE = "添加"+SysLog.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysLog.tableRemarks;
	public final static String viewPath = "sys/log";
	@Autowired
	private SysLogService sysLogService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/log/sysLog";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<SysLog> list(HttpServletRequest request,HttpServletResponse response,SysLog queryEntity,PageQuery<SysLog> query) {
		query.setParas(queryEntity);
		query=sysLogService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,SysLog sysLog) {
		sysLogService.insert(sysLog);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,SysLog sysLog) {
		SysLog dbEntity =sysLogService.unique(sysLog.getId());
		Beans.copyProperties(sysLog, dbEntity);
		sysLogService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		sysLogService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("nameDisabled", true);
		return viewPath+"/sysLogAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysLog sysLog) {
		SysLog dbEntity=sysLogService.unique(sysLog.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("typeDisplayNone", true);
	   	request.setAttribute("titleDisplayNone", true);
	   	request.setAttribute("userNameDisplayNone", true);
	   	request.setAttribute("userIdDisplayNone", true);
	   	request.setAttribute("createDateDisplayNone", true);
	   	request.setAttribute("remoteAddrDisplayNone", true);
	   	request.setAttribute("userAgentDisplayNone", true);
	   	request.setAttribute("requestUriDisplayNone", true);
	   	request.setAttribute("methodDisplayNone", true);
	   	request.setAttribute("paramsDisplayNone", true);
	   	request.setAttribute("performDisplayNone", true);
	   	request.setAttribute("longTimeDisplayNone", true);
	   	request.setAttribute("remarksDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("typeDisabled", true);
	   	request.setAttribute("titleDisabled", true);
	   	request.setAttribute("userNameDisabled", true);
	   	request.setAttribute("userIdDisabled", true);
	   	request.setAttribute("createDateDisabled", true);
	   	request.setAttribute("remoteAddrDisabled", true);
	   	request.setAttribute("userAgentDisabled", true);
	   	request.setAttribute("requestUriDisabled", true);
	   	request.setAttribute("methodDisabled", true);
	   	request.setAttribute("paramsDisabled", true);
	   	request.setAttribute("performDisabled", true);
	   	request.setAttribute("longTimeDisabled", true);
	   	request.setAttribute("remarksDisabled", true);
		return viewPath+"/sysLogAddOrEdit";
	}
}





