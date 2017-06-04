package com.ltsh.admin.mvc.sys.log;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogDaoTest{
	@Autowired
	private SysLogDao dao;
	@Test
	public void testInsertT() {
		for (int i = 0; i < 100; i++) {
		SysLog entity=create(" SysLog",i);
			dao.insert(entity);
		}
		System.out.println(dao.allCount());
	}
	public SysLog create(String name,int i){
		SysLog entity=new SysLog();
		entity.setId(new Long(i));
		entity.setType(name+i);
		entity.setTitle(name+i);
		entity.setUserName(name+i);
		entity.setUserId(name+i);
		entity.setCreateDate(new java.util.Date());
		entity.setRemoteAddr(name+i);
		entity.setUserAgent(name+i);
		entity.setRequestUri(name+i);
		entity.setMethod(name+i);
		entity.setParams(name+i);
		entity.setPerform(name+i);
		entity.setLongTime(name+i);
		entity.setDesc(name+i);
		return entity;
		}
}
