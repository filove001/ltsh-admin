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
	private Integer id;//编号
	private Integer parentId;//父级编号
	private String parentIds;//所有父级编号
	private Integer level;//菜单级别
	private Integer type;//菜单类型
	private String name;//名称
	private Integer sort;//排序
	private String href;//链接
	private String target;//目标
	private String icon;//图标
	private String permission;//权限标识
	private Integer status;//状态
	private String createBy;//创建者
	@JsonFormat(pattern = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createDate;//创建时间 
	private String updateBy;//更新者
	@JsonFormat(pattern = Dates.YYYY_MM_DD_HH_MM_SS)
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
	public void setParentId(Integer parentId){
		this.parentId=parentId;
	}
	/** parent_id INT(10)：父级编号 **/
	public Integer getParentId() {
		return parentId;
	}
	public void setParentIds(String parentIds){
		this.parentIds=parentIds;
	}
	/** parent_ids VARCHAR(2000)：所有父级编号 **/
	public String getParentIds() {
		return parentIds;
	}
	public void setLevel(Integer level){
		this.level=level;
	}
	/** level INT(10)：菜单级别 **/
	public Integer getLevel() {
		return level;
	}
	public void setType(Integer type){
		this.type=type;
	}
	/** type INT(10)：菜单类型 **/
	public Integer getType() {
		return type;
	}
	public void setName(String name){
		this.name=name;
	}
	/** name VARCHAR(100)：名称 **/
	public String getName() {
		return name;
	}
	public void setSort(Integer sort){
		this.sort=sort;
	}
	/** sort INT(10)：排序 **/
	public Integer getSort() {
		return sort;
	}
	public void setHref(String href){
		this.href=href;
	}
	/** href VARCHAR(2000)：链接 **/
	public String getHref() {
		return href;
	}
	public void setTarget(String target){
		this.target=target;
	}
	/** target VARCHAR(20)：目标 **/
	public String getTarget() {
		return target;
	}
	public void setIcon(String icon){
		this.icon=icon;
	}
	/** icon VARCHAR(100)：图标 **/
	public String getIcon() {
		return icon;
	}
	public void setPermission(String permission){
		this.permission=permission;
	}
	/** permission VARCHAR(200)：权限标识 **/
	public String getPermission() {
		return permission;
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
