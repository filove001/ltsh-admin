package study.jar;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.classfile.Constant;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fengjianzhong on 2017/11/26.
 */
public class JsoupTest {
    @Test
    public void baidu() throws IOException {
        Document doc=Jsoup.connect("https://www.baidu.com/s?wd=海马的功效与作用").get();
        Elements es=doc.getElementById("page").select("a");
        for (Element e:es) {
            String href=e.attr("href");
            System.out.println(href);
        }
        System.out.println(doc.body());
    }
    @Test
    public void toutiao() throws IOException {
//        Document doc=Jsoup.connect("https://www.toutiao.com/search_content/?offset=40&format=json&keyword=%E6%B5%B7%E9%A9%AC%E7%9A%84%E4%BD%9C%E7%94%A8&autoload=true&count=20&cur_tab=1&from=search_tab").get();
        Connection.Response res = Jsoup.connect("https://www.toutiao.com/search_content/?offset=0&format=json&keyword=海马的功效与作用&autoload=true&count=20&cur_tab=1&from=search_tab")//.connect(Constant.DATA_URL)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                .timeout(10000).ignoreContentType(true).execute();//.get();
        String body = res.body();
        System.out.println(JSON.parse(body));
        res = Jsoup.connect("https://www.toutiao.com/search_content/?offset=19&format=json&keyword=海马的功效与作用&autoload=true&count=20&cur_tab=2&from=search_tab")//.connect(Constant.DATA_URL)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                .timeout(10000).ignoreContentType(true).execute();//.get();
        body = res.body();
        System.out.println(JSON.parse(body));
    }
    public static void main(String[] args) throws IOException {
		Document doc=Jsoup.connect("https://www.toutiao.com/group/6490308145171137037/").get();
        System.out.println(doc.body());
//		Elements es=doc.select("dd a");
//        System.out.println(getTextByUrl("https://www.qidian.com/search?kw="+"好莱坞 ","li[data-rid]"));
//        getBookMl("https://www.qidian.com/search?kw=" + "好莱坞 ", ".book-img-text li[data-rid]");
    }

    //主网页   书本详情  目录 具体书本
    public static List<String> getText(String html, String select){
        Document doc=Jsoup.parse(html);
        return getText(doc,select);
    }
    public static List<String> getTextByUrl(String url, String select) throws IOException {
        Document doc=Jsoup.connect(url).get();
        return getText(doc,select);
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
    public static void getBookMl(String url,String select) throws IOException{
        Document doc=Jsoup.connect(url).get();
        Elements es=doc.select(select);
        for (Element element : es) {
            System.out.println(element);
        }
    }
}
