package com.ltsh.admin.management.interceptor;

import com.fjz.util.Jsons;
import com.ltsh.admin.annotation.SameUrlData;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个用户 相同url 同时提交 相同数据 验证
 * 主要通过 session中保存到的url 和 请求参数。如果和上次相同，则是重复提交表单
 * Created by Administrator on 2017/6/3.
 */
public class SameUrlDataInterceptor  extends HandlerInterceptorAdapter {

    private final static String repeatData="repeatData";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            SameUrlData annotation = method.getAnnotation(SameUrlData.class);
            if (annotation != null) {
                if(repeatDataValidator(request))//如果重复相同数据
                    return false;
                else
                    return true;
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        request.getSession().removeAttribute(repeatData);//完成方法后清空重复提交数据,不需要
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 验证同一个url数据是否相同提交  ,相同返回true
     * @param httpServletRequest
     * @return
     */
    public boolean repeatDataValidator(HttpServletRequest httpServletRequest)
    {
        String params= Jsons.toJsonString(httpServletRequest.getParameterMap());
        String url=httpServletRequest.getRequestURI();
        Map<String,String> map=new HashMap<>();
        map.put(url, params);
        String nowUrlParams=map.toString();//
        HttpSession sesson =httpServletRequest.getSession();
        Object preUrlParams=sesson.getAttribute(repeatData);
        if(preUrlParams==null//如果上一个数据为null,表示还没有访问页面
                || !preUrlParams.toString().equals(nowUrlParams))//如果上次 url+数据 和本次url加数据不同，则不是重复提交
        {
            sesson.setAttribute(repeatData, nowUrlParams);
            return false;
        }
        return true;
//        else//否则，已经访问过页面
//        {
//            if(preUrlParams.toString().equals(nowUrlParams))//如果上次url+数据和本次url+数据相同，则表示城府添加数据
//            {
//                return true;
//            }
//            else//如果上次 url+数据 和本次url加数据不同，则不是重复提交
//            {
//                sesson.setAttribute(repeatData, nowUrlParams);
//                return false;
//            }
//
//        }
    }

}
