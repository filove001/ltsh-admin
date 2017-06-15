package com.ltsh.admin.mvc.cms.article.data;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsArticleDataDaoTest{
	@Autowired
	private CmsArticleDataDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		CmsArticleData entity=create(" CmsArticleData",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public CmsArticleData create(String name,int i){
		CmsArticleData entity=new CmsArticleData();
		entity.setId(1);
		entity.setContent(name+i);
		entity.setCopyfrom(name+i);
		entity.setRelation(name+i);
		return entity;
		}
}
