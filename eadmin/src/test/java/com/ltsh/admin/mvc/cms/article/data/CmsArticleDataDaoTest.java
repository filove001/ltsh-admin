package com.ltsh.admin.mvc.cms.article.data;
import org.junit.Test;
import com.ltsh.admin.BaseDaoTest;
public class CmsArticleDataDaoTest extends BaseDaoTest{
	private CmsArticleDataDao dao=sqlManager.getMapper(CmsArticleDataDao.class);
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
