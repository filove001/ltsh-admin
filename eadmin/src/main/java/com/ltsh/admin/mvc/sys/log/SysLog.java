package com.ltsh.admin.mvc.sys.log;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjz.util.Dates;
/**
 *  sys_log 日志 
 * @author fjz
 */
public class SysLog{
	public static final String tableName="sys_log";
	public static final String tableRemarks="日志";
	private java.lang.Long id;//编号 
	private java.lang.String type;//日志类型 
	private java.lang.String title;//日志标题 
	private java.lang.String userName;//用户名者 
	private java.lang.String userId;//用户id 
	@JsonFormat(pattern = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	private java.lang.String remoteAddr;//操作IP地址 
	private java.lang.String userAgent;//用户代理 
	private java.lang.String requestUri;//请求URI 
	private java.lang.String method;//操作方式 
	private java.lang.String params;//提交数据 
	private java.lang.String perform;//工作性能 
	private java.lang.String longTime;//请求耗时 
	private java.lang.String remarks;//详细信息 
	public void setId(java.lang.Long id){
		this.id=id;
	}
	/** id BIGINT(19)：编号 **/
	public java.lang.Long getId() {
		return id;
	}
	public void setType(java.lang.String type){
		this.type=type;
	}
	/** type CHAR(1)：日志类型 **/
	public java.lang.String getType() {
		return type;
	}
	public void setTitle(java.lang.String title){
		this.title=title;
	}
	/** title VARCHAR(255)：日志标题 **/
	public java.lang.String getTitle() {
		return title;
	}
	public void setUserName(java.lang.String userName){
		this.userName=userName;
	}
	/** user_name VARCHAR(64)：用户名者 **/
	public java.lang.String getUserName() {
		return userName;
	}
	public void setUserId(java.lang.String userId){
		this.userId=userId;
	}
	/** user_id VARCHAR(64)：用户id **/
	public java.lang.String getUserId() {
		return userId;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate=createDate;
	}
	/** create_date DATETIME(19)：创建时间 **/
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setRemoteAddr(java.lang.String remoteAddr){
		this.remoteAddr=remoteAddr;
	}
	/** remote_addr VARCHAR(255)：操作IP地址 **/
	public java.lang.String getRemoteAddr() {
		return remoteAddr;
	}
	public void setUserAgent(java.lang.String userAgent){
		this.userAgent=userAgent;
	}
	/** user_agent VARCHAR(255)：用户代理 **/
	public java.lang.String getUserAgent() {
		return userAgent;
	}
	public void setRequestUri(java.lang.String requestUri){
		this.requestUri=requestUri;
	}
	/** request_uri VARCHAR(255)：请求URI **/
	public java.lang.String getRequestUri() {
		return requestUri;
	}
	public void setMethod(java.lang.String method){
		this.method=method;
	}
	/** method VARCHAR(5)：操作方式 **/
	public java.lang.String getMethod() {
		return method;
	}
	public void setParams(java.lang.String params){
		this.params=params;
	}
	/** params VARCHAR(1000)：提交数据 **/
	public java.lang.String getParams() {
		return params;
	}
	public void setPerform(java.lang.String perform){
		this.perform=perform;
	}
	/** perform VARCHAR(255)：工作性能 **/
	public java.lang.String getPerform() {
		return perform;
	}
	public void setLongTime(java.lang.String longTime){
		this.longTime=longTime;
	}
	/** long_time CHAR(12)：请求耗时 **/
	public java.lang.String getLongTime() {
		return longTime;
	}
	public void setRemarks(java.lang.String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(2000)：详细信息 **/
	public java.lang.String getRemarks() {
		return remarks;
	}

}
