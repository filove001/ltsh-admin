package com.ltsh.admin.mvc.sys.dict;
import org.junit.Test;
import com.ltsh.admin.BaseDaoTest;
public class SysDictDaoTest extends BaseDaoTest{
	private SysDictDao dao=sqlManager.getMapper(SysDictDao.class);
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
