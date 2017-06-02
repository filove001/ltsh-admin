package com.ltsh.admin.mvc.sys.dict;

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
	private java.lang.Integer id;//编号
	private java.lang.String value;//数据值
	private java.lang.String key;//标签名
	private java.lang.String type;//类型
	private java.lang.String description;//描述
	private java.lang.Integer sort;//排序（升序）
	private java.lang.Integer parentId;//父级编号
	private java.lang.String remarks;//备注信息
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：编号 **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setValue(java.lang.String value){
		this.value=value;
	}
	/** value VARCHAR(100)：数据值 **/
	public java.lang.String getValue() {
		return value;
	}
	public void setKey(java.lang.String key){
		this.key=key;
	}
	/** key VARCHAR(100)：标签名 **/
	public java.lang.String getKey() {
		return key;
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
	public void setParentId(java.lang.Integer parentId){
		this.parentId=parentId;
	}
	/** parent_id INT(10)：父级编号 **/
	public java.lang.Integer getParentId() {
		return parentId;
	}
	public void setRemarks(java.lang.String remarks){
		this.remarks=remarks;
	}
	/** remarks VARCHAR(255)：备注信息 **/
	public java.lang.String getRemarks() {
		return remarks;
	}

}
