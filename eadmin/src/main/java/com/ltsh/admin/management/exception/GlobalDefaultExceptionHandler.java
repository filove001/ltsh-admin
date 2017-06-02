package com.ltsh.admin.management.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjz.util.BaseMsg;
import com.fjz.util.Jsons;
import com.fjz.util.Responses;
import com.fjz.util.log.Logs;
import org.beetl.sql.core.BeetlSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.fjz.util.exception.CheckException;

/**
 * 统一异常管理
 * @author fengjianzhong
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request,HttpServletResponse response,  Exception e) throws Exception {
        Logs.error("GlobalDefaultExceptionHandler" + e.getMessage());
	    return doView(request, response, e);
	}
	@ExceptionHandler(value = CheckException.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request,HttpServletResponse response,  CheckException e) throws Exception {
        Logs.error("CheckException"+e.getMessage());
	    return doView(request, response, e);
	}
	@ExceptionHandler(value = BeetlSQLException.class)
	public ModelAndView beetlSQLException(HttpServletRequest request,HttpServletResponse response,  RuntimeException e) throws Exception {
		Logs.error("BeetlSQLException"+e.getMessage());
		return doView(request, response, e);
	}
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ModelAndView illegalArgumentException(HttpServletRequest request,HttpServletResponse response,  RuntimeException e) throws Exception {
		Logs.error("IllegalArgumentException"+e.getMessage());
		return doView(request, response, e);
	}
	@ExceptionHandler(value = RuntimeException.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request,HttpServletResponse response,  RuntimeException e) throws Exception {
        Logs.error("RuntimeException"+e.getMessage());
	    return doView(request, response, e);
	}
	private ModelAndView doView(HttpServletRequest request,HttpServletResponse response,
			Exception e) {
		e.printStackTrace();
		if(request.getRequestURL().indexOf("/api/")!=-1){
            Logs.error("api============================");
            Responses.writeStringToResponse(response, Jsons.toString(BaseMsg.me().setMsg(e.getMessage())));
            return null;
		}
        if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                .getHeader("X-Requested-With")!= null && request
                .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {  	// 判断是否ajax请求
            // 如果不是异步请求
        	ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("msg", BaseMsg.me().setMsg(e.getMessage()));
            mav.setViewName("error/err.html");
            Logs.error("html::::::::::::::::::::::::::::");
            return mav;
//        	request.setAttribute("success", false);
//        	request.setAttribute("msg", BaseMsg.me().setMsg(e.getMessage()));
//        	request.getRequestDispatcher();
//        	response
        } else {// ajax  JSON格式返回
            Logs.error("ajax============================");
            Responses.writeStringToResponse(response, Jsons.toJsonString(BaseMsg.me().setMsg(e.getMessage())));
            return null;
        }
	}
}
