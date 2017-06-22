package com.ltsh.admin.mvc.cms.category;
import com.fjz.util.Maps;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsCategoryDaoTest{
	@Autowired
	private CmsCategoryDao dao;

	@Test
	public void testInsertT() {
		Map<String,Object> map= Maps.newMap(new String[]{"index","yinshi","renwen","lvyou","fangchan","haichan"}, new Object[]{"湛江历史","湛江饮食","湛江人文","湛江旅游","湛江房产","湛江海产"});
		for (Map.Entry<String,Object> e: map.entrySet()) {
			CmsCategory entity=create(e.getValue().toString(),e.getKey());
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
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
		entity.setStatus(1);
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
