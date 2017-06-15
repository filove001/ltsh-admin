package com.ltsh.admin.mvc.cms.article;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface CmsArticleDao extends BaseDaoMapper<CmsArticle>{
	public void page(PageQuery<CmsArticle> query);
}
