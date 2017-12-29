package study.jar.jsoup;

import com.fjz.util.Jsons;
import org.apache.commons.text.StringEscapeUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import study.jar.ToutiaoSearchBean;

import java.io.IOException;

/**
 * Created by fengjianzhong on 2017/12/28.
 */
public class ToutiaoJsoup {


    public static String get(String url) throws IOException {
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
    public static ToutiaoSearchBean getObj(String url) throws IOException {
        Connection.Response res = Jsoup.connect(url)//.connect(Constant.DATA_URL)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                .timeout(10000).ignoreContentType(true).execute();
        String body = res.body();
        return Jsons.parseObject(body,ToutiaoSearchBean.class);
    }
    public static void main(String[] args) throws IOException {
        String baseUrl="https://www.toutiao.com";
//        ToutiaoSearchBean bean=getObj(baseUrl+"/search_content/?offset=0&format=json&keyword=海马的功效与作用&autoload=true&count=20&cur_tab=1&from=search_tab");
//        for (Map<String,Object> m:bean.getData()) {
//            System.out.println(Jsons.toString(m));
//            if(Empty.not(m.get("item_source_url"))) {
//                String url = m.get("item_source_url").toString();
//                System.out.println(url);
//            }
//        }
        Document doc=Jsoup.connect(baseUrl+"/group/6490308145171137037/").get();
        String body=doc.body().toString();
        String info = body.substring(body.indexOf("articleInfo:"));
        info = info.substring(info.indexOf("{") + 1, info.indexOf("}"));
//        System.out.println(info);
//        Document d=Jsoup.parse(info);
        System.out.println(StringEscapeUtils.unescapeHtml4(info));

    }
}
