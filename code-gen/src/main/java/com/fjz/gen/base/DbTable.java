package com.fjz.gen.base;

import java.util.ArrayList;
import java.util.List;

import com.fjz.util.Names;
import com.jfinal.kit.StrKit;
/**
 * 数据库表
 * @author fjz
 *
 */
public class DbTable {
	public static void main(String[] args) {
		new DbTable().getName().replace("表", "");
	}
	public String name;					// 表名
	public String remarks;				// 表备注
	public String primaryKey;			// 主键，复合主键以逗号分隔
	public String[] getPrimaryKesArr(){
		return primaryKey.split(",");
	}
	public String getDir(){
		return name.replaceAll("_", "/").toLowerCase();
	}
	public String getPackage(){
		return name.replaceAll("_", ".").toLowerCase();
	}
	public List<TbColumn> columns = new ArrayList<TbColumn>();	// 字段 
	// ---------
	
	public String baseModelName;		// 生成的 base model 名
	public String baseModelContent;		// 生成的 base model 内容
	
	public String modelName;			// 生成的 model 名 className
	public String modelContent;			// 生成的 model 内容
	public String getModelNamefirstLower(){
		return StrKit.firstCharToLowerCase(modelName);
	}
	public String getModelNameToHtmlName(){
		return Names.camelToSplitLowerWord(modelName, '-');
	}
	public int colNameMaxLen = "Field".length();			// 字段名最大宽度，用于辅助生成字典文件样式
	public int colTypeMaxLen = "Type".length();				// 字段类型最大宽度，用于辅助生成字典文件样式
	public int colDefaultValueMaxLen = "Default".length();	// 字段默认值最大宽度，用于辅助生成字典文件样式
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<TbColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<TbColumn> columns) {
		this.columns = columns;
	}
	public String getBaseModelName() {
		return baseModelName;
	}
	public void setBaseModelName(String baseModelName) {
		this.baseModelName = baseModelName;
	}
	public String getBaseModelContent() {
		return baseModelContent;
	}
	public void setBaseModelContent(String baseModelContent) {
		this.baseModelContent = baseModelContent;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelContent() {
		return modelContent;
	}
	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}
	public int getColNameMaxLen() {
		return colNameMaxLen;
	}
	public void setColNameMaxLen(int colNameMaxLen) {
		this.colNameMaxLen = colNameMaxLen;
	}
	public int getColTypeMaxLen() {
		return colTypeMaxLen;
	}
	public void setColTypeMaxLen(int colTypeMaxLen) {
		this.colTypeMaxLen = colTypeMaxLen;
	}
	public int getColDefaultValueMaxLen() {
		return colDefaultValueMaxLen;
	}
	public void setColDefaultValueMaxLen(int colDefaultValueMaxLen) {
		this.colDefaultValueMaxLen = colDefaultValueMaxLen;
	}
	
}
