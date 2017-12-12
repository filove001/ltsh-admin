package com.ltsh.admin.mvc.cms.category;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.CrudController;

/**
 * 栏目 Controller
 */
@Controller
@RequestMapping("/cms/category")
public class CmsCategoryController extends CrudController<CmsCategory> {
	public final static String ADD_TITLE = "添加"+CmsCategory.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+CmsCategory.tableRemarks;
	public final static String viewPath = "cms/category";
	public final static String index="cms/category/cmsCategory";//功能首页文件地址
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return index;
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/cmsCategoryAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,CmsCategory cmsCategory) {
		CmsCategory dbEntity=service.unique(cmsCategory.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);//id
	   	request.setAttribute("parentIdDisplayNone", true);//父ID
	   	request.setAttribute("nameDisplayNone", true);//中文名
	   	request.setAttribute("pathDisplayNone", true);//模板路径
	   	request.setAttribute("contentDisplayNone", true);//描述
	   	request.setAttribute("sortDisplayNone", true);//排序
	   	request.setAttribute("statusDisplayNone", true);//状态//radio/0,隐藏,1,显示
	   	request.setAttribute("typeDisplayNone", true);//类型 1 普通目录 2 a标签 3 a标签_blank 4 直接加载url信息
	   	request.setAttribute("hrefDisplayNone", true);//跳转地址
	   	request.setAttribute("materialTypeDisplayNone", true);//素材类型
	   	request.setAttribute("siteIdDisplayNone", true);//站点ID
	   	request.setAttribute("seoTitleDisplayNone", true);//SEO title
	   	request.setAttribute("seoKeywordsDisplayNone", true);//SEO keywords
	   	request.setAttribute("seoDescriptionDisplayNone", true);//SEO description
	   	request.setAttribute("updateTimeDisplayNone", true);//更新时间
	   	request.setAttribute("updateByDisplayNone", true);//更新人
	   	request.setAttribute("createTimeDisplayNone", true);//创建时间
	   	request.setAttribute("createByDisplayNone", true);//创建者
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);//id
	   	request.setAttribute("parentIdDisabled", true);//父ID
	   	request.setAttribute("nameDisabled", true);//中文名
	   	request.setAttribute("pathDisabled", true);//模板路径
	   	request.setAttribute("contentDisabled", true);//描述
	   	request.setAttribute("sortDisabled", true);//排序
	   	request.setAttribute("statusDisabled", true);//状态//radio/0,隐藏,1,显示
	   	request.setAttribute("typeDisabled", true);//类型 1 普通目录 2 a标签 3 a标签_blank 4 直接加载url信息
	   	request.setAttribute("hrefDisabled", true);//跳转地址
	   	request.setAttribute("materialTypeDisabled", true);//素材类型
	   	request.setAttribute("siteIdDisabled", true);//站点ID
	   	request.setAttribute("seoTitleDisabled", true);//SEO title
	   	request.setAttribute("seoKeywordsDisabled", true);//SEO keywords
	   	request.setAttribute("seoDescriptionDisabled", true);//SEO description
	   	request.setAttribute("updateTimeDisabled", true);//更新时间
	   	request.setAttribute("updateByDisabled", true);//更新人
	   	request.setAttribute("createTimeDisabled", true);//创建时间
	   	request.setAttribute("createByDisabled", true);//创建者
		return viewPath+"/cmsCategoryAddOrEdit";
	}
}





