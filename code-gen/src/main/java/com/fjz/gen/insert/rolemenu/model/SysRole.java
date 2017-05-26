package com.fjz.gen.insert.rolemenu.model;
/**
 *  SYS_ROLE 角色 
 * @author fjz
 */
public class SysRole{
	public static final String tableName="SYS_ROLE";
	private java.lang.Long id;//角色编号 
	private java.lang.String name;//名称 
	private java.util.Date createTime;//创建时间 
	private java.lang.String status;//状态 
	private java.lang.String type;//角色类型 
	private java.lang.String remark;//备注 
	public void setId(java.lang.Long id){
		this.id=id;
	}
	/** id NUMBER(18)：角色编号 **/
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
	/** type VARCHAR2(50)：角色类型 **/
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

}
