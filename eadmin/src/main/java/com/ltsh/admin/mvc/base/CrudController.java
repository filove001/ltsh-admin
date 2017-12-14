package com.ltsh.admin.mvc.base;

import com.fjz.util.BaseMsg;
import com.ltsh.admin.annotation.SameUrlData;
import com.ltsh.admin.config.GlobalConf;
import com.ltsh.admin.mvc.book.Book;
import com.ltsh.admin.util.Beans;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 简单增删改查BaseController
 * @author fjz
 *
 */
public class CrudController<T> extends BaseController{
	@Autowired
	public BaseService<T> service;

	/**
	 * 执行搜索
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<T> list(HttpServletRequest request, HttpServletResponse response, T queryEntity, BasePageQuery<T> query) {
		query.setParas(queryEntity);
		service.page(query);
//		query = BasePageQuery.setSuccess(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	@SameUrlData
	public BaseMsg<Object> save(HttpServletRequest request, HttpServletResponse response, T t) {
		service.insert(t);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	@SameUrlData
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,String id,T t) {
		T dbEntity =service.unique(id);
		Beans.copyProperties(t, dbEntity);
		service.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		service.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
}
