package com.ltsh.admin.mvc.sys.log;

import com.fjz.util.Ips;
import com.fjz.util.Jsons;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 日志 service
 */
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLog> implements SysLogService{
	@Autowired
	private SysLogDao sysLogDao;
	@Override
	public BaseMapper<SysLog> getDao(){
		return sysLogDao;
	}
	@Override
	public PageQuery<SysLog> page(PageQuery<SysLog> query) {
		sysLogDao.page(query);
		return query;
	}

	@Override
	public SysLog insert(HttpServletRequest request) {
		SysLog sysLog=createSysLog(request);
		this.insert(sysLog,true);
		return sysLog;
	}
	private SysLog createSysLog(HttpServletRequest request) {
		SysLog sysLog = new SysLog();
		sysLog.setCreateDate(new Date());
		sysLog.setUserAgent(request.getHeader("User-Agent"));
		sysLog.setMethod(request.getMethod());
		sysLog.setParams(Jsons.toJsonString(request.getParameterMap()));
//		sysLog.setPerform();
		sysLog.setRemoteAddr(Ips.getIp(request));
		sysLog.setRequestUri(request.getServletPath());
		return sysLog;
	}
}
