package com.ltsh.admin.mvc.sys.log;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
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
}
