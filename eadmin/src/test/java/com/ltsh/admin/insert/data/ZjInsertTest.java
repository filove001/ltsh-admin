package com.ltsh.admin.insert.data;

import com.fjz.util.Empty;
import com.fjz.util.Htmls;
import com.fjz.util.Maps;
import com.ltsh.admin.BaseDaoTest;
import com.ltsh.admin.mvc.cms.article.CmsArticle;
import com.ltsh.admin.mvc.cms.article.CmsArticleDao;
import com.ltsh.admin.mvc.cms.article.CmsArticleDaoTest;
import com.ltsh.admin.mvc.cms.category.CmsCategory;
import com.ltsh.admin.mvc.cms.category.CmsCategoryDao;
import com.ltsh.admin.mvc.sys.user.SysUserDao;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 插入湛江数据
 * Created by fengjianzhong on 2017/12/9.
 */
public class ZjInsertTest extends BaseDaoTest {
    private CmsCategoryDao dao=sqlManager.getMapper(CmsCategoryDao.class);
    private CmsArticleDao cmsArticleDao=sqlManager.getMapper(CmsArticleDao.class);
    @Test
    public void testInsertT() {
        Map<String,Object> map= Maps.newMap(new String[]{"index","yinshi","renwen","lvyou","fangchan","haichan"}, new Object[]{"湛江历史","湛江饮食","湛江人文","湛江旅游","湛江房产","湛江海产"});
        String temp="<p><img src=\"/file/2017-12-11/5eb9e29e-0ff8-44b9-b2ca-b0c0519f657e.png\" style=\"max-width:100%;\"><br>佛手是很好吃的东西不要错过了</p>";
        for (Map.Entry<String,Object> e: map.entrySet()) {
            CmsCategory entity=create(e.getValue().toString(),e.getKey());
            dao.insert(entity,true);
            for (int i = 0; i < 100; i++) {//添加文章
                CmsArticle article=new CmsArticleDaoTest().create("文章",i);
                article.setContent(temp);
                article.setImageUrl(getSrc(Htmls.getImgSrc(article.getContent())));//保存html里面含有图片的src);
                article.setCategoryId(entity.getId());
                cmsArticleDao.insert(article);
            }
        }
        System.out.println(dao.allCount());
    }
    private String getSrc(List<String> src){
        if(Empty.is(src)){
            return null;
        }
        return src.get(0);
    }
    public CmsCategory create(String name,String href){
        CmsCategory entity=new CmsCategory();
        entity.setId(1);
        entity.setParentId(0);
        entity.setName(name);
        entity.setPath(name);
        entity.setContent(name);
        entity.setSort(10);
        if("湛江历史".equals(name)){
            entity.setSort(0);
        }
        entity.setStatus("显示");
        entity.setType(1);
        entity.setHref(href);
//		entity.setMaterialType(1);
//		entity.setSiteId(1);
        entity.setSeoTitle(name);
        entity.setSeoKeywords(name);
        entity.setSeoDescription(name);
        entity.setUpdateTime(new java.util.Date());
        entity.setUpdateBy(1);
        entity.setCreateTime(new java.util.Date());
        entity.setCreateBy(1);
        return entity;
    }
}
