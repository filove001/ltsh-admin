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
	private Integer id;//编号
	private String name;//角色名称
	private String code;//角色编码
	private Integer status;//状态
	private String createBy;//创建者
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	private String updateBy;//更新者
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date updateDate;//更新时间 
	private String remarks;//备注信息
	public void setId(Integer id){
		this.id=id;
	}
	/** id INT(10)：编号 **/
	public Integer getId() {
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	/** name VARCHAR(100)：角色名称 **/
	public String getName() {
		return name;
	}
	public void setCode(String code){
		this.code=code;
	}
	/** code VARCHAR(255)：角色编码 **/
	public String getCode() {
		return code;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	/** status INT(10)：状态 **/
	public Integer getStatus() {
		return status;
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
	public void setUpdateBy(String updateBy){
		this.updateBy=updateBy;
	}
	/** update_by VARCHAR(64)：更新者 **/
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate=updateDate;
	}
	/** update_date DATETIME(19)：更新时间 **/
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setRemarks(String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(255)：备注信息 **/
	public String getRemarks() {
		return remarks;
	}

}
