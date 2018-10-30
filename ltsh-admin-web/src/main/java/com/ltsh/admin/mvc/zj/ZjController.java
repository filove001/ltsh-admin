package com.ltsh.admin.mvc.zj;


import com.fjz.util.Assert;
import com.fjz.util.Htmls;
import com.fjz.util.Lists;
import com.ltsh.admin.config.GlobalConf;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.base.BasePageQuery;
import com.ltsh.admin.mvc.cms.article.CmsArticle;
import com.ltsh.admin.mvc.cms.article.CmsArticleService;
import com.ltsh.admin.mvc.cms.category.CmsCategory;
import com.ltsh.admin.mvc.cms.category.CmsCategoryDao;
import com.ltsh.admin.mvc.cms.category.CmsCategoryService;
import com.ltsh.admin.mvc.sys.user.SysUserService;
//import com.ltsh.admin.util.SpringSecuritys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

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
	@RequestMapping({"/{href}/{pageNumber}/{pageSize}.html"})
	public String page(@PathVariable String  href,@PathVariable Integer  pageNumber,@PathVariable Integer  pageSize, HttpServletRequest request, HttpServletResponse response) {
		Map<String,CmsCategory> map=getCmsCategoriesMap(request);
		CmsCategory  cmsCategory=map.get(href);
		Assert.notNull(cmsCategory,"找不到对应的栏目！");
		request.setAttribute("cmsCategory",cmsCategory);
		CmsArticle a=new CmsArticle();
		a.setCategoryId(cmsCategory.getId());
		BasePageQuery query=new BasePageQuery();
		query.setPageNumber(pageNumber);
		query.setPageSize(pageSize);
		query.setParas(a);
		cmsArticleService.page(query);
		List<CmsArticle> list =query.getList();
				list.forEach((e)->{
			e.setContent(Htmls.deleteAllHTMLTag(e.getContent()));});
		request.setAttribute("listHref",("/zj/"+href));
		request.setAttribute("list",list);
		request.setAttribute("page",query);
		if("haichan".equals(href)){
			return "zj/index2";
		}
		return "zj/list";
	}
	@RequestMapping({"/{href}/{pageNumber}"})
	public String name(@PathVariable String  href,@PathVariable Integer  pageNumber, HttpServletRequest request, HttpServletResponse response) {
		return page(href, pageNumber, GlobalConf.pageSize, request, response);
	}
	@RequestMapping({"/{href}"})
	public String name(@PathVariable String  href, HttpServletRequest request, HttpServletResponse response) {
		return page(href, 1, GlobalConf.pageSize, request, response);
	}
}





