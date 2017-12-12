package com.ltsh.admin.mvc.sys.log;
import org.junit.Test;
import com.ltsh.admin.BaseDaoTest;
public class SysLogDaoTest extends BaseDaoTest{
	private SysLogDao dao=sqlManager.getMapper(SysLogDao.class);;
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
		entity.setRemarks(name+i);
		return entity;
		}
}
