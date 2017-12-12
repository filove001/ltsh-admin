package com.ltsh.admin.mvc.cms.category;
import org.junit.Test;
import com.ltsh.admin.BaseDaoTest;
public class CmsCategoryDaoTest extends BaseDaoTest{
	private CmsCategoryDao dao=sqlManager.getMapper(CmsCategoryDao.class);
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		CmsCategory entity=create(" CmsCategory",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public CmsCategory create(String name,int i){
		CmsCategory entity=new CmsCategory();
		entity.setId(1);
		entity.setParentId(1);
		entity.setName(name+i);
		entity.setPath(name+i);
		entity.setContent(name+i);
		entity.setSort(1);
		entity.setStatus(1);
		entity.setType(1);
		entity.setHref(name+i);
		entity.setMaterialType(1);
		entity.setSiteId(1);
		entity.setSeoTitle(name+i);
		entity.setSeoKeywords(name+i);
		entity.setSeoDescription(name+i);
		entity.setUpdateTime(new java.util.Date());
		entity.setUpdateBy(1);
		entity.setCreateTime(new java.util.Date());
		entity.setCreateBy(1);
		return entity;
		}
}
