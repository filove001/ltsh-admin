package com.ltsh.admin.mvc.controller;


import com.fjz.util.Jsons;
import com.fjz.util.Requests;
import com.fjz.util.log.Logs;
import com.ltsh.admin.config.GlobalConf;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import com.ltsh.admin.util.SpringContextHolder;
import com.ltsh.admin.util.SpringSecuritys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * c Controller
 */
@Controller
public class ErrController extends BaseController implements ErrorController {
//	@RequestMapping("500")
//	public String toPage(){
//		return "err/500";
//	}

	private static final String ERROR_PATH = "/error";
	@Autowired
	private ErrorAttributes errorAttributes;
	@RequestMapping(value=ERROR_PATH)
	public String handleError(HttpServletRequest request,WebRequest webRequest){
//		HttpServletRequest request=SpringContextHolder.getRequest();
		HttpStatus status = getStatus(request);
		request.setAttribute("status",status.toString());
		request.setAttribute("msg", GlobalConf.msg.get(status.toString()));
		Map<String, Object> map=errorAttributes.getErrorAttributes(webRequest,true);
//		Integer status=(Integer)errorAttributes.get("status");
//		String path=(String)errorAttributes.get("path");
//		String messageFound=(String)errorAttributes.get("message");
//		Logs.warn("错误url:"+ Jsons.toJsonString(map));
//		Logs.warn("错误url:"+ Requests.getURI(request));
		Logs.warn("错误，错误编码：{} status：{} url：{} error：{}",GlobalConf.errCodeHtml,status.toString(),map.get("path"),map.get("error"));
		return "err/err";
	}
	/**
	 * 获取错误编码
	 * @param request
	 * @return
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		}
		catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}





