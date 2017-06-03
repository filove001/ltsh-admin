package com.ltsh.admin.mvc.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltsh.admin.config.GlobalConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjz.util.BaseMsg;



/**
 * 基础BaseController
 * @author fjz
 *
 */
public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";  
	
	protected final static String CREATED_SUCCESS = "创建成功";
	protected final static String UPDATE_SUCCESS = "更新成功";
	protected final static String DELETE_SUCCESS = "删除成功";
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@ModelAttribute
	public void init(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("debug", GlobalConf.debug);
        request.setAttribute("ctx", request.getContextPath());
        request.setAttribute("ui", request.getContextPath()+"/layui");
	}
}
