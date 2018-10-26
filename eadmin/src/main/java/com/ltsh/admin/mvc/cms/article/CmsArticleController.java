package com.ltsh.admin.mvc.cms.article;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjz.util.BaseMsg;
import com.fjz.util.Empty;
import com.fjz.util.Htmls;
import com.fjz.util.Jsons;
import com.ltsh.admin.annotation.SameUrlData;
import com.ltsh.admin.mvc.cms.category.CmsCategoryService;
import com.ltsh.admin.util.Beans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.CrudController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 文章 Controller
 */
@Controller
@RequestMapping("/cms/article")
public class CmsArticleController extends CrudController<CmsArticle> {
	public final static String ADD_TITLE = "添加"+CmsArticle.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+CmsArticle.tableRemarks;
	public final static String viewPath = "cms/article";
	public final static String index="cms/article/cmsArticle";//功能首页文件地址
	@Autowired
	private CmsCategoryService cmsCategoryService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return index;
	}
	@RequestMapping("/save")
	@ResponseBody
	@SameUrlData
	public BaseMsg<Object> save(HttpServletRequest request, HttpServletResponse response, CmsArticle t) {
		t.setImageUrl(getSrc(Htmls.getImgSrc(t.getContent())));//保存html里面含有图片的src
		t.setCreateTime(new Date());
		service.insert(t);
		return BaseMsg.successMsg;
	}
	private String getSrc(List<String> src){
		if(Empty.is(src)){
			return null;
		}
		return src.get(0);
	}
	@RequestMapping("/update")
	@ResponseBody
	@SameUrlData
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,String id,CmsArticle t) {
		CmsArticle dbEntity =service.unique(id);
		Beans.copyProperties(t, dbEntity);
		dbEntity.setImageUrl(getSrc(Htmls.getImgSrc(t.getContent())));//保存html里面含有图片的src
		dbEntity.setUpdateTime(new Date());
		service.updateById(dbEntity);
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
		CmsArticle dbEntity=service.unique(cmsArticle.getId());
		request.setAttribute("ztree", Jsons.toJsonString(cmsCategoryService.all()));
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);//id
//	   	request.setAttribute("categoryIdDisplayNone", true);//目录id
//	   	request.setAttribute("titleDisplayNone", true);//文章名称
//	   	request.setAttribute("contentDisplayNone", true);//文件内容
//	   	request.setAttribute("countViewDisplayNone", true);//浏览数
//	   	request.setAttribute("countCommentDisplayNone", true);//评论数
//	   	request.setAttribute("statusDisplayNone", true);//状态//radio/-1隐藏,1,显示
//	   	request.setAttribute("isCommentDisplayNone", true);//是否评论：-1否 1 是
//	   	request.setAttribute("isRecommendDisplayNone", true);//是否推荐：-1否 1 是
//	   	request.setAttribute("sortDisplayNone", true);//排序
//	   	request.setAttribute("hrefDisplayNone", true);//跳转地址
	   	request.setAttribute("imageUrlDisplayNone", true);//图片路径
//	   	request.setAttribute("fileUrlDisplayNone", true);//文件路径
//	   	request.setAttribute("fileNameDisplayNone", true);//文件名
//	   	request.setAttribute("approveStatusDisplayNone", true);//审核状态
//	   	request.setAttribute("startTimeDisplayNone", true);//更新时间
//	   	request.setAttribute("endTimeDisplayNone", true);//结束时间
//	   	request.setAttribute("updateByDisplayNone", true);//更新者
//	   	request.setAttribute("updateTimeDisplayNone", true);//更新时间
//	   	request.setAttribute("createTimeDisplayNone", true);//创建时间
//	   	request.setAttribute("createByDisplayNone", true);//创建者
//	   	request.setAttribute("remarksDisplayNone", true);//备注信息
//	   //控制编辑框是否不可用
//	   	request.setAttribute("idDisabled", true);//id
//	   	request.setAttribute("categoryIdDisabled", true);//目录id
//	   	request.setAttribute("titleDisabled", true);//文章名称
//	   	request.setAttribute("contentDisabled", true);//文件内容
//	   	request.setAttribute("countViewDisabled", true);//浏览数
//	   	request.setAttribute("countCommentDisabled", true);//评论数
//	   	request.setAttribute("statusDisabled", true);//状态//radio/-1隐藏,1,显示
//	   	request.setAttribute("isCommentDisabled", true);//是否评论：-1否 1 是
//	   	request.setAttribute("isRecommendDisabled", true);//是否推荐：-1否 1 是
//	   	request.setAttribute("sortDisabled", true);//排序
//	   	request.setAttribute("hrefDisabled", true);//跳转地址
//	   	request.setAttribute("imageUrlDisabled", true);//图片路径
//	   	request.setAttribute("fileUrlDisabled", true);//文件路径
//	   	request.setAttribute("fileNameDisabled", true);//文件名
//	   	request.setAttribute("approveStatusDisabled", true);//审核状态
//	   	request.setAttribute("startTimeDisabled", true);//更新时间
//	   	request.setAttribute("endTimeDisabled", true);//结束时间
//	   	request.setAttribute("updateByDisabled", true);//更新者
//	   	request.setAttribute("updateTimeDisabled", true);//更新时间
//	   	request.setAttribute("createTimeDisabled", true);//创建时间
//	   	request.setAttribute("createByDisabled", true);//创建者
//	   	request.setAttribute("remarksDisabled", true);//备注信息
		return viewPath+"/cmsArticleAddOrEdit";
	}
}





