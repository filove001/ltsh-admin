package study.jar.ui4j;

import com.fjz.util.Lists;
import io.webfolder.ui4j.api.browser.*;
import io.webfolder.ui4j.api.dom.Document;
import io.webfolder.ui4j.api.dom.Element;
import io.webfolder.ui4j.api.interceptor.Interceptor;
import io.webfolder.ui4j.api.interceptor.Request;
import io.webfolder.ui4j.api.interceptor.Response;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fengjianzhong on 2017/12/28.
 */
public class Ui4jBaidu {
    private BrowserEngine browser=  BrowserFactory.getBrowser(BrowserType.WebKit);//BrowserFactory.getWebKit();
    public static void main(String[] args) {
        // get the instance of the webkit
        BrowserEngine browser = BrowserFactory.getWebKit();

        // navigate to blank page
        Page page = browser.navigate("https://www.baidu.com/s?wd=海马的功效与作用");

        // show the browser page
        page.show();

        // append html header to the document body
//        page.getDocument().getBody().append("<h1>Hello, World!</h1>");
    }
    @Test
    public void test11(){
        Lists.as("1","2").stream().filter(e->{
            return "1".equals(1);
        }).forEach(e->{
            System.out.println(e);
        });
    }
    @Test
    public void test() throws InterruptedException {
        Page page = browser.navigate("https://www.baidu.com/s?wd=DOMSubtreeModified");
        Document doc = page.getDocument();
        System.out.println("=============="+pageNumber+"==============");
        System.out.println(page.getWindow().getLocation());
        System.out.println(doc.queryAll(".result.c-container").size());
        System.out.println(doc.queryAll(".result.c-container").get(0).getText());
//        doc.queryAll(".c-showurl").forEach(e->{
//            System.out.println(e.getText().get());
//        });
//        doc.queryAll("#page a").stream().filter(e->e.getText().get().equals("2"))
//                .forEach(e->{
////            System.out.println(e.getAttribute("href").get());
//            Element a=e.click();
//            System.out.println(a.getInnerHTML());
//            System.out.println("=============");
//            System.out.println(a.getOuterHTML());
//            System.out.println("==============");
////            System.out.println(page.getDocument().queryAll("a[data-click]").get(0).getText());
////            next("https://www.baidu.com"+e.getAttribute("href").get(),++pageNumber);
//        });
//        System.out.println(doc.queryAll("#page a").get(0).getText());
//        System.out.println(doc.queryAll("#page a").get(0).getClass());
//        doc.queryAll("#page a.n").get(0).click();
//        System.out.println(page.getWindow().getLocation());
        Thread.sleep(1000);
//        System.out.println(page.getWindow().getLocation());
        System.out.println(doc.queryAll("a[data-click]").get(0).getText());
        System.out.println();
//        doc.queryAll()
//        page.show();
    }
    public static int pageNumber=1;
    public void next(String url,int pageNumber){
        System.out.println("=============="+pageNumber+"==============");
        Page page = browser.navigate(url);
        page.getDocument().queryAll(".c-showurl").forEach(e->{
            System.out.println(e.getText().get());
        });
    }

}
