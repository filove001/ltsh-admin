package com.fjz.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public class Requests {
//测试的请求url, get方法
//"http://localhost:8080/struts2/user/login.action?userid=1000"
//
////获取请求方法
//request.getMethod();        //返回"GET"
//
////获取请求协议
//request.getScheme();        //返回"http"
//
////获取请求域名(IP地址);
//request.getServerName();    //返回"localhost"
//
////获取请求端口号
//request.getServerPort();    //返回"8080"
//
////获取请求URL, 不包括请求参数
//request.getRequestURL();    //返回"http://localhost:8080/struts2/user/login.action"
//
////获取请求URI, 也不包括请求参数, 相当于contextPath + servletPath
//request.getRequestURI();    //返回"/struts2/user/login.action"
//
////获取请求参数, 不带问号"?"
//request.getQueryString();   //返回"userid=1000"
//
////获取请求协议
//request.getProtocol();      //返回"HTTP/1.1"
//
////获取Web应用程序路径
//request.getContextPath();   //返回"/struts2"
//
////获取请求资源路径
//request.getServletPath();   //返回"/user/login.action"
	public static String getURI (HttpServletRequest request){
		return getBasePath(request)+request.getRequestURI();
	}
	public static String getBasePath (HttpServletRequest request){
		String path = request.getContextPath();
//		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String basePath = request.getScheme()+"://"+Ips.getLocalIP()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
	/** 
	 * @Author: fjz
	 * @Description: 获取参数
	 * @param request
	 * @param paramName		参数名称
	 * @param isRequired	是否是必须的
	 * @return String: 
	 */
	public static String getParameter(HttpServletRequest request, String paramName, boolean isRequired){
		String paramValue = request.getParameter(paramName);
		if(isRequired && (paramValue == null || "".equals(paramValue.trim()))){
			throw new RuntimeException("[ 参数" + paramName + "的值为空 ]");
		}
		return paramValue;
	}
	
	/** 
	 * @Author: fjz
	 * @Description: 获取request所有参数存在一个map里
	 * @param request
	 * @return Map<String,String>: 
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();	//得到参数名
            String parameterValue = getParameter(request, parameterName, false);		//得到参数值
            
			if (parameterValue==null||"".equals(parameterValue.trim()) || "null".equals(parameterValue.trim().toLowerCase())){
				continue;
			}
			map.put(parameterName,  parameterValue);
        }
        return map;
    }
	
}
