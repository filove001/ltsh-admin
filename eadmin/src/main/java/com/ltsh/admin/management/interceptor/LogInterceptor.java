package com.ltsh.admin.management.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjz.util.Dates;
import com.fjz.util.log.Logs;
import com.ltsh.admin.mvc.sys.log.SysLog;
import com.ltsh.admin.mvc.sys.log.SysLogService;
import com.ltsh.admin.util.SpringContextHolder;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fjz.util.Ips;
import com.fjz.util.Jsons;

import java.util.*;

/**
 * 日志拦截器
 * @author fengjianzhong
 *
 */
public class LogInterceptor implements HandlerInterceptor {
	private static final ThreadLocal<Long> startTimeThreadLocal =
			new NamedThreadLocal<Long>("ThreadLocal StartTime");
	private static final List<String> logUrl = new ArrayList<String>(){
		{
			add("delete");
			add("save");
			add("update");
			add("login");
//			put("save","");
//			put("update","");
		}
	};
	private SysLogService sysLogService= SpringContextHolder.getBean(SysLogService.class);
	public boolean checkLog(String url){
		return logUrl.contains(url.substring(url.lastIndexOf("/")+1));
	}
	@Override
	public boolean preHandle(HttpServletRequest request,  
	      HttpServletResponse response, Object handler) throws Exception {
		long beginTime = System.currentTimeMillis();//1、开始时间
		startTimeThreadLocal.set(beginTime);		//线程绑定变量（该数据只有当前请求的线程可见）
//		if(!checkLog(request.getServletPath())||"GET".equals(request.getMethod())){
//			return true;
//		}
		Logs.info("http请求类型 : {}  -URL : {}",request.getMethod(),request.getRequestURL().toString());
        Logs.info("IP : " + Ips.getIp(request));
        Logs.info("执行的类和方法 : " + handler.toString());
        Logs.info("请求的所带参数 : " +Jsons.toJsonString(request.getParameterMap()));
		Logs.info(request.getMethod()+":url:"+request.getServletPath()+" "+handler.toString()+" start");
        Logs.info(request.getRequestURL().toString()+"   在请求处理之前进行调用（Controller方法调用之前）");
		SysLog sysLog=createSysLog(request);
		sysLogService.insert(sysLog);
	  return true;
	}

	private SysLog createSysLog(HttpServletRequest request) {
		SysLog sysLog = new SysLog();
		sysLog.setCreateDate(new Date());
		sysLog.setUserAgent(request.getHeader("User-Agent"));
		sysLog.setMethod(request.getMethod());
		sysLog.setParams(Jsons.toJsonString(request.getParameterMap()));
//		sysLog.setPerform();
		sysLog.setRemoteAddr(Ips.getIp(request));
		sysLog.setRequestUri(request.getServletPath());
		return sysLog;
	}

	//	@Override
//	public void postHandle(HttpServletRequest request,
//	      HttpServletResponse response, Object handler,
//	      ModelAndView modelAndView) throws Exception {
//		Logs.info(request.getMethod()+":url:"+request.getServletPath()+" "+handler.toString()+" 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
//	}
	@Override
	public void afterCompletion(HttpServletRequest request,  
	      HttpServletResponse response, Object handler, Exception ex)  
	      throws Exception {
		long beginTime = startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
		long endTime = System.currentTimeMillis(); 	//2、结束时间
		long diffTime =endTime-beginTime;
		Logs.info("耗时：{}  合计：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
				diffTime, Dates.getTakeTime(diffTime),
				request.getRequestURI(),Runtime.getRuntime().maxMemory() /1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024,
				(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024);
		Logs.info(request.getMethod()+":url:"+request.getServletPath()+" "+handler.toString()+" 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

}  