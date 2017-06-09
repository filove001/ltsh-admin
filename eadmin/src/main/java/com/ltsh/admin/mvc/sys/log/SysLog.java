package com.ltsh.admin.mvc.sys.log;

import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fjz.util.Dates;
/**
 *  sys_log 日志 
 * @author fjz
 */
public class SysLog{
	public static final String tableName="sys_log";
	public static final String tableRemarks="日志";
	private Long id;//编号
	private String type;//日志类型
	private String title;//日志标题
	private String userName;//用户名者
	private String userId;//用户id
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	private String remoteAddr;//操作IP地址
	private String userAgent;//用户代理
	private String requestUri;//请求URI
	private String method;//操作方式
	private String params;//提交数据
	private String perform;//工作性能
	private String longTime;//请求耗时
	private String remarks;//详细信息
	public void setId(Long id){
		this.id=id;
	}
	/** id BIGINT(19)：编号 **/
	public Long getId() {
		return id;
	}
	public void setType(String type){
		this.type=type;
	}
	/** type CHAR(1)：日志类型 **/
	public String getType() {
		return type;
	}
	public void setTitle(String title){
		this.title=title;
	}
	/** title VARCHAR(255)：日志标题 **/
	public String getTitle() {
		return title;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	/** user_name VARCHAR(64)：用户名者 **/
	public String getUserName() {
		return userName;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	/** user_id VARCHAR(64)：用户id **/
	public String getUserId() {
		return userId;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate=createDate;
	}
	/** create_date DATETIME(19)：创建时间 **/
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setRemoteAddr(String remoteAddr){
		this.remoteAddr=remoteAddr;
	}
	/** remote_addr VARCHAR(255)：操作IP地址 **/
	public String getRemoteAddr() {
		return remoteAddr;
	}
	public void setUserAgent(String userAgent){
		this.userAgent=userAgent;
	}
	/** user_agent VARCHAR(255)：用户代理 **/
	public String getUserAgent() {
		return userAgent;
	}
	public void setRequestUri(String requestUri){
		this.requestUri=requestUri;
	}
	/** request_uri VARCHAR(255)：请求URI **/
	public String getRequestUri() {
		return requestUri;
	}
	public void setMethod(String method){
		this.method=method;
	}
	/** method VARCHAR(5)：操作方式 **/
	public String getMethod() {
		return method;
	}
	public void setParams(String params){
		this.params=params;
	}
	/** params VARCHAR(1000)：提交数据 **/
	public String getParams() {
		return params;
	}
	public void setPerform(String perform){
		this.perform=perform;
	}
	/** perform VARCHAR(255)：工作性能 **/
	public String getPerform() {
		return perform;
	}
	public void setLongTime(String longTime){
		this.longTime=longTime;
	}
	/** long_time CHAR(12)：请求耗时 **/
	public String getLongTime() {
		return longTime;
	}
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(2000)：详细信息 **/
	public String getRemarks() {
		return remarks;
	}

}
