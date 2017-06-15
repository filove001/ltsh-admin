package com.ltsh.admin.mvc.cms.category;

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
public interface CmsCategoryDao extends BaseDaoMapper<CmsCategory>{
	public void page(PageQuery<CmsCategory> query);
}
