package com.ltsh.admin;

import com.fjz.util.Jsons;
import com.ltsh.admin.mvc.cms.article.CmsArticle;
import com.ltsh.admin.mvc.cms.article.CmsArticleDao;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fengjianzhong on 2017/12/10.
 */
public class ImgTest extends BaseDaoTest {
    private CmsArticleDao dao=sqlManager.getMapper(CmsArticleDao.class);
    // 获取img标签正则
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // 获取src路径的正则
    private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";

    @Test
    public void img1() {//获取文章前几位图片
//        String temp="<p><img src=2017-12-10/709e699b-fa86-48e6-afec-a77ed62c996a.png /><img src=\"file/2017-12-10/709e699b-fa86-48e6-afec-a77ed62c996a.png\"><img src=\"http://192.168.1.104:8080/file/2017-12-10/709e699b-fa86-48e6-afec-a77ed62c996a.png\" style=\"line-height: 1.5; max-width: 30%;\"><span style=\"line-height: normal;\">111是飞洒</span></p><p><br></p>";
//        List<String> imgSrc = new ArrayList<>();
//        //获取图片标签
//        List<String> imgUrl = getImageUrl(temp);
//        imgSrc.addAll(getImageSrc(imgUrl));
//        System.out.println(Jsons.toString(imgSrc));
        System.out.println(Pattern.compile("").matcher(null));
//        List<String> imgSrc = new ArrayList<>();
//        List<String> imgSrc1 = new ArrayList<>();
//        imgSrc.addAll(imgSrc);
//        System.out.println(imgSrc.size());
    }
    @Test
    public void img(){//获取文章前几位图片
        List<CmsArticle> list=dao.execute("select * from cms_article a where a.content like '%<img%'");

        List<String> imgSrc = new ArrayList<>();
        for (CmsArticle a:list
             ) {
            //获取图片标签
            List<String> imgUrl = getImageUrl(a.getContent());
            //获取图片src地址
//            List<String> imgSrc = ;
            imgSrc.addAll(getImageSrc(imgUrl));
//            System.out.println(a.getTitle());
//            System.out.println(a.getContent());
        }
        System.out.println(Jsons.toString(imgSrc));
    }
    /***
     * 获取ImageUrl地址
     *
     * @param HTML
     * @return
     */
    private static List<String> getImageUrl(String HTML) {
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());
        }
        return listImgUrl;
    }
    /***
     * 获取ImageSrc地址
     *
     * @param listImageUrl
     * @return
     */
    private static List<String> getImageSrc(List<String> listImageUrl) {
        List<String> listImgSrc = new ArrayList<String>();
        for (String image : listImageUrl) {
//            Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
            Matcher matcher = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(image);
            while (matcher.find()) {
                listImgSrc.add(matcher.group(1));
//                listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));
            }
        }
        return listImgSrc;
    }

}
