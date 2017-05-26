package com.ltsh.admin.management.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fjz.util.Ips;
import com.fjz.util.Jsons;

/**
 * 拦截全部的请求(进行初始化操作)
 * @author fengjianzhong
 *
 */
public class LogInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request,  
	      HttpServletResponse response, Object handler) throws Exception {
		logger.info("URL : " + request.getRequestURL().toString());
        logger.info("http请求类型 : " + request.getMethod());
        logger.info("IP : " + Ips.getIp(request));
        logger.info("执行的类和方法 : " + handler.toString());
//        HandlerMethod handlerMethod=(HandlerMethod)handler;
//        handlerMethod.getMethodAnnotation(annotationType);
        
        logger.info("请求的所带参数 : " +Jsons.toJsonString(request.getParameterMap()));
        logger.info(request.getRequestURL().toString()+"   在请求处理之前进行调用（Controller方法调用之前）");
//        request.setAttribute("ctx", request.getContextPath());
//        request.setAttribute("uipath", request.getContextPath()+"/AdminLTE2/");
//        logger.info("uipath", request.getContextPath()+"/AdminLTE2/");
        //判断是否登录了
//		SysUser sysUser=UserUtils.getSysUser();
//		if(sysUser==null){
//			response.sendRedirect("login");  
//		}
//		logger.info(request.getMethod()+":url:"+request.getServletPath()+" "+handler.toString()+" start");
	//	MethodNameResolver methodNameResolver = new InternalPathMethodNameResolver();
	//	System.out.println("methodName="+methodNameResolver.getHandlerMethodName(request));
	  return true;  
	}  
	
	@Override  
	public void postHandle(HttpServletRequest request,  
	      HttpServletResponse response, Object handler,  
	      ModelAndView modelAndView) throws Exception { 
		logger.info(request.getMethod()+":url:"+request.getServletPath()+" "+handler.toString()+" 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
	}  
	
	@Override  
	public void afterCompletion(HttpServletRequest request,  
	      HttpServletResponse response, Object handler, Exception ex)  
	      throws Exception {  
		logger.info(request.getMethod()+":url:"+request.getServletPath()+" "+handler.toString()+" 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}  

}  