package com.ltsh.admin.util;

import com.fjz.util.Regexs;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjianzhong on 2017/12/1.
 */
public class Jsoups {

    //主网页   书本详情  目录 具体书本
    public static List<String> getText(String html, String select){
        Document doc= Jsoup.parse(html);
        return getText(doc,select);
    }

    /**
     *
     * @param doc       html对象
     * @param select    选择器
     * @param regexs    正则选择
     * @return
     */
    public static String getTextByOne(Document doc, String select,String regexs){
        List<String> list=getText(doc,select);
        if(list.isEmpty()){
            throw new RuntimeException("找到为空是错误的，请查看选择器是否错误！");
        }
        return Regexs.findGroupIndexByOne(regexs, list.get(0));
    }
    public static String getTextByOne(Document doc, String select){
        List<String> list=getText(doc,select);
        if(list.isEmpty()){
            throw new RuntimeException("找到为空是错误的，请查看选择器是否错误！");
        }
        return list.get(0);
    }

    //主网页   书本详情  目录 具体书本
    public static List<String> getText(Document doc, String select){
        Elements es=doc.select(select);
        List<String> list=new ArrayList<String>();
        for (Element element : es) {
            list.add(element.toString());
        }
        return list;
    }
}
