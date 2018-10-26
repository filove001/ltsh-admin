package com.ltsh.admin.mvc.sys.role;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
import com.ltsh.admin.mvc.sys.user.role.SysUserRole;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import java.util.List;

public interface SysRoleDao extends BaseDaoMapper<SysRole>{
	public void page(PageQuery<SysRole> query);
	@Sql(value=" select * from "+ SysRole.tableName+" role inner join " + SysUserRole.tableName + " user_role on role.id=user_role.role_id where user_role.user_id=?")
	public List<SysRole> getRoleByUserId(Integer userId);
}
