package com.ltsh.admin.mvc.zj;


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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
		List<CmsCategory> all=cmsCategoryService.all();
		all.sort((o1, o2) -> o1.getSort()-o2.getSort());
		request.setAttribute("categorys",all);
		CmsArticle query=new CmsArticle();
		query.setCategoryId(all.get(0).getId());
		List<CmsArticle> list=cmsArticleService.template(query);
		request.setAttribute("index",list.get(0));
		return "zj/index";
	}
}





