package com.ltsh.admin.mvc.base;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;

public interface BaseDaoMapper<T> extends BaseMapper<T>{
    void page(PageQuery<T> query);
}
