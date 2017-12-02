package com.ltsh.admin.mvc.cms.article;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsArticleDaoTest{
	@Autowired
	private CmsArticleDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		CmsArticle entity=create(" CmsArticle",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public CmsArticle create(String name,int i){
		CmsArticle entity=new CmsArticle();
		entity.setId(1);
		entity.setCategoryId(1);
		entity.setTitle(name+i);
		entity.setContent(name+i);
		entity.setCountView(1);
		entity.setCountComment(1);
		entity.setStatus(name+i);
		entity.setIsComment(1);
		entity.setIsRecommend(1);
		entity.setSort(1);
		entity.setHref(name+i);
		entity.setImageUrl(name+i);
		entity.setFileUrl(name+i);
		entity.setFileName(name+i);
		entity.setApproveStatus(1);
		entity.setStartTime(new java.util.Date());
		entity.setEndTime(new java.util.Date());
		entity.setUpdateBy(name+i);
		entity.setUpdateTime(new java.util.Date());
		entity.setCreateTime(new java.util.Date());
		entity.setCreateBy(1);
		entity.setRemarks(name+i);
		return entity;
		}
}