package com.ltsh.admin.mvc.cms.category;
import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fjz.util.Dates;

import com.ltsh.admin.mvc.base.BaseBean;
/**
 *  cms_category 栏目 
 * @author fjz
 */
public class CmsCategory extends BaseBean{
	public static final String tableName="cms_category";
	public static final String tableRemarks="栏目";
	private java.lang.Integer id;//id 
	private java.lang.Integer parentId;//父ID 
	private java.lang.String name;//中文名 
	private java.lang.String path;//模板路径 
	private java.lang.String content;//描述 
	private java.lang.Integer sort;//排序 
	private java.lang.String status;//状态隐藏显示 
	private java.lang.Integer type;//类型 1 普通目录 2 a标签 3 a标签_blank 4 直接加载url信息 
	private java.lang.String href;//跳转地址 
	private java.lang.Integer materialType;//素材类型 
	private java.lang.Integer siteId;//站点ID 
	private java.lang.String seoTitle;//SEO标题 
	private java.lang.String seoKeywords;//SEO关键字 
	private java.lang.String seoDescription;//SEO详情 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date updateTime;//更新时间 
	private java.lang.Integer updateBy;//更新人 
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
	private java.util.Date createTime;//创建时间 
	private java.lang.Integer createBy;//创建者 
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：id **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setParentId(java.lang.Integer parentId){
		this.parentId=parentId;
	}
	/** parent_id INT(10)：父ID **/
	public java.lang.Integer getParentId() {
		return parentId;
	}
	public void setName(java.lang.String name){
		this.name=name;
	}
	/** name VARCHAR(100)：中文名 **/
	public java.lang.String getName() {
		return name;
	}
	public void setPath(java.lang.String path){
		this.path=path;
	}
	/** path VARCHAR(200)：模板路径 **/
	public java.lang.String getPath() {
		return path;
	}
	public void setContent(java.lang.String content){
		this.content=content;
	}
	/** content TEXT(65535)：描述 **/
	public java.lang.String getContent() {
		return content;
	}
	public void setSort(java.lang.Integer sort){
		this.sort=sort;
	}
	/** sort INT(10)：排序 **/
	public java.lang.Integer getSort() {
		return sort;
	}
	public void setStatus(java.lang.String status){
		this.status=status;
	}
	/** status ENUM(2)：状态隐藏显示 **/
	public java.lang.String getStatus() {
		return status;
	}
	public void setType(java.lang.Integer type){
		this.type=type;
	}
	/** type INT(10)：类型 1 普通目录 2 a标签 3 a标签_blank 4 直接加载url信息 **/
	public java.lang.Integer getType() {
		return type;
	}
	public void setHref(java.lang.String href){
		this.href=href;
	}
	/** href VARCHAR(200)：跳转地址 **/
	public java.lang.String getHref() {
		return href;
	}
	public void setMaterialType(java.lang.Integer materialType){
		this.materialType=materialType;
	}
	/** material_type INT(10)：素材类型 **/
	public java.lang.Integer getMaterialType() {
		return materialType;
	}
	public void setSiteId(java.lang.Integer siteId){
		this.siteId=siteId;
	}
	/** site_id INT(10)：站点ID **/
	public java.lang.Integer getSiteId() {
		return siteId;
	}
	public void setSeoTitle(java.lang.String seoTitle){
		this.seoTitle=seoTitle;
	}
	/** seo_title VARCHAR(200)：SEO标题 **/
	public java.lang.String getSeoTitle() {
		return seoTitle;
	}
	public void setSeoKeywords(java.lang.String seoKeywords){
		this.seoKeywords=seoKeywords;
	}
	/** seo_keywords VARCHAR(200)：SEO关键字 **/
	public java.lang.String getSeoKeywords() {
		return seoKeywords;
	}
	public void setSeoDescription(java.lang.String seoDescription){
		this.seoDescription=seoDescription;
	}
	/** seo_description VARCHAR(200)：SEO详情 **/
	public java.lang.String getSeoDescription() {
		return seoDescription;
	}
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime=updateTime;
	}
	/** update_time DATETIME(19)：更新时间 **/
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateBy(java.lang.Integer updateBy){
		this.updateBy=updateBy;
	}
	/** update_by INT(10)：更新人 **/
	public java.lang.Integer getUpdateBy() {
		return updateBy;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	/** create_time DATETIME(19)：创建时间 **/
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateBy(java.lang.Integer createBy){
		this.createBy=createBy;
	}
	/** create_by INT(10)：创建者 **/
	public java.lang.Integer getCreateBy() {
		return createBy;
	}

}
