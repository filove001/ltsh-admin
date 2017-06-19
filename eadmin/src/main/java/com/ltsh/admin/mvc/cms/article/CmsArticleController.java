package com.ltsh.admin.mvc.cms.article;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjz.util.Jsons;
import com.ltsh.admin.mvc.cms.category.CmsCategoryService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;












import com.fjz.util.BaseMsg;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.util.Beans;

import com.ltsh.admin.mvc.cms.article.CmsArticle;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

/**
 * 文章 Controller
 */
@Controller
@RequestMapping("/cms/article")
public class CmsArticleController extends BaseController {
	public final static String ADD_TITLE = "添加"+CmsArticle.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+CmsArticle.tableRemarks;
	public final static String viewPath = "cms/article";
	@Autowired
	private CmsArticleService cmsArticleService;
	@Autowired
	private CmsCategoryService cmsCategoryService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "cms/article/cmsArticle";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<CmsArticle> list(HttpServletRequest request,HttpServletResponse response,CmsArticle queryEntity,PageQuery<CmsArticle> query) {
		query.setParas(queryEntity);
		query=cmsArticleService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,CmsArticle cmsArticle) {
		cmsArticleService.insert(cmsArticle);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,CmsArticle cmsArticle) {
		CmsArticle dbEntity =cmsArticleService.unique(cmsArticle.getId());
		Beans.copyProperties(cmsArticle, dbEntity);
		cmsArticleService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		cmsArticleService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("ztree", Jsons.toJsonString(cmsCategoryService.all()));
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("imageUrlDisplayNone", true);
		request.setAttribute("fileUrlDisplayNone", true);
		request.setAttribute("fileNameDisplayNone", true);
		request.setAttribute("remarksDisplayNone", true);
		return viewPath+"/cmsArticleAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,CmsArticle cmsArticle) {
		CmsArticle dbEntity=cmsArticleService.unique(cmsArticle.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("ztree", Jsons.toJsonString(cmsCategoryService.all()));
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("categoryIdDisplayNone", true);
	   	request.setAttribute("titleDisplayNone", true);
	   	request.setAttribute("contentDisplayNone", true);
	   	request.setAttribute("countViewDisplayNone", true);
	   	request.setAttribute("countCommentDisplayNone", true);
	   	request.setAttribute("statusDisplayNone", true);
	   	request.setAttribute("isCommentDisplayNone", true);
	   	request.setAttribute("isRecommendDisplayNone", true);
	   	request.setAttribute("sortDisplayNone", true);
	   	request.setAttribute("hrefDisplayNone", true);
	   	request.setAttribute("imageUrlDisplayNone", true);
	   	request.setAttribute("fileUrlDisplayNone", true);
	   	request.setAttribute("fileNameDisplayNone", true);
	   	request.setAttribute("approveStatusDisplayNone", true);
	   	request.setAttribute("startTimeDisplayNone", true);
	   	request.setAttribute("endTimeDisplayNone", true);
	   	request.setAttribute("updateByDisplayNone", true);
	   	request.setAttribute("updateTimeDisplayNone", true);
	   	request.setAttribute("createTimeDisplayNone", true);
	   	request.setAttribute("createByDisplayNone", true);
	   	request.setAttribute("remarksDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("categoryIdDisabled", true);
	   	request.setAttribute("titleDisabled", true);
	   	request.setAttribute("contentDisabled", true);
	   	request.setAttribute("countViewDisabled", true);
	   	request.setAttribute("countCommentDisabled", true);
	   	request.setAttribute("statusDisabled", true);
	   	request.setAttribute("isCommentDisabled", true);
	   	request.setAttribute("isRecommendDisabled", true);
	   	request.setAttribute("sortDisabled", true);
	   	request.setAttribute("hrefDisabled", true);
	   	request.setAttribute("imageUrlDisabled", true);
	   	request.setAttribute("fileUrlDisabled", true);
	   	request.setAttribute("fileNameDisabled", true);
	   	request.setAttribute("approveStatusDisabled", true);
	   	request.setAttribute("startTimeDisabled", true);
	   	request.setAttribute("endTimeDisabled", true);
	   	request.setAttribute("updateByDisabled", true);
	   	request.setAttribute("updateTimeDisabled", true);
	   	request.setAttribute("createTimeDisabled", true);
	   	request.setAttribute("createByDisabled", true);
	   	request.setAttribute("remarksDisabled", true);
		return viewPath+"/cmsArticleAddOrEdit";
	}
}





