package com.ltsh.admin.mvc.cms.article.data;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface CmsArticleDataDao extends BaseDaoMapper<CmsArticleData>{
	public void page(PageQuery<CmsArticleData> query);
}
