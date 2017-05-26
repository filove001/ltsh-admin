package com.ltsh.admin.mvc.sys.dict;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltsh.admin.mvc.base.BaseServiceImpl;
/**
 * 字典 service
 */
@Service
public class SysDictServiceImpl extends BaseServiceImpl<SysDict> implements SysDictService{
	@Autowired
	private SysDictDao sysDictDao;
	@Override
	public BaseMapper<SysDict> getDao(){
		return sysDictDao;
	}
	@Override
	public PageQuery<SysDict> page(PageQuery<SysDict> query) {
		sysDictDao.page(query);
		return query;
	}
}
