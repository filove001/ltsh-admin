package com.fjz.gen.insert.rolemenu.model;

import java.io.Serializable;
import java.util.Date;

/**
 *  SYS_USER 用户信息 
 * @author fjz
 */
@SuppressWarnings("serial")
public class SysUser implements Serializable{
	public static final String tableName="sys_user";
	private java.lang.Long id;//用户编号 
	private java.lang.String username;//登录名 
	private java.lang.String name;//真实姓名 
	private java.lang.String password;//密码 
	private java.lang.String salt;//密码加盐 
	private java.lang.String email;//电子邮件 
	private java.lang.String phone;//电话 
	private java.lang.String identityCard;//身份证 
	private java.lang.String type;//用户类型 
	private java.lang.String status;//状态 
	private Date createTime;//创建时间 
	private java.lang.String createBy;//创建人 
	public void setId(java.lang.Long id){
		this.id=id;
	}
	/** id NUMBER(18)：用户编号 **/
	public java.lang.Long getId() {
		return id;
	}
	public void setUsername(java.lang.String username){
		this.username=username;
	}
	/** username VARCHAR2(50)：登录名 **/
	public java.lang.String getUsername() {
		return username;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR2(50)：真实姓名 **/
	public java.lang.String getName() {
		return name;
	}
	public void setPassword(java.lang.String password){
		this.password=password;
	}
	/** password VARCHAR2(100)：密码 **/
	public java.lang.String getPassword() {
		return password;
	}
	public void setSalt(java.lang.String salt){
		this.salt=salt;
	}
	/** salt VARCHAR2(50)：密码加盐 **/
	public java.lang.String getSalt() {
		return salt;
	}
	public void setEmail(java.lang.String email){
		this.email=email;
	}
	/** email VARCHAR2(100)：电子邮件 **/
	public java.lang.String getEmail() {
		return email;
	}
	public void setPhone(java.lang.String phone){
		this.phone=phone;
	}
	/** phone VARCHAR2(50)：电话 **/
	public java.lang.String getPhone() {
		return phone;
	}
	public void setIdentityCard(java.lang.String identityCard){
		this.identityCard=identityCard;
	}
	/** identity_card VARCHAR2(50)：身份证 **/
	public java.lang.String getIdentityCard() {
		return identityCard;
	}
	public void setType(java.lang.String type){
		this.type=type;
	}
	/** type VARCHAR2(50)：用户类型 **/
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
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	/** create_time Date：创建时间 **/
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateBy(java.lang.String createBy){
		this.createBy=createBy;
	}
	/** create_by VARCHAR2(50)：创建人 **/
	public java.lang.String getCreateBy() {
		return createBy;
	}

}
