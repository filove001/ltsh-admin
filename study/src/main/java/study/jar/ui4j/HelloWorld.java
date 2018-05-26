package study.jar.ui4j;

import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;
import io.webfolder.ui4j.api.browser.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fengjianzhong on 2017/12/28.
 */
public class HelloWorld {
    public static void main(String[] args) {
        // get the instance of the webkit
//        BrowserEngine browser = BrowserFactory.getWebKit();
//
//        // navigate to blank page
//        Page page = browser.navigate("about:blank");
//
//        // show the browser page
//        page.show();
//
//        // append html header to the document body
//        page.getDocument().getBody().append("<h1>Hello, World!</h1>");
        BrowserEngine browser = BrowserFactory.getWebKit();

        // navigate to blank page
        Page page = browser.navigate("https://www.newhealth.com.cn/");
        System.out.println( page.getDocument());
        page.show();
    }
    @Test
    public void newhealth(){
        BrowserEngine browser = BrowserFactory.getWebKit();

        // navigate to blank page
        Page page = browser.navigate("https://www.newhealth.com.cn/");
        System.out.println( page.getDocument());
        page.show();
    }
    @Test
    public void hackerNews(){
        try (Page page = BrowserFactory.getWebKit().navigate("https://news.ycombinator.com")) {
            page
                    .getDocument()
                    .queryAll(".title a")
                    .forEach(e -> {
                        System.out.println(e.getText().get());
                    });
        }
    }
}
