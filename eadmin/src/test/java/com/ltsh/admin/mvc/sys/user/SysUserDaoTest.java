package com.ltsh.admin.mvc.sys.user;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserDaoTest{
	@Autowired
	private SysUserDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		SysUser entity=create(" SysUser",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public SysUser create(String name,int i){
		SysUser entity=new SysUser();
		entity.setId(1);
		entity.setLoginName(name+i);
		entity.setPassword(name+i);
		entity.setName(name+i);
		entity.setTel(name+i);
		entity.setPhone(name+i);
		entity.setAddress(name+i);
		entity.setEmail(name+i);
		entity.setQq(name+i);
		entity.setWeixin(name+i);
		entity.setWeibo(name+i);
		entity.setIdcard(name+i);
		entity.setZip(name+i);
		entity.setStatus(1);
		entity.setSex(1);
		entity.setBirth(new java.util.Date());
		entity.setRemarks(name+i);
		entity.setCreateBy(name+i);
		entity.setCreateDate(new java.util.Date());
		entity.setLastLoginTime(new java.util.Date());
		entity.setSessionKey(name+i);
		return entity;
		}
}
