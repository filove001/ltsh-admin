package com.ltsh.admin.mvc.sys.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fjz.util.Dates;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserDaoTest{
	@Autowired
	private SysUserDao sysUserDao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
			SysUser user=create("user"+i);
			sysUserDao.insert(user);
		}
		System.out.println(sysUserDao.allCount());
	}
	public SysUser create(String name){
		SysUser user=new SysUser();
		user.setId((int)(Math.random()*100000));
		user.setName(name);
		user.setPassword("11111");
		user.setLoginName(name);
		user.setCreateBy(name);
		user.setCreateDate(new Date());
		user.setPhone("120XXXXXX");
		return user;
	}
}
