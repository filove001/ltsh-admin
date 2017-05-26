package com.fjz.gen.insert.rolemenu.model;
/**
 *  SYS_ROLE_TENANT 角色-租户 
 * @author fjz
 */
public class SysRoleTenant{
	public static final String tableName="SYS_ROLE_TENANT";
	private java.lang.String sysTenantId;//租户编号 
	private java.lang.Long sysRoleId;//角色编号 
	public void setSysTenantId(java.lang.String sysTenantId){
		this.sysTenantId=sysTenantId;
	}
	/** sys_tenant_id VARCHAR2(50)：租户编号 **/
	public java.lang.String getSysTenantId() {
		return sysTenantId;
	}
	public void setSysRoleId(java.lang.Long sysRoleId){
		this.sysRoleId=sysRoleId;
	}
	/** sys_role_id NUMBER(18)：角色编号 **/
	public java.lang.Long getSysRoleId() {
		return sysRoleId;
	}

}
