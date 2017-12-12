package com.ltsh.admin.mvc.sys.role;
import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fjz.util.Dates;
/**
 *  sys_role 角色 
 * @author fjz
 */
public class SysRole{
	public static final String tableName="sys_role";
	public static final String tableRemarks="角色";
	private java.lang.Integer id;//编号 
	private java.lang.String name;//角色名称 
	private java.lang.String code;//角色编码 
	private java.lang.Integer status;//状态 
	private java.lang.String createBy;//创建者 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	private java.lang.String updateBy;//更新者 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date updateDate;//更新时间 
	private java.lang.String remarks;//备注信息 
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：编号 **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR(100)：角色名称 **/
	public java.lang.String getName() {
		return name;
	}
	public void setCode(java.lang.String code){
		this.code=code;
	}
	/** code VARCHAR(255)：角色编码 **/
	public java.lang.String getCode() {
		return code;
	}
	public void setStatus(java.lang.Integer status){
		this.status=status;
	}
	/** status INT(10)：状态 **/
	public java.lang.Integer getStatus() {
		return status;
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
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy=updateBy;
	}
	/** update_by VARCHAR(64)：更新者 **/
	public java.lang.String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate=updateDate;
	}
	/** update_date DATETIME(19)：更新时间 **/
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setRemarks(java.lang.String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(255)：备注信息 **/
	public java.lang.String getRemarks() {
		return remarks;
	}

}
