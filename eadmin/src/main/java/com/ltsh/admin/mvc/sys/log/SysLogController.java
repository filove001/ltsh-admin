package com.ltsh.admin.mvc.sys.log;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.BaseService;
import com.ltsh.admin.mvc.base.CrudController;

/**
 * 日志 Controller
 */
@Controller
@RequestMapping("/sys/log")
public class SysLogController extends CrudController<SysLog> {
	public final static String ADD_TITLE = "添加"+SysLog.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysLog.tableRemarks;
	public final static String viewPath = "sys/log";
	@Autowired
	private SysLogService sysLogService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/log/sysLog";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/sysLogAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysLog sysLog) {
		SysLog dbEntity=sysLogService.unique(sysLog.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);//编号
	   	request.setAttribute("typeDisplayNone", true);//日志类型
	   	request.setAttribute("titleDisplayNone", true);//日志标题
	   	request.setAttribute("userNameDisplayNone", true);//用户名者
	   	request.setAttribute("userIdDisplayNone", true);//用户id
	   	request.setAttribute("createDateDisplayNone", true);//创建时间
	   	request.setAttribute("remoteAddrDisplayNone", true);//操作IP地址
	   	request.setAttribute("userAgentDisplayNone", true);//用户代理
	   	request.setAttribute("requestUriDisplayNone", true);//请求URI
	   	request.setAttribute("methodDisplayNone", true);//操作方式
	   	request.setAttribute("paramsDisplayNone", true);//提交数据
	   	request.setAttribute("performDisplayNone", true);//工作性能
	   	request.setAttribute("longTimeDisplayNone", true);//请求耗时
	   	request.setAttribute("remarksDisplayNone", true);//详细信息
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);//编号
	   	request.setAttribute("typeDisabled", true);//日志类型
	   	request.setAttribute("titleDisabled", true);//日志标题
	   	request.setAttribute("userNameDisabled", true);//用户名者
	   	request.setAttribute("userIdDisabled", true);//用户id
	   	request.setAttribute("createDateDisabled", true);//创建时间
	   	request.setAttribute("remoteAddrDisabled", true);//操作IP地址
	   	request.setAttribute("userAgentDisabled", true);//用户代理
	   	request.setAttribute("requestUriDisabled", true);//请求URI
	   	request.setAttribute("methodDisabled", true);//操作方式
	   	request.setAttribute("paramsDisabled", true);//提交数据
	   	request.setAttribute("performDisabled", true);//工作性能
	   	request.setAttribute("longTimeDisabled", true);//请求耗时
	   	request.setAttribute("remarksDisabled", true);//详细信息
		return viewPath+"/sysLogAddOrEdit";
	}
}





