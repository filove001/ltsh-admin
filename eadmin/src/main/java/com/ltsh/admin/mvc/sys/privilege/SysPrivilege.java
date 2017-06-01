package com.ltsh.admin.mvc.sys.privilege;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjz.util.Dates;
/**
 *  sys_privilege 角色 
 * @author fjz
 */
public class SysPrivilege{
	public static final String tableName="sys_privilege";
	public static final String tableRemarks="角色";
	private java.lang.Integer id;//编号 
	private java.lang.String master;//主体 
	private java.lang.String masterValue;//控制值 
	private java.lang.String access;//领域
	private java.lang.String accessValue;//领域值 
	private java.lang.String operation;//权限 
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：编号 **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setMaster(java.lang.String master){
		this.master=master;
	}
	/** master VARCHAR(100)：主体 **/
	public java.lang.String getMaster() {
		return master;
	}
	public void setMasterValue(java.lang.String masterValue){
		this.masterValue=masterValue;
	}
	/** master_value VARCHAR(255)：控制值 **/
	public java.lang.String getMasterValue() {
		return masterValue;
	}
	public void setAccess(java.lang.String access){
		this.access=access;
	}
	/** access INT(10)：领域  **/
	public java.lang.String getAccess() {
		return access;
	}
	public void setAccessValue(java.lang.String accessValue){
		this.accessValue=accessValue;
	}
	/** access_value VARCHAR(255)：领域值 **/
	public java.lang.String getAccessValue() {
		return accessValue;
	}
	public void setOperation(java.lang.String operation){
		this.operation=operation;
	}
	/** operation VARCHAR(255)：权限 **/
	public java.lang.String getOperation() {
		return operation;
	}

}
