package com.ltsh.admin.mvc.cms.article.data;

import com.ltsh.admin.mvc.base.BaseBean;
/**
 *  cms_article_data 文章详 
 * @author fjz
 */
public class CmsArticleData extends BaseBean{
	public static final String tableName="cms_article_data";
	public static final String tableRemarks="文章详";
	private java.lang.Integer id;//id=cms_article.id 
	private java.lang.String content;//文章内容 
	private java.lang.String copyfrom;//文章来源 
	private java.lang.String relation;//相关文章 
	public void setId(java.lang.Integer id){
		this.id=id;
	}
	/** id INT(10)：id=cms_article.id **/
	public java.lang.Integer getId() {
		return id;
	}
	public void setContent(java.lang.String content){
		this.content=content;
	}
	/** content TEXT(65535)：文章内容 **/
	public java.lang.String getContent() {
		return content;
	}
	public void setCopyfrom(java.lang.String copyfrom){
		this.copyfrom=copyfrom;
	}
	/** copyfrom VARCHAR(255)：文章来源 **/
	public java.lang.String getCopyfrom() {
		return copyfrom;
	}
	public void setRelation(java.lang.String relation){
		this.relation=relation;
	}
	/** relation VARCHAR(255)：相关文章 **/
	public java.lang.String getRelation() {
		return relation;
	}

}
