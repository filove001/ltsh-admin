package com.fjz.gen.insert.rolemenu.model;
/**
 *  SYS_ROLE_MENU 角色-菜单 
 * @author fjz
 */
public class SysRoleMenu{
	public static final String tableName="SYS_ROLE_MENU";
	private java.lang.Long sysMenuId;//菜单编号 
	private java.lang.Long sysRoleId;//角色编号 
	public void setSysMenuId(java.lang.Long sysMenuId){
		this.sysMenuId=sysMenuId;
	}
	/** sys_menu_id NUMBER(18)：菜单编号 **/
	public java.lang.Long getSysMenuId() {
		return sysMenuId;
	}
	public void setSysRoleId(java.lang.Long sysRoleId){
		this.sysRoleId=sysRoleId;
	}
	/** sys_role_id NUMBER(18)：角色编号 **/
	public java.lang.Long getSysRoleId() {
		return sysRoleId;
	}

}
