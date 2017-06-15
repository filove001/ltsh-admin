package com.ltsh.admin.mvc.cms.article;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 文章 service
 */
public interface CmsArticleService extends BaseService<CmsArticle>{
	public PageQuery<CmsArticle> page(PageQuery<CmsArticle> query);
}
