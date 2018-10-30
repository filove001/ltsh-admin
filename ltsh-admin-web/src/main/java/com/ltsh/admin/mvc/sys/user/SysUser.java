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
	private java.lang.Integer id;//主键 
	private java.lang.String loginName;//登录名 
	private java.lang.String password;//密码 
	private java.lang.String salt;//密码加盐 
	private java.lang.String name;//显示名 
	private java.lang.String tel;//电话号码 
	private java.lang.String phone;//手机号码 
	private java.lang.String address;//地址 
	private java.lang.String email;//电子邮件 
	private java.lang.String qq;//qq 
	private java.lang.String weixin;//微信 
	private java.lang.String weibo;//微博 
	private java.lang.String idcard;//身份证 
	private java.lang.String zip;//邮政编码 
	private java.lang.Integer status;//状态 
	private java.lang.Integer sex;//性别 
	@JSONField(format=  Dates.YYYY_MM_DD)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD)
	private java.util.Date birth;//出生日期 
	private java.lang.String remarks;//备注 
	private java.lang.String createBy;//创建者 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date lastLoginTime;//最后登录时间 
	private java.lang.Integer loginCount;//登录次数
	private java.lang.String sessionKey;// 
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：主键 **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setLoginName(java.lang.String loginName){
		this.loginName=loginName;
	}
	/** login_name VARCHAR(50)：登录名 **/
	public java.lang.String getLoginName() {
		return loginName;
	}
	public void setPassword(java.lang.String password){
		this.password=password;
	}
	/** password VARCHAR(32)：密码 **/
	public java.lang.String getPassword() {
		return password;
	}
	public void setSalt(java.lang.String salt){
		this.salt=salt;
	}
	/** salt VARCHAR(64)：密码加盐 **/
	public java.lang.String getSalt() {
		return salt;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR(50)：显示名 **/
	public java.lang.String getName() {
		return name;
	}
	public void setTel(java.lang.String tel){
		this.tel=tel;
	}
	/** tel VARCHAR(50)：电话号码 **/
	public java.lang.String getTel() {
		return tel;
	}
	public void setPhone(java.lang.String phone){
		this.phone=phone;
	}
	/** phone VARCHAR(50)：手机号码 **/
	public java.lang.String getPhone() {
		return phone;
	}
	public void setAddress(java.lang.String address){
		this.address=address;
	}
	/** address VARCHAR(500)：地址 **/
	public java.lang.String getAddress() {
		return address;
	}
	public void setEmail(java.lang.String email){
		this.email=email;
	}
	/** email VARCHAR(50)：电子邮件 **/
	public java.lang.String getEmail() {
		return email;
	}
	public void setQq(java.lang.String qq){
		this.qq=qq;
	}
	/** qq VARCHAR(50)：qq **/
	public java.lang.String getQq() {
		return qq;
	}
	public void setWeixin(java.lang.String weixin){
		this.weixin=weixin;
	}
	/** weixin VARCHAR(50)：微信 **/
	public java.lang.String getWeixin() {
		return weixin;
	}
	public void setWeibo(java.lang.String weibo){
		this.weibo=weibo;
	}
	/** weibo VARCHAR(50)：微博 **/
	public java.lang.String getWeibo() {
		return weibo;
	}
	public void setIdcard(java.lang.String idcard){
		this.idcard=idcard;
	}
	/** idcard VARCHAR(50)：身份证 **/
	public java.lang.String getIdcard() {
		return idcard;
	}
	public void setZip(java.lang.String zip){
		this.zip=zip;
	}
	/** zip VARCHAR(50)：邮政编码 **/
	public java.lang.String getZip() {
		return zip;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	/** status INT(10)：状态 **/
	public java.lang.Integer getStatus() {
		return status;
	}
	public void setSex(java.lang.Integer sex){
		this.sex=sex;
	}
	/** sex INT(10)：性别 **/
	public java.lang.Integer getSex() {
		return sex;
	}
	public void setBirth(java.util.Date birth){
		this.birth=birth;
	}
	/** birth DATE(10)：出生日期 **/
	public java.util.Date getBirth() {
		return birth;
	}
	public void setRemarks(java.lang.String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(255)：备注 **/
	public java.lang.String getRemarks() {
		return remarks;
	}
	public void setCreateBy(java.lang.String createBy){
		this.createBy=createBy;
	}
	/** create_by VARCHAR(64)：创建者 **/
	public java.lang.String getCreateBy() {
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
	public void setLoginCount(java.lang.Integer loginCount){
		this.loginCount=loginCount;
	}
	/** login_count TINYINT(3)：登录次数 **/
	public java.lang.Integer getLoginCount() {
		return loginCount;
	}
	public void setSessionKey(java.lang.String sessionKey){
		this.sessionKey=sessionKey;
	}
	/** session_key VARCHAR(100)： **/
	public java.lang.String getSessionKey() {
		return sessionKey;
	}

}
