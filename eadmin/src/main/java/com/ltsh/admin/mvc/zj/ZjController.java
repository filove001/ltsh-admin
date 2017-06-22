package com.ltsh.admin.mvc.zj;


import com.fjz.util.Assert;
import com.fjz.util.Lists;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.cms.article.CmsArticle;
import com.ltsh.admin.mvc.cms.article.CmsArticleService;
import com.ltsh.admin.mvc.cms.category.CmsCategory;
import com.ltsh.admin.mvc.cms.category.CmsCategoryDao;
import com.ltsh.admin.mvc.cms.category.CmsCategoryService;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import com.ltsh.admin.util.SpringSecuritys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * c Controller
 */
@Controller
@RequestMapping("/zj")
public class ZjController extends BaseController {

	@Autowired
	private CmsCategoryService cmsCategoryService;
	@Autowired
	private CmsArticleService cmsArticleService;
	@RequestMapping({"/index","/"})
	public String index(HttpServletRequest request,HttpServletResponse response) {
		List<CmsCategory> all = getCmsCategories(request);
		CmsArticle query=new CmsArticle();
		query.setCategoryId(all.get(0).getId());
		List<CmsArticle> list=cmsArticleService.template(query);
		request.setAttribute("index",list.get(0));
		request.setAttribute("href","index");
		return "zj/index";
	}

	private List<CmsCategory> getCmsCategories(HttpServletRequest request) {
		List<CmsCategory> all=cmsCategoryService.all();
		all.sort((o1, o2) -> o1.getSort()-o2.getSort());
		request.setAttribute("categorys",all);
		return all;
	}
	private Map<String,CmsCategory> getCmsCategoriesMap(HttpServletRequest request) {
		List<CmsCategory> all=getCmsCategories(request);
		return Lists.listToMap(all,(e)->e.getHref());
	}

	@RequestMapping({"/{href}"})
	public String name(@PathVariable String  href, HttpServletRequest request, HttpServletResponse response) {
		Map<String,CmsCategory> map=getCmsCategoriesMap(request);
		request.setAttribute("href",href);
		CmsCategory  cmsCategory=map.get(href);
		Assert.notNull(cmsCategory,"找不到对应的栏目！");
		request.setAttribute("cmsCategory",cmsCategory);
		CmsArticle a=new CmsArticle();
		a.setCategoryId(cmsCategory.getId());
		List<CmsArticle> list=cmsArticleService.template(a);
		request.setAttribute("list",list);
		if("haichan".equals(href)){
			return "zj/index2";
		}
		return "zj/index1";
	}
}





