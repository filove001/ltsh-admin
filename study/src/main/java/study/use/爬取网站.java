package study.use;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ThreadUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/6/3.
 */
public class 爬取网站 {
    //cidian  www.hydcd.com 词语
    @Test
    public void hydcd() throws IOException, InterruptedException {
        char a='a';
        int i=(int)a;
        for (int i1 = i; i1 < i+26; i1++) {
            System.out.println((char) i1);
            Thread.sleep(100);
            Document document = null;
            try {
                document = Jsoup.connect("http://www.hydcd.com/cidian/index_"+(char) i1+".htm").get();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            Elements select = document.select("#table1 td a");
            StringBuilder stringBuilder = new StringBuilder();
            for (Element element : select) {
                stringBuilder.append(element.text()).append("\n");
//            System.out.println(element.text());
            }
            FileUtils.writeByteArrayToFile(new File("E:\\汉字\\www.hydcd.com.txt"),stringBuilder.toString().getBytes(),true);
        }
//        FileUtils.writeByteArrayToFile(new File("E:\\汉字\\www.hydcd.com.txt"),"123".getBytes(),true);
//        Files.newWriter()
//        System.out.println(document.select(""));
    }
    @Test
    public void 对比(){

    }
}
