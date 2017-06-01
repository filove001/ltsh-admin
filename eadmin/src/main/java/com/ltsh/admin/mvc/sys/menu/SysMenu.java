package com.ltsh.admin.mvc.sys.menu;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjz.util.Dates;
/**
 *  sys_menu 菜单 
 * @author fjz
 */
public class SysMenu{
	public static final String tableName="sys_menu";
	public static final String tableRemarks="菜单";
	private java.lang.Integer id;//编号 
	private java.lang.Integer parentId;//父级编号
	private java.lang.String parentIds;//所有父级编号 
	private java.lang.Integer level;//菜单级别 
	private java.lang.Integer type;//菜单类型 
	private java.lang.String name;//名称 
	private java.lang.Integer sort;//排序
	private java.lang.String href;//链接 
	private java.lang.String target;//目标 
	private java.lang.String icon;//图标 
	private java.lang.String permission;//权限标识 
	private java.lang.Integer status;//状态 
	private java.lang.String createBy;//创建者 
	@JsonFormat(pattern = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	private java.lang.String updateBy;//更新者 
	@JsonFormat(pattern = Dates.YYYY_MM_DD_HH_MM_SS)
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
	public void setParentId(java.lang.Integer parentId){
		this.parentId=parentId;
	}
	/** parent_id VARCHAR(64)：父级编号 **/
	public java.lang.Integer getParentId() {
		return parentId;
	}
	public void setParentIds(java.lang.String parentIds){
		this.parentIds=parentIds;
	}
	/** parent_ids VARCHAR(2000)：所有父级编号 **/
	public java.lang.String getParentIds() {
		return parentIds;
	}
	public void setLevel(java.lang.Integer level){
		this.level=level;
	}
	/** level INT(10)：菜单级别 **/
	public java.lang.Integer getLevel() {
		return level;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	/** type INT(10)：菜单类型 **/
	public java.lang.Integer getType() {
		return type;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR(100)：名称 **/
	public java.lang.String getName() {
		return name;
	}
	public void setSort(java.lang.Integer sort){
		this.sort=sort;
	}
	/** sort DECIMAL(10)：排序 **/
	public java.lang.Integer getSort() {
		return sort;
	}
	public void setHref(java.lang.String href){
		this.href=href;
	}
	/** href VARCHAR(2000)：链接 **/
	public java.lang.String getHref() {
		return href;
	}
	public void setTarget(java.lang.String target){
		this.target=target;
	}
	/** target VARCHAR(20)：目标 **/
	public java.lang.String getTarget() {
		return target;
	}
	public void setIcon(java.lang.String icon){
		this.icon=icon;
	}
	/** icon VARCHAR(100)：图标 **/
	public java.lang.String getIcon() {
		return icon;
	}
	public void setPermission(java.lang.String permission){
		this.permission=permission;
	}
	/** permission VARCHAR(200)：权限标识 **/
	public java.lang.String getPermission() {
		return permission;
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
