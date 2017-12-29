package study.jar.jsoup;

import com.fjz.util.Empty;
import com.fjz.util.Jsons;
import com.fjz.util.Maps;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import study.jar.ToutiaoSearchBean;

import java.io.IOException;
import java.util.Map;

/**
 * Created by fengjianzhong on 2017/12/29.
 */
public class Jsoups {
    /**
     * 获取json字符串
     * @param url
     * @return
     * @throws IOException
     */
    public static String getJson(String url) throws IOException {
        Connection.Response res = Jsoup.connect(url)//.connect(Constant.DATA_URL)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                .timeout(10000).ignoreContentType(true).execute();
        String body = res.body();
        return body;
    }

    /**
     * 获取json对象
     * @param url
     * @param tClass
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T>T getJson(String url,Class<T> tClass) throws IOException {
        String body = getJson(url);
        return Jsons.parseObject(body,tClass);
    }
    public static String get(String url) throws IOException {
        Document doc=Jsoup.connect(url).get();
        return doc.html();
    }
    public static Elements get(String url, String select) throws IOException {
        Document doc=Jsoup.connect(url).get();
        return doc.select(select);
    }
    public static Map<String, Element> foreach(Elements es){
        if(Empty.is(es))
            return null;
        Map<String, Element> m = Maps.newMap();
        for (Element e:es) {
            m.putAll(foreach(e.children()));
        }
        return m;
    }
    public static String getBodyChildrenTagMaxStringByUrl(String url,String tag) throws IOException {
        Document doc=Jsoup.connect(url).get();
        return getBodyChildrenTagMaxString(doc,tag);
    }

    /**
     * 获取body 子标签下某标签=tag 最多的标签
     * @param doc
     * @param tag
     * @return
     */
    public static String getBodyChildrenTagMaxString(Document doc,String tag){
        Elements es=doc.body().children();
        Elements tagEs=null;
        for (Element e:es) {
            Elements ee = e.select(tag);
            if(tagEs==null||tagEs.size()<ee.size()){
                tagEs=ee;
            }
        }
        return tagEs.toString();
    }
    public static String getBodyChildrenTagMaxString(String html,String tag){
        Document doc=Jsoup.parse(html);
        return getBodyChildrenTagMaxString(doc,tag);
    }
    public static void main(String[] args) throws IOException {
        System.out.println(getBodyChildrenTagMaxStringByUrl("http://www.39yst.com/yishou/308988.shtml","p"));
    }
}
