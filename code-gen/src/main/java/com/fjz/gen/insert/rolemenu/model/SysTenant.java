package com.fjz.gen.insert.rolemenu.model;
/**
 *  SYS_TENANT 租户信息 
 * @author fjz
 */
public class SysTenant{
	public static final String tableName="SYS_TENANT";
	private java.lang.String id;//租户编号 
	private java.lang.Long sysUserId;//用户编号 
	private java.lang.String name;//名字 
	private java.lang.String remark;//备注 
	private java.util.Date createTime;//创建时间 
	private java.lang.String type;//租户类型 
	private java.lang.String status;//状态 
	private java.lang.String pid;//父级租户编号 
	private java.lang.String typeShort;//租户类型简拼 
	private java.lang.String appType;//应用类型 
	public void setId(java.lang.String id){
		this.id=id;
	}
	/** id VARCHAR2(50)：租户编号 **/
	public java.lang.String getId() {
		return id;
	}
	public void setSysUserId(java.lang.Long sysUserId){
		this.sysUserId=sysUserId;
	}
	/** sys_user_id NUMBER(18)：用户编号 **/
	public java.lang.Long getSysUserId() {
		return sysUserId;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR2(50)：名字 **/
	public java.lang.String getName() {
		return name;
	}
	public void setRemark(java.lang.String remark){
		this.remark=remark;
	}
	/** remark VARCHAR2(255)：备注 **/
	public java.lang.String getRemark() {
		return remark;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	/** create_time DATE(7)：创建时间 **/
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setType(java.lang.String type){
		this.type=type;
	}
	/** type VARCHAR2(50)：租户类型 **/
	public java.lang.String getType() {
		return type;
	}
	public void setStatus(java.lang.String status){
		this.status=status;
	}
	/** status VARCHAR2(50)：状态 **/
	public java.lang.String getStatus() {
		return status;
	}
	public void setPid(java.lang.String pid){
		this.pid=pid;
	}
	/** pid VARCHAR2(50)：父级租户编号 **/
	public java.lang.String getPid() {
		return pid;
	}
	public void setTypeShort(java.lang.String typeShort){
		this.typeShort=typeShort;
	}
	/** type_short VARCHAR2(50)：租户类型简拼 **/
	public java.lang.String getTypeShort() {
		return typeShort;
	}
	public void setAppType(java.lang.String appType){
		this.appType=appType;
	}
	/** app_type VARCHAR2(50)：应用类型 **/
	public java.lang.String getAppType() {
		return appType;
	}

}
