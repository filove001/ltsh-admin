package com.ltsh.admin.mvc.cms.category;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;
/**
 * 栏目 service
 */
public interface CmsCategoryService extends BaseService<CmsCategory>{
	public PageQuery<CmsCategory> page(PageQuery<CmsCategory> query);
}
