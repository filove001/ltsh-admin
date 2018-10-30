package com.ltsh.admin.mvc.sys.log;

import com.ltsh.admin.mvc.base.BaseService;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志 service
 */
public interface SysLogService extends BaseService<SysLog>{
    public SysLog insert(HttpServletRequest request);
}
