package com.fjz.gen.insert.rolemenu.model;
/**
 *  SYS_MENU 菜单 
 * @author fjz
 */
public class SysMenu{
	public static final String tableName="SYS_MENU";
	private java.lang.Long id;//编号 
	private java.lang.String name;//名称 
	private java.util.Date createTime;//创建时间 
	private java.lang.String status;//状态 
	private java.lang.String type;//菜单类型 
	private java.lang.String remark;//备注 
	private java.lang.Long pid;//父级编号 
	private java.lang.String href;//链接 
	private java.lang.String icon;//图标 
	private java.lang.Integer isShow;//是否显示 
	private java.lang.String permission;//权限标识 
	public void setId(java.lang.Long id){
		this.id=id;
	}
	/** id NUMBER(18)：编号 **/
	public java.lang.Long getId() {
		return id;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR2(50)：名称 **/
	public java.lang.String getName() {
		return name;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	/** create_time DATE(7)：创建时间 **/
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setStatus(java.lang.String status){
		this.status=status;
	}
	/** status VARCHAR2(50)：状态 **/
	public java.lang.String getStatus() {
		return status;
	}
	public void setType(java.lang.String type){
		this.type=type;
	}
	/** type VARCHAR2(50)：菜单类型 **/
	public java.lang.String getType() {
		return type;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	/** remark VARCHAR2(50)：备注 **/
	public java.lang.String getRemark() {
		return remark;
	}
	public void setPid(java.lang.Long pid){
		this.pid=pid;
	}
	/** pid NUMBER(18)：父级编号 **/
	public java.lang.Long getPid() {
		return pid;
	}
	public void setHref(java.lang.String href){
		this.href=href;
	}
	/** href VARCHAR2(1000)：链接 **/
	public java.lang.String getHref() {
		return href;
	}
	public void setIcon(java.lang.String icon){
		this.icon=icon;
	}
	/** icon VARCHAR2(255)：图标 **/
	public java.lang.String getIcon() {
		return icon;
	}
	public void setIsShow(java.lang.Integer isShow){
		this.isShow=isShow;
	}
	/** is_show NUMBER(4)：是否显示 **/
	public java.lang.Integer getIsShow() {
		return isShow;
	}
	public void setPermission(java.lang.String permission){
		this.permission=permission;
	}
	/** permission VARCHAR2(255)：权限标识 **/
	public java.lang.String getPermission() {
		return permission;
	}

}
