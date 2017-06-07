package com.ltsh.admin.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Random on 2017/4/24.
 */
public class GlobalConf {
    /**是否是测试模式*/
    public final static boolean debug=true;
    public final static String NOT_INTERCEPT = "/ztree/**,/css/**,/js/**,/layui/**,/favicon.ico,/**.js.map";

    public final static String errCodeBase="01";
    public final static String errCodeHtml=errCodeBase+"001";
    public final static Map<String,String> errCode=new HashMap<String,String>(){
        {
            put("","");
        }
    };


    public final static Map<String,String> msg=new HashMap<String,String>(){
        {
            put("404","对不起,没有找到您所需要的页面,可能是URL不确定,或者页面已被移除。");
            put("403","服务器拒绝请求，您的权限不足。");
            put("500","服务器遇到错误，无法完成请求");
            put("406","（不接受）无法使用请求的内容特性响应请求的网页。");
        }
    };
}
