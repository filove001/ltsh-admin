package com.ltsh.admin.mvc.sys.privilege;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysPrivilegeDaoTest{
	@Autowired
	private SysPrivilegeDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		SysPrivilege entity=create(" SysPrivilege",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public SysPrivilege create(String name,int i){
		SysPrivilege entity=new SysPrivilege();
		entity.setId(1);
		entity.setMaster(name+i);
		entity.setMasterValue(name+i);
		entity.setAccess(name+i);
		entity.setAccessValue(name+i);
		entity.setOperation(name+i);
		return entity;
		}
}
