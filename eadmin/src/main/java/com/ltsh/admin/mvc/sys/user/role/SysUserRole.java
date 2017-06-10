package com.ltsh.admin.mvc.sys.user.role;

/**
 *  sys_user_role 用户角色 
 * @author fjz
 */
public class SysUserRole{
	public static final String tableName="sys_user_role";
	public static final String tableRemarks="用户角色";
	private java.lang.Integer userId;// 
	private java.lang.Integer roleId;// 
	public void setUserId(java.lang.Integer userId){
		this.userId=userId;
	}
	/** user_id INT(10)： **/
	public java.lang.Integer getUserId() {
		return userId;
	}
	public void setRoleId(java.lang.Integer roleId){
		this.roleId=roleId;
	}
	/** role_id INT(10)： **/
	public java.lang.Integer getRoleId() {
		return roleId;
	}

}
