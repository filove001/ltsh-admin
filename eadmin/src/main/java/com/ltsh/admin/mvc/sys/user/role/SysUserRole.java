package com.ltsh.admin.mvc.sys.user.role;
import com.fjz.util.Dates;
/**
 *  sys_user_role  
 * @author fjz
 */
public class SysUserRole{
	public static final String tableName="sys_user_role";
	public static final String tableRemarks="";
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
