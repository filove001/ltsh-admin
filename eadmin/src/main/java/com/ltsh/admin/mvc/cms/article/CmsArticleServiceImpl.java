package com.ltsh.admin.mvc.cms.article;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 文章 service
 */
@Service
public class CmsArticleServiceImpl extends BaseServiceImpl<CmsArticle> implements CmsArticleService{
	@Autowired
	private CmsArticleDao cmsArticleDao;
	@Override
	public BaseMapper<CmsArticle> getDao(){
		return cmsArticleDao;
	}
	@Override
	public PageQuery<CmsArticle> page(PageQuery<CmsArticle> query) {
		cmsArticleDao.page(query);
		return query;
	}
}
