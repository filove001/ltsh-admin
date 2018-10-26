package com.ltsh.admin.mvc.sys.dict;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.CrudController;

/**
 * 字典 Controller
 */
@Controller
@RequestMapping("/sys/dict")
public class SysDictController extends CrudController<SysDict> {
	public final static String ADD_TITLE = "添加"+SysDict.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+SysDict.tableRemarks;
	public final static String viewPath = "sys/dict";
	public final static String index="sys/dict/sysDict";//功能首页文件地址
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return index;
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/sysDictAddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,SysDict sysDict) {
		SysDict dbEntity=service.unique(sysDict.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
	   	request.setAttribute("idDisplayNone", true);//编号
	   	request.setAttribute("dictValueDisplayNone", true);//数据值
	   	request.setAttribute("dictKeyDisplayNone", true);//标签名
	   	request.setAttribute("typeDisplayNone", true);//类型
	   	request.setAttribute("descriptionDisplayNone", true);//描述
	   	request.setAttribute("sortDisplayNone", true);//排序（升序）
	   	request.setAttribute("parentIdDisplayNone", true);//父级编号
	   	request.setAttribute("remarksDisplayNone", true);//备注信息
	   //控制编辑框是否不可用
	   	request.setAttribute("idDisabled", true);//编号
	   	request.setAttribute("dictValueDisabled", true);//数据值
	   	request.setAttribute("dictKeyDisabled", true);//标签名
	   	request.setAttribute("typeDisabled", true);//类型
	   	request.setAttribute("descriptionDisabled", true);//描述
	   	request.setAttribute("sortDisabled", true);//排序（升序）
	   	request.setAttribute("parentIdDisabled", true);//父级编号
	   	request.setAttribute("remarksDisabled", true);//备注信息
		return viewPath+"/sysDictAddOrEdit";
	}
}





