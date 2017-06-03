package com.ltsh.admin.mvc.sys.dict;


import com.fjz.util.BaseMsg;
import com.fjz.util.log.Logs;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.util.Beans;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 字典 Controller
 */
@Controller
@RequestMapping("/sys/dict")
public class SysDictController extends BaseController {
	public final static String ADD_TITLE = "添加"+SysDict.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysDict.tableRemarks;
	public final static String viewPath = "sys/dict";
	@Autowired
	private SysDictService sysDictService;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "sys/dict/sysDict";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<SysDict> list(HttpServletRequest request,HttpServletResponse response,SysDict queryEntity,PageQuery<SysDict> query) {

		query.setParas(queryEntity);
		query=sysDictService.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,SysDict sysDict) {
		sysDictService.insert(sysDict);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,SysDict sysDict) {
		SysDict dbEntity =sysDictService.unique(sysDict.getId());
		Beans.copyProperties(sysDict, dbEntity);
		sysDictService.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		sysDictService.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("nameDisabled", true);
		return viewPath+"/sysDictAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysDict sysDict) {
		SysDict dbEntity=sysDictService.unique(sysDict.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);
	   	request.setAttribute("valueDisplayNone", true);
	   	request.setAttribute("labelDisplayNone", true);
	   	request.setAttribute("typeDisplayNone", true);
	   	request.setAttribute("descriptionDisplayNone", true);
	   	request.setAttribute("sortDisplayNone", true);
	   	request.setAttribute("parentIdDisplayNone", true);
	   	request.setAttribute("createByDisplayNone", true);
	   	request.setAttribute("createDateDisplayNone", true);
	   	request.setAttribute("updateByDisplayNone", true);
	   	request.setAttribute("updateDateDisplayNone", true);
	   	request.setAttribute("remarksDisplayNone", true);
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);
	   	request.setAttribute("valueDisabled", true);
	   	request.setAttribute("labelDisabled", true);
	   	request.setAttribute("typeDisabled", true);
	   	request.setAttribute("descriptionDisabled", true);
	   	request.setAttribute("sortDisabled", true);
	   	request.setAttribute("parentIdDisabled", true);
	   	request.setAttribute("createByDisabled", true);
	   	request.setAttribute("createDateDisabled", true);
	   	request.setAttribute("updateByDisabled", true);
	   	request.setAttribute("updateDateDisabled", true);
	   	request.setAttribute("remarksDisabled", true);
		return viewPath+"/sysDictAddOrEdit";
	}
}





