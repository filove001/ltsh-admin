package com.ltsh.admin.mvc.cms.article.data;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 文章详 service
 */
public interface CmsArticleDataService extends BaseService<CmsArticleData>{
	public PageQuery<CmsArticleData> page(PageQuery<CmsArticleData> query);
}
