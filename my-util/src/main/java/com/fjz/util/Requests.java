package com.fjz.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
public class Requests {


	public static String getBasePath (HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
