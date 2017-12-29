package study.jar.ui4j;

import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;
import io.webfolder.ui4j.api.browser.BrowserType;
import io.webfolder.ui4j.api.browser.Page;
import io.webfolder.ui4j.api.dom.Document;
import io.webfolder.ui4j.api.dom.Element;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjianzhong on 2017/12/28.
 */
public class ToutiaoSearch {
    private static BrowserEngine browser=  BrowserFactory.getBrowser(BrowserType.WebKit);//BrowserFactory.getWebKit();
    private static String baseUrl = "https://www.toutiao.com/";
    private static String searchUrl = baseUrl+"search/?keyword=";
    private String keyword;
    private  Page page;
    private Document doc;
    private String searchKeywordUrl;
    private List<Element> list=new ArrayList<>();
    private int pageNumber=1;//第一页
    public ToutiaoSearch(String keyword) {
        this.keyword = keyword;
        searchKeywordUrl = searchUrl + keyword;
        page = browser.navigate(searchKeywordUrl);
        doc = page.getDocument();
        addElement();
    }
    public void addElement(){
        this.list.addAll(getElement(".result.c-container"));
    }
    public  List<Element> getElement(String select){
        List<Element> list=doc.queryAll(select);
       return list;
    }
    public List<Element> getList() {
        return list;
    }
    public void println(){
        for (Element e:list) {
            System.out.println(e.find("a[data-click]"));
        }
    }
    public void setList(List<Element> list) {
        this.list = list;
    }

    public static void main(String[] args) throws InterruptedException {
        ToutiaoSearch toutiaoSearch=new ToutiaoSearch("海马的功效与作用");
        System.out.println(toutiaoSearch.page.getView().getClass());
        WebView webView = (WebView)toutiaoSearch.page.getView();
//        webView.get
        toutiaoSearch.page.show();
//        webView.getEngine();
//        baidu.page.show();
//        Thread.sleep(10000);
    }
}
