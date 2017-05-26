package com.ltsh.admin.mvc.sys.user;

import java.io.Serializable;
import java.util.Date;


/**
 *  SYS_USER 用户信息 bo
 * @author fjz
 */
@SuppressWarnings("serial")
public class SysUserBo implements Serializable{
	private java.lang.Long id;//用户编号 
	private java.lang.String username;//登录名 
	private java.lang.String name;//真实姓名 
	private java.lang.String email;//电子邮件 
	private java.lang.String phone;//电话 
	private java.lang.String identityCard;//身份证 
	private java.lang.String type;//用户类型 
	private java.lang.String status;//状态 
	private Date createTime;//创建时间 
	private java.lang.String createBy;//创建人 
	/**下面是用户详细信息 **/
	private java.lang.String sex;//性别 
	private java.lang.String photoUrl;//图片 
	private java.lang.String occupation;//职业 
	private java.lang.String nativePlace;//籍贯 
	private java.lang.String provinceCode;//居住地省行政码 
	private java.lang.String cityCode;//市行政码 
	private java.lang.String countryCode;//县行政码 
	private java.lang.String address;//详细地址 
	private java.util.Date birthday;//出生日期 
	private java.lang.String maritalStatus;//婚姻情况 
	private java.lang.String unitInfo;//单位信息 
	

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
	/** create_time VARCHAR2(50)：创建时间 **/
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
	public void setSex(java.lang.String sex){
		this.sex=sex;
	}
	/** sex CHAR(1)：性别 **/
	public java.lang.String getSex() {
		return sex;
	}
	public void setPhotoUrl(java.lang.String photoUrl){
		this.photoUrl=photoUrl;
	}
	/** photo_url VARCHAR2(1000)：图片 **/
	public java.lang.String getPhotoUrl() {
		return photoUrl;
	}
	public void setOccupation(java.lang.String occupation){
		this.occupation=occupation;
	}
	/** occupation VARCHAR2(50)：职业 **/
	public java.lang.String getOccupation() {
		return occupation;
	}
	public void setNativePlace(java.lang.String nativePlace){
		this.nativePlace=nativePlace;
	}
	/** native_place VARCHAR2(50)：籍贯 **/
	public java.lang.String getNativePlace() {
		return nativePlace;
	}
	public void setProvinceCode(java.lang.String provinceCode){
		this.provinceCode=provinceCode;
	}
	/** province_code VARCHAR2(50)：居住地省行政码 **/
	public java.lang.String getProvinceCode() {
		return provinceCode;
	}
	public void setCityCode(java.lang.String cityCode){
		this.cityCode=cityCode;
	}
	/** city_code VARCHAR2(50)：市行政码 **/
	public java.lang.String getCityCode() {
		return cityCode;
	}
	public void setCountryCode(java.lang.String countryCode){
		this.countryCode=countryCode;
	}
	/** country_code VARCHAR2(50)：县行政码 **/
	public java.lang.String getCountryCode() {
		return countryCode;
	}
	public void setAddress(java.lang.String address){
		this.address=address;
	}
	/** address VARCHAR2(1000)：详细地址 **/
	public java.lang.String getAddress() {
		return address;
	}
	public void setBirthday(java.util.Date birthday){
		this.birthday=birthday;
	}
	/** birthday DATE(7)：出生日期 **/
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setMaritalStatus(java.lang.String maritalStatus){
		this.maritalStatus=maritalStatus;
	}
	/** marital_status VARCHAR2(10)：婚姻情况 **/
	public java.lang.String getMaritalStatus() {
		return maritalStatus;
	}
	public void setUnitInfo(java.lang.String unitInfo){
		this.unitInfo=unitInfo;
	}
	/** unit_info VARCHAR2(100)：单位信息 **/
	public java.lang.String getUnitInfo() {
		return unitInfo;
	}
}
