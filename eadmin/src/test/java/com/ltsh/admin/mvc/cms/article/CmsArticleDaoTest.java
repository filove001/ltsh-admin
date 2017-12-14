package com.ltsh.admin.mvc.cms.article;
import org.junit.Test;
import com.ltsh.admin.BaseDaoTest;
public class CmsArticleDaoTest extends BaseDaoTest{
	private CmsArticleDao dao=sqlManager.getMapper(CmsArticleDao.class);
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
		entity.setStatus("显示");
		entity.setIsComment("是");
		entity.setIsRecommend("是");
		entity.setSiteId(1);
		entity.setSeoTitle(name+i);
		entity.setSeoKeywords(name+i);
		entity.setSeoDescription(name+i);
		entity.setSort(1);
		entity.setHref(name+i);
		entity.setImageUrl(name+i);
		entity.setFileUrl(name+i);
		entity.setFileName(name+i);
		entity.setApproveStatus(1);
		entity.setStartTime(new java.util.Date());
		entity.setEndTime(new java.util.Date());
		entity.setUpdateBy(1);
		entity.setUpdateTime(new java.util.Date());
		entity.setCreateTime(new java.util.Date());
		entity.setCreateBy(1);
		entity.setRemarks(name+i);
		return entity;
		}
}
