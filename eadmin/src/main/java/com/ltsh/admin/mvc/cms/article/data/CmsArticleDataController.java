package com.ltsh.admin.mvc.cms.article.data;


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

import com.ltsh.admin.mvc.cms.article.data.CmsArticleData;
import com.ltsh.admin.util.Beans;
import com.ltsh.admin.mvc.base.BaseController;

/**
 * 文章详 Controller
 */
@Controller
@RequestMapping("/cms/article/data")
public class CmsArticleDataController extends BaseController {
	public final static String ADD_TITLE = "添加"+CmsArticleData.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+CmsArticleData.tableRemarks;
	public final static String viewPath = "cms/article/data";
	@Autowired
	private CmsArticleDataService cmsArticleDataService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "cms/article/data/cmsArticleData";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<CmsArticleData> list(HttpServletRequest request,HttpServletResponse response,CmsArticleData queryEntity,PageQuery<CmsArticleData> query) {
		query.setParas(queryEntity);
		query=cmsArticleDataService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,CmsArticleData cmsArticleData) {
		cmsArticleDataService.insert(cmsArticleData);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,CmsArticleData cmsArticleData) {
		CmsArticleData dbEntity =cmsArticleDataService.unique(cmsArticleData.getId());
		Beans.copyProperties(cmsArticleData, dbEntity);
		cmsArticleDataService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		cmsArticleDataService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/cmsArticleDataAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,CmsArticleData cmsArticleData) {
		CmsArticleData dbEntity=cmsArticleDataService.unique(cmsArticleData.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("contentDisplayNone", true);
	   	request.setAttribute("copyfromDisplayNone", true);
	   	request.setAttribute("relationDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("contentDisabled", true);
	   	request.setAttribute("copyfromDisabled", true);
	   	request.setAttribute("relationDisabled", true);
		return viewPath+"/cmsArticleDataAddOrEdit";
	}
}





