package com.fjz.util;

import java.util.ArrayList;
import java.util.List;

/**
 * html处理工具类
 * Created by fengjianzhong on 2017/12/11.
 */
public class Htmls {
    /**
     * 获取html对应的sr值
     * @param html
     * @return
     */
    public static List<String> getSrc(String html) {
        List<String> ls = new ArrayList<String>();
        ls.addAll(Regexs.findGroup(Regexs.SRC, html, 1));
        return ls;
    }
    public static List<String> getSrc(List<String> htmls) {
        List<String> ls = new ArrayList<String>();
        for (String html:htmls) {
            ls.addAll(getSrc(html));
        }
        return ls;
    }

    /**
     * 获取html对应的图片地址src
     * @param html
     * @return
     */
    public static List<String> getImgSrc(String html) {
        return getSrc(getImageHtml(html));
    }
    /**
     * 获取html对应的img标签
     * @param html
     * @return
     */
    public static List<String> getImageHtml(String html) {
        List<String> listImgUrl = new ArrayList<String>();
        if(Empty.is(html)){
            return listImgUrl;
        }
        listImgUrl.addAll(Regexs.findGroup(Regexs.IMGURL_REG, html));
        return listImgUrl;
    }
}
