package com.ltsh.admin.mvc.sys.log;

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import com.ltsh.admin.mvc.base.BaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志 service
 */
public interface SysLogService extends BaseService<SysLog>{
	public PageQuery<SysLog> page(PageQuery<SysLog> query);
	public SysLog insert(HttpServletRequest request);
}
