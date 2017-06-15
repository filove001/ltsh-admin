package com.ltsh.admin.mvc.cms.category;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 栏目 service
 */
@Service
public class CmsCategoryServiceImpl extends BaseServiceImpl<CmsCategory> implements CmsCategoryService{
	@Autowired
	private CmsCategoryDao cmsCategoryDao;
	@Override
	public BaseMapper<CmsCategory> getDao(){
		return cmsCategoryDao;
	}
	@Override
	public PageQuery<CmsCategory> page(PageQuery<CmsCategory> query) {
		cmsCategoryDao.page(query);
		return query;
	}
}
