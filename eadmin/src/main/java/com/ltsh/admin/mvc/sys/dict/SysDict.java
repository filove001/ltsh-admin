package com.ltsh.admin.mvc.sys.dict;

import org.beetl.sql.core.annotatoin.AssignID;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjz.util.Dates;

/**
 *  sys_dict 字典 
 * @author fjz
 */
public class SysDict{
	public static final String tableName="sys_dict";
	public static final String tableRemarks="字典";
	private java.lang.String id;//编号 
	private java.lang.String value;//数据值 
	private java.lang.String label;//标签名 
	private java.lang.String type;//类型 
	private java.lang.String description;//描述 
	private java.lang.Integer sort;//排序（升序） 
	private java.lang.String parentId;//父级编号 
	private java.lang.String createBy;//创建者 
	@JsonFormat(pattern = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	private java.lang.String updateBy;//更新者 
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date updateDate;//更新时间 
	private java.lang.String remarks;//备注信息 
	public void setId(java.lang.String id){
		this.id=id;
	}
	/** id VARCHAR(64)：编号 **/
//	@AssignID("simple")
	@AssignID()
	public java.lang.String getId() {
		return id;
	}
	public void setValue(java.lang.String value){
		this.value=value;
	}
	/** value VARCHAR(100)：数据值 **/
	public java.lang.String getValue() {
		return value;
	}
	public void setLabel(java.lang.String label){
		this.label=label;
	}
	/** label VARCHAR(100)：标签名 **/
	public java.lang.String getLabel() {
		return label;
	}
	public void setType(java.lang.String type){
		this.type=type;
	}
	/** type VARCHAR(100)：类型 **/
	public java.lang.String getType() {
		return type;
	}
	public void setDescription(java.lang.String description){
		this.description=description;
	}
	/** description VARCHAR(100)：描述 **/
	public java.lang.String getDescription() {
		return description;
	}
	public void setSort(java.lang.Integer sort){
		this.sort=sort;
	}
	/** sort INT(10)：排序（升序） **/
	public java.lang.Integer getSort() {
		return sort;
	}
	public void setParentId(java.lang.String parentId){
		this.parentId=parentId;
	}
	/** parent_id VARCHAR(64)：父级编号 **/
	public java.lang.String getParentId() {
		return parentId;
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
