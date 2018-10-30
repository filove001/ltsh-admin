package com.ltsh.admin;

import com.fjz.util.Jsons;
import com.ltsh.admin.mvc.base.BaseService;
import com.ltsh.admin.mvc.cms.article.CmsArticle;
import com.ltsh.admin.mvc.cms.article.CmsArticleDao;
import com.ltsh.admin.mvc.cms.article.CmsArticleServiceImpl;
import org.beetl.sql.core.engine.PageQuery;
import org.junit.Test;
import org.springframework.web.util.HtmlUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
    protected Class getPageType(Type type, Class defaultClass) {
        if(type instanceof Class) {
            return defaultClass;
        } else {
            Type t = ((ParameterizedType)type).getActualTypeArguments()[0];
            return t instanceof ParameterizedType?null:(Class)t;
        }
    }
    @Test
    public void img1() throws NoSuchMethodException {//
        BaseService<CmsArticle> service = new CmsArticleServiceImpl();
        PageQuery<CmsArticle> p=new PageQuery();

        System.out.println(getPageType(service.getClass().getMethod("page",PageQuery.class).getGenericParameterTypes()[0],CmsArticle.class));
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
