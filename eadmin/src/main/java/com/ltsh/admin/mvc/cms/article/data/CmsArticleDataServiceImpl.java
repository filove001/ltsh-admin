package com.ltsh.admin.mvc.cms.article.data;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 文章详 service
 */
@Service
public class CmsArticleDataServiceImpl extends BaseServiceImpl<CmsArticleData> implements CmsArticleDataService{
	@Autowired
	private CmsArticleDataDao cmsArticleDataDao;
	@Override
	public BaseMapper<CmsArticleData> getDao(){
		return cmsArticleDataDao;
	}
	@Override
	public PageQuery<CmsArticleData> page(PageQuery<CmsArticleData> query) {
		cmsArticleDataDao.page(query);
		return query;
	}
}
