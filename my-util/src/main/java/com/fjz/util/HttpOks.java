package com.fjz.util;

import com.fjz.util.log.Logs;
import okhttp3.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * http请求工具
 *  到时候参考基于okhttp3的工具类HttpUtils  https://blog.csdn.net/weixin_29135773/article/details/54581937
 *
 * Created by Administrator on 2018/6/24.
 */
public class HttpOks {
    private static OkHttpClient httpClient = new OkHttpClient();
//    private final static OkHttpClient client = new OkHttpClient.Builder()
//            .connectionPool(new ConnectionPool(20, 5, TimeUnit.MINUTES))
//            .readTimeout(20, TimeUnit.SECONDS)
//            .connectTimeout(20, TimeUnit.SECONDS).build();
    public static void main(String[] args) {
        System.out.println(get("https://www.newhealth.com.cn/"));
        System.out.println("================================");
        System.out.println(post("https://www.newhealth.com.cn/"));
    }
    public static String get(String url){
        return get(url, null);
    }
    public static String get(String url,Map<String,String> header){
        Request.Builder builder = new Request.Builder();
        builder
                .url(url)
                .headers(getHeaders(header))
                .get()
                .build();
        return execute(builder);
    }
    public static String get(String url, Map<String, String> params,Map<String,String> header) {
        return get(url+getParams(params),header);
    }
    public static Headers getHeaders(Map<String, String> header) {
        Headers.Builder builder=new Headers.Builder();
        if (Empty.not(header)) {
            for (Map.Entry<String, String> h : header.entrySet()) {
                builder.add(h.getKey(), h.getValue());
            }
        }
        return builder.build();
    }
    public static String getParams(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (!Empty.is(params)) {
            sb.append("?");
            String s="";
            for (String key : params.keySet()) {
                sb.append(s).append(key).append("=").append(params.get(key));
                s="&";
            }
        }
        return sb.toString();
    }
    public static RequestBody getRequestBody(Map<String, String> params){
        FormBody.Builder builder = new FormBody.Builder();
//        RequestBody requestBody
        if(Empty.not(params)){
            params.entrySet().stream().forEach(e->builder.add(e.getKey(),e.getValue()));
//                    .map(entry -> builder.add(entry.getKey(),entry.getValue()));
//                    .collect(Collectors.joining("&"));
        }
        return builder.build();
    }
    public static String post(String url){
        return post(url, null,null);
    }
    public static String post(String url, Map<String, String> params,Map<String,String> header) {
        Request.Builder builder = new Request.Builder();
        builder.url(url)
                .headers(getHeaders(header))
                .post(getRequestBody(params))
                .build();
        return execute(builder);
    }
    public static String postJson(String url, Map<String, String> params) {
        return postJson(url, params, null);
    }
    public static String postJson(String url, Map<String, String> params,Map<String,String> header) {
        return postJson(url, Jsons.toString(params), header);
    }
    public static String postJson(String url, String paramsString) {
        return postJson(url, paramsString, null);
    }
    public static String postJson(String url, String paramsString,Map<String,String> header) {
        Request.Builder builder = new Request.Builder();
        RequestBody body = RequestBody.create(JSON, paramsString);
        builder.url(url)
                .headers(getHeaders(header))
                .post(body)
                .build();
        return execute(builder);
    }
    /**
     * 通用执行方法
     */
    private static String execute(Request.Builder builder){
        String string=null;
        try {
            try (Response response = httpClient.newCall(builder.build()).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                string = response.body().string();
                Logs.info("http execute {}",string);
            }
        } catch (IOException e) {
            Logs.error("http execute error:", e);
        }
        return string;
    }

    /**
     * 通用执行方法
     */
    private static String execute(OkHttp okHttp){
//        if(StringUtils.isBlank(okHttp.requestCharset)){
//            okHttp.requestCharset = DEFAULT_CHARSET;
//        }
//        if(StringUtils.isBlank(okHttp.responseCharset)){
//            okHttp.responseCharset = DEFAULT_CHARSET;
//        }
//        if(StringUtils.isBlank(okHttp.method)){
//            okHttp.method = DEFAULT_METHOD;
//        }
//        if(StringUtils.isBlank(okHttp.mediaType)){
//            okHttp.mediaType = DEFAULT_MEDIA_TYPE;
//        }
//        RequestBody requestBody = new FormBody.Builder()
//                .add("interface",interfaceName)
//                .add("method",method)
//                .add("parameterTypesString",parameterTypesString)
//                .add("parameter",parameter)
//                .build();
        if(okHttp.requestLog){//记录请求日志
            Logs.info(okHttp.toString());
        }

        String url =okHttp.url;

        Request.Builder builder = new Request.Builder();

        if(Empty.not(okHttp.queryMap)){
            String queryParams = okHttp.queryMap.entrySet().stream()
                    .map(entry -> String.format("%s=%s", entry.getKey(), entry.getValue()))
                    .collect(Collectors.joining("&"));
            url = String.format("%s%s%s", url, url.contains("?")?"&":"?", queryParams);
        }
        builder.url(url);

        if(Empty.not(okHttp.headerMap)){
            okHttp.headerMap.forEach(builder::addHeader);
        }

        String method = okHttp.method.toUpperCase();
        String mediaType = String.format("%s;charset=%s", okHttp.mediaType, okHttp.requestCharset);
        if(GET.equals(method)){
            builder.get();
        }else if(Arrays.contains(new String[]{POST, PUT, DELETE, PATCH}, method)){
            RequestBody requestBody = RequestBody.create(MediaType.parse(mediaType), okHttp.data);
            builder.method(method, requestBody);
        }else{
            throw new RuntimeException(String.format("http method:%s not support!", method));
        }
        String result = "";
        try {
            Response response = httpClient.newCall(builder.build()).execute();
            byte[] bytes = response.body().bytes();
            result = new String(bytes, okHttp.responseCharset);
            if (okHttp.responseLog){//记录返回日志
                Logs.info(String.format("Got response->%s",result));
            }
        }catch (Exception e){
            Logs.error(okHttp.toString(), e);
        }
        return result;
    }



    public final static String GET = "GET";
    public final static String POST = "POST";
    public final static String PUT = "PUT";
    public final static String DELETE = "DELETE";
    public final static String PATCH = "PATCH";
    private final static String UTF8 = "UTF-8";
    private final static String GBK = "GBK";
    private final static String DEFAULT_CHARSET = UTF8;
    private final static String DEFAULT_METHOD = GET;
    public static final MediaType MIXED = MediaType.parse("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.parse("multipart/alternative");
    public static final MediaType DIGEST = MediaType.parse("multipart/digest");
    public static final MediaType PARALLEL = MediaType.parse("multipart/parallel");
    public static final MediaType FORM = MediaType.parse("multipart/form-data");
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

//    private final static String DEFAULT_MEDIA_TYPE = FORM;
    private final static boolean DEFAULT_LOG = false;
    static class OkHttp{
        private String url;
        private String method = DEFAULT_METHOD;
        private String data;
        private MediaType mediaType = FORM;
        private Map<String, String> queryMap;
        private Map<String, String> headerMap;
        private String requestCharset = DEFAULT_CHARSET;
        private boolean requestLog = DEFAULT_LOG;
        private String responseCharset = DEFAULT_CHARSET;
        private boolean responseLog = DEFAULT_LOG;
    }
}
