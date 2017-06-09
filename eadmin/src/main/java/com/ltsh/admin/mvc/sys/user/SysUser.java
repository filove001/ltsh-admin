package com.ltsh.admin.mvc.sys.user;

import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fjz.util.Dates;
/**
 *  sys_user 用户信息 
 * @author fjz
 */
public class SysUser{
	public static final String tableName="sys_user";
	public static final String tableRemarks="用户信息";
	private Integer id;//主键
	private String loginName;//登录名
	private String password;//密码
	private String name;//显示名
	private String tel;//电话号码
	private String phone;//手机号码
	private String address;//地址
	private String email;//电子邮件
	private String idcard;//身份证
	private String zip;//邮政编码
	private Integer status;//状态
	private Integer sex;//性别
	@JSONField(format=  Dates.YYYY_MM_DD)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD)
	private java.util.Date birth;//出生日期 
	private String remarks;//备注
	private String createBy;//创建者
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date lastLoginTime;//最后登录时间 
	private Byte loginCount;//登录次数
	public void setId(Integer id){
		this.id=id;
	}
	/** id INT(10)：主键 **/
	public Integer getId() {
		return id;
	}
	public void setLoginName(String loginName){
		this.loginName=loginName;
	}
	/** login_name VARCHAR(50)：登录名 **/
	public String getLoginName() {
		return loginName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	/** password VARCHAR(32)：密码 **/
	public String getPassword() {
		return password;
	}
	public void setName(String name){
		this.name=name;
	}
	/** name VARCHAR(50)：显示名 **/
	public String getName() {
		return name;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	/** tel VARCHAR(50)：电话号码 **/
	public String getTel() {
		return tel;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	/** phone VARCHAR(50)：手机号码 **/
	public String getPhone() {
		return phone;
	}
	public void setAddress(String address){
		this.address=address;
	}
	/** address VARCHAR(500)：地址 **/
	public String getAddress() {
		return address;
	}
	public void setEmail(String email){
		this.email=email;
	}
	/** email VARCHAR(50)：电子邮件 **/
	public String getEmail() {
		return email;
	}
	public void setIdcard(String idcard){
		this.idcard=idcard;
	}
	/** idcard VARCHAR(50)：身份证 **/
	public String getIdcard() {
		return idcard;
	}
	public void setZip(String zip){
		this.zip=zip;
	}
	/** zip VARCHAR(50)：邮政编码 **/
	public String getZip() {
		return zip;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	/** status INT(10)：状态 **/
	public Integer getStatus() {
		return status;
	}
	public void setSex(Integer sex){
		this.sex=sex;
	}
	/** sex INT(10)：性别 **/
	public Integer getSex() {
		return sex;
	}
	public void setBirth(java.util.Date birth){
		this.birth=birth;
	}
	/** birth DATE(10)：出生日期 **/
	public java.util.Date getBirth() {
		return birth;
	}
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(255)：备注 **/
	public String getRemarks() {
		return remarks;
	}
	public void setCreateBy(String createBy){
		this.createBy=createBy;
	}
	/** create_by VARCHAR(64)：创建者 **/
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate=createDate;
	}
	/** create_date DATETIME(19)：创建时间 **/
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setLastLoginTime(java.util.Date lastLoginTime){
		this.lastLoginTime=lastLoginTime;
	}
	/** last_login_time DATETIME(19)：最后登录时间 **/
	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLoginCount(Byte loginCount){
		this.loginCount=loginCount;
	}
	/** login_count TINYINT(3)：登录次数 **/
	public Byte getLoginCount() {
		return loginCount;
	}

}
