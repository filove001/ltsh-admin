package study.jar.ui4j;

import com.fjz.util.Lists;
import io.webfolder.ui4j.api.browser.*;
import io.webfolder.ui4j.api.dom.Document;
import io.webfolder.ui4j.api.dom.Element;
import io.webfolder.ui4j.api.interceptor.Interceptor;
import io.webfolder.ui4j.api.interceptor.Request;
import io.webfolder.ui4j.api.interceptor.Response;
import javafx.scene.web.WebEngine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by fengjianzhong on 2017/12/28.
 */
public class BaiduSearch {
    private static BrowserEngine browser=  BrowserFactory.getBrowser(BrowserType.WebKit);//BrowserFactory.getWebKit();
    private static String baseUrl = "https://www.baidu.com/";
    private static String searchUrl = baseUrl+"s?wd=";
    private String keyword;
    private  Page page;
    private Document doc;
    private String searchKeywordUrl;
    private List<Element> list=new ArrayList<>();
    private int pageNumber=1;//第一页
    public BaiduSearch(String keyword) {
        this.keyword = keyword;
        searchKeywordUrl = searchUrl + keyword;
        page = browser.navigate(searchKeywordUrl);
        doc = page.getDocument();
        addElement();
    }
    public BaiduSearch next(){
        //点击按钮是ajax，这个暂时监控不到会延时，所以要停止一下
        doc.query("#page a.n").get().click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pageNumber++;
        addElement();
        return this;
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
        BaiduSearch baidu=new BaiduSearch("海马的功效与作用");
        baidu.doc.queryAll("h3 a[data-click]").get(0).click();
        List<Element> tagEs=null;
        for (Element e : baidu.doc.getBody().getChildren()) {
            List<Element> ee = e.queryAll("p");
            if(tagEs==null||tagEs.size()<ee.size()){
                tagEs=ee;
            }
        }
        for (Element e:tagEs
             ) {
            System.out.println(e.getInnerHTML());
        }
//        System.out.println();
//        ((WebEngine)baidu.page.getEngine()).getLoadWorker().stateProperty().addListener();


//                this.engine.getEngine().getLoadWorker().stateProperty().addListener(loadListener);
//        System.out.println(baidu.doc.getBody());
//        for (Element e : baidu.list) {
//            e.click();
//        }
    }
}
