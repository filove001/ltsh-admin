package com.ltsh.admin.mvc.sys.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
	@Test
	public void create12(){
		String name="admin";
		SysUser entity=new SysUser();
		entity.setId(1);
		entity.setLoginName(name);
		entity.setPassword(name);
		entity.setName(name);
		entity.setTel(name);
		entity.setPhone(name);
		entity.setAddress(name);
		entity.setEmail(name);
		entity.setIdcard(name);
		entity.setZip(name);
		entity.setStatus(1);
		entity.setSex(1);
		entity.setBirth(new java.util.Date());
		entity.setRemarks(name);
		entity.setCreateBy(name);
		entity.setCreateDate(new java.util.Date());
		entity.setLastLoginTime(new java.util.Date());
		dao.insert(entity);
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
		entity.setIdcard(name+i);
		entity.setZip(name+i);
		entity.setStatus(1);
		entity.setSex(1);
		entity.setBirth(new java.util.Date());
		entity.setRemarks(name+i);
		entity.setCreateBy(name+i);
		entity.setCreateDate(new java.util.Date());
		entity.setLastLoginTime(new java.util.Date());
		return entity;
	}
}
