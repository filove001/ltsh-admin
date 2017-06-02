package com.ltsh.admin.mvc.sys.menu;

import com.ltsh.admin.util.Caches;
import com.ltsh.admin.util.SysCache;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.base.BaseDaoMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
public interface SysMenuDao extends BaseDaoMapper<SysMenu>{
	public void page(PageQuery<SysMenu> query);
}
