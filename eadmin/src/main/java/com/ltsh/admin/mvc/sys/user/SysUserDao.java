package com.ltsh.admin.mvc.sys.user;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface SysUserDao extends BaseDaoMapper<SysUser>{
	public void page(PageQuery query);
	
	@Sql(value=" select * from "+SysUser.tableName+" where login_name=?",returnType=SysUser.class)
	public SysUser getByUsername(String  username);
	
	@Sql(value=" select max(id) from "+SysUser.tableName,returnType=long.class)
	public Long getMaxId();
	
	public SysUserBo getBoByUserId(@Param("id") Long id);
}
