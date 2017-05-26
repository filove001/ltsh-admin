package com.fjz.gen.base;

import java.util.Map;

import com.fjz.gen.config.GenBaseConfig;
import com.jfinal.kit.StrKit;

/**
 * 数据库字段
 * @author fjz
 */
public class TbColumn {
	public String dbTableName;		//表名
	public String name;				// 字段名
	public String javaType;			// 字段对应的 java 类型
	public String attrName;			// 字段对应的属性名
//	public String attrNameUpperCaseFirstOne;// 字段对应的属性名首字母大写
	// ---------
	
	/*
	-----------+---------+------+-----+---------+----------------
	 Field     | Type    | Null | Key | Default | Remarks
	-----------+---------+------+-----+---------+----------------
	 id		   | int(11) | NO	| PRI | NULL	| remarks here	
	*/
	public String type;				// 字段类型(附带字段长度与小数点)，例如：decimal(11,2)
	public String isNullable;		// 是否允许空值
	public String isPrimaryKey;		// 是否主键
	public String defaultValue;		// 默认值
	public String remarks;			// 字段备注
	public Integer length ; // 列最大长度
	
	public String getGridColumnHide() {
		return GenBaseConfig.gridColumnHide.get(dbTableName+"."+name)==null?"":",hide:true";
	}

	public String getSearchField() {
		return GenBaseConfig.searchField.get(dbTableName+"."+name);
	}

	public String getFormField() {
		return GenBaseConfig.formField.get(dbTableName+"."+name);
	}

	public String getValidator() {
		return GenBaseConfig.validator.get(dbTableName+"."+name);
	}

	public String getDbTableName() {
		return dbTableName;
	}
	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getIsPrimaryKey() {
		return isPrimaryKey;
	}
	public void setIsPrimaryKey(String isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAttrNameUpperCaseFirstOne() {
		return StrKit.firstCharToUpperCase(attrName);
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
	
}
