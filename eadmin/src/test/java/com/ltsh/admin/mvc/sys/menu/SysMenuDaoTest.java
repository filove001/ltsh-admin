package com.ltsh.admin.mvc.sys.menu;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuDaoTest{
	@Autowired
	private SysMenuDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		SysMenu entity=create(" SysMenu",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public SysMenu create(String name,int i){
		SysMenu entity=new SysMenu();
		entity.setId(1);
		entity.setParentId(1);
		entity.setParentIds(name+i);
		entity.setLevel(1);
		entity.setType(1);
		entity.setName(name+i);
		entity.setSort(1);
		entity.setHref(name+i);
		entity.setTarget(name+i);
		entity.setIcon(name+i);
		entity.setPermission(name+i);
		entity.setStatus(1);
		entity.setCreateBy(name+i);
		entity.setCreateDate(new java.util.Date());
		entity.setUpdateBy(name+i);
		entity.setUpdateDate(new java.util.Date());
		entity.setRemarks(name+i);
		return entity;
		}
}
