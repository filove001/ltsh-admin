package com.ltsh.admin.mvc.cms.article.data;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.CrudController;

/**
 * 文章详 Controller
 */
@Controller
@RequestMapping("/cms/article/data")
public class CmsArticleDataController extends CrudController<CmsArticleData> {
	public final static String ADD_TITLE = "添加"+CmsArticleData.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+CmsArticleData.tableRemarks;
	public final static String viewPath = "cms/article/data";
	public final static String index="cms/article/data/cmsArticleData";//功能首页文件地址
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return index;
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/cmsArticleDataAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,CmsArticleData cmsArticleData) {
		CmsArticleData dbEntity=service.unique(cmsArticleData.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);//id=cms_article.id
	   	request.setAttribute("contentDisplayNone", true);//文章内容
	   	request.setAttribute("copyfromDisplayNone", true);//文章来源
	   	request.setAttribute("relationDisplayNone", true);//相关文章
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);//id=cms_article.id
	   	request.setAttribute("contentDisabled", true);//文章内容
	   	request.setAttribute("copyfromDisabled", true);//文章来源
	   	request.setAttribute("relationDisabled", true);//相关文章
		return viewPath+"/cmsArticleDataAddOrEdit";
	}
}





