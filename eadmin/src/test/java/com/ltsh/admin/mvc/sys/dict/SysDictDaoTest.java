package com.ltsh.admin.mvc.sys.dict;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysDictDaoTest{
	@Autowired
	private SysDictDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		SysDict entity=create(" SysDict",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public SysDict create(String name,int i){
		SysDict entity=new SysDict();
		entity.setId(1);
		entity.setDictValue(name+i);
		entity.setDictKey(name+i);
		entity.setType(1);
		entity.setDescription(name+i);
		entity.setSort(1);
		entity.setParentId(1);
		entity.setRemarks(name+i);
		return entity;
		}
}
