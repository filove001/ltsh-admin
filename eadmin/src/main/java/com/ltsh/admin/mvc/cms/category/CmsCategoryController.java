package com.ltsh.admin.mvc.cms.category;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;












import com.fjz.util.BaseMsg;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.util.Beans;

import com.ltsh.admin.mvc.cms.category.CmsCategory;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

/**
 * 栏目 Controller
 */
@Controller
@RequestMapping("/cms/category")
public class CmsCategoryController extends BaseController {
	public final static String ADD_TITLE = "添加"+CmsCategory.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+CmsCategory.tableRemarks;
	public final static String viewPath = "cms/category";
	@Autowired
	private CmsCategoryService cmsCategoryService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "cms/category/cmsCategory";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<CmsCategory> list(HttpServletRequest request,HttpServletResponse response,CmsCategory queryEntity,PageQuery<CmsCategory> query) {
		query.setParas(queryEntity);
		query=cmsCategoryService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,CmsCategory cmsCategory) {
		cmsCategoryService.insert(cmsCategory);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,CmsCategory cmsCategory) {
		CmsCategory dbEntity =cmsCategoryService.unique(cmsCategory.getId());
		Beans.copyProperties(cmsCategory, dbEntity);
		cmsCategoryService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		cmsCategoryService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/cmsCategoryAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,CmsCategory cmsCategory) {
		CmsCategory dbEntity=cmsCategoryService.unique(cmsCategory.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("parentIdDisplayNone", true);
	   	request.setAttribute("nameDisplayNone", true);
	   	request.setAttribute("pathDisplayNone", true);
	   	request.setAttribute("contentDisplayNone", true);
	   	request.setAttribute("sortDisplayNone", true);
	   	request.setAttribute("statusDisplayNone", true);
	   	request.setAttribute("typeDisplayNone", true);
	   	request.setAttribute("hrefDisplayNone", true);
	   	request.setAttribute("materialTypeDisplayNone", true);
	   	request.setAttribute("siteIdDisplayNone", true);
	   	request.setAttribute("seoTitleDisplayNone", true);
	   	request.setAttribute("seoKeywordsDisplayNone", true);
	   	request.setAttribute("seoDescriptionDisplayNone", true);
	   	request.setAttribute("updateTimeDisplayNone", true);
	   	request.setAttribute("updateByDisplayNone", true);
	   	request.setAttribute("createTimeDisplayNone", true);
	   	request.setAttribute("createByDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("parentIdDisabled", true);
	   	request.setAttribute("nameDisabled", true);
	   	request.setAttribute("pathDisabled", true);
	   	request.setAttribute("contentDisabled", true);
	   	request.setAttribute("sortDisabled", true);
	   	request.setAttribute("statusDisabled", true);
	   	request.setAttribute("typeDisabled", true);
	   	request.setAttribute("hrefDisabled", true);
	   	request.setAttribute("materialTypeDisabled", true);
	   	request.setAttribute("siteIdDisabled", true);
	   	request.setAttribute("seoTitleDisabled", true);
	   	request.setAttribute("seoKeywordsDisabled", true);
	   	request.setAttribute("seoDescriptionDisabled", true);
	   	request.setAttribute("updateTimeDisabled", true);
	   	request.setAttribute("updateByDisabled", true);
	   	request.setAttribute("createTimeDisabled", true);
	   	request.setAttribute("createByDisabled", true);
		return viewPath+"/cmsCategoryAddOrEdit";
	}
}





