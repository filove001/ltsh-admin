package com.ltsh.admin.mvc.sys.user;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fjz.util.Assert;
import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 用户信息 service
 */
//@CacheConfig(cacheNames = "userCache")
@Service
@CacheConfig(cacheNames = "userCache")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService{
	@Autowired
	private SysUserDao sysUserDao;
	@Override
	public BaseMapper<SysUser> getDao(){
		return sysUserDao;
	}
	@Override
	@Cacheable
	public SysUser getByUsername(String username) {
		System.out.println("username="+username);
		return sysUserDao.getByUsername(username);
	}
	@Override
//	@Cacheable(key="#query.pageNumber")
	public PageQuery<SysUser> page(PageQuery<SysUser> query) {
		sysUserDao.page(query);
		return query;
	}
	@Override
	public SysUser checkLogin(String username, String password) {
		SysUser user=getByUsername(username);
    	Assert.notNull(user, "登录名["+username+"]不存在！");
//    	boolean success=Passwords.validatePassword(password,user.getPassword());
//    	Assert.isTrue(success, "登录名或者密码不准确，请重试！");
    	return user;
	}
	@Override
	public SysUserBo getBoByUserId(Long id) {
		return sysUserDao.getBoByUserId(id);
	}
}
