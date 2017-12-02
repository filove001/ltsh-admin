package study.jar;

import com.fjz.util.Regexs;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fengjianzhong on 2017/11/26.
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
//		Document doc=Jsoup.connect("http://www.dashubao.net/book/20/20048/index.html").get();
//		Elements es=doc.select("dd a");
//		for (Element element : es) {
//			System.out.println(element);
//		}
//		getBookMl("http://www.dashubao.net/book/20/20048/index.html","dd a");
//		getBookMl("http://www.2kxs.com/xiaoshuo/3/3060/","dd a");
//		getBookMl("http://www.x23us.com/html/2/2915/","tr td a");
//        Document doc=Jsoup.connect("https://www.qidian.com/search?kw="+"好莱坞 ").get();
//        System.out.println(doc.body());
        System.out.println(getTextByUrl("https://www.qidian.com/search?kw="+"好莱坞 ","li[data-rid]"));
        getBookMl("https://www.qidian.com/search?kw=" + "好莱坞 ", ".book-img-text li[data-rid]");
//        Document doc=Jsoup.connect("http://m.qu.la/book/16431/").get();
//        System.out.println(getTextByOne(doc,".author"));
//        System.out.println(getTextByOne(doc,".sort"));
//        System.out.println(getTextByOne(doc,".synopsisArea_detail p:eq(3)"));
//        System.out.println(getTextByOne(doc,".synopsisArea_detail p:eq(4)"));
//        System.out.println(Regexs.findGroupIndexByOne("：(.+)",getTextByOne(doc,".synopsisArea_detail p:eq(4)")));
//        System.out.println(Regexs.findGroupIndexByOne("《([^《》]+)》",getTextByOne(doc,".author")));
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
