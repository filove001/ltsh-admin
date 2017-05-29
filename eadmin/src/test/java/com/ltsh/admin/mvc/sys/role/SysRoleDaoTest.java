package com.ltsh.admin.mvc.sys.role;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleDaoTest{
	@Autowired
	private SysRoleDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		SysRole entity=create(" SysRole",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public SysRole create(String name,int i){
		SysRole entity=new SysRole();
		entity.setId(1);
		entity.setName(name+i);
		entity.setCode(name+i);
		entity.setStatus(1);
		entity.setCreateBy(name+i);
		entity.setCreateDate(new java.util.Date());
		entity.setUpdateBy(name+i);
		entity.setUpdateDate(new java.util.Date());
		entity.setRemarks(name+i);
		return entity;
		}
}
