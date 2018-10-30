package com.ltsh.admin.mvc.sys.user.role;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserRoleDaoTest{
	@Autowired
	private SysUserRoleDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		SysUserRole entity=create(" SysUserRole",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public SysUserRole create(String name,int i){
		SysUserRole entity=new SysUserRole();
		entity.setUserId(1);
		entity.setRoleId(1);
		return entity;
		}
}
