package ${basepackage}.mvc.${modelpackage};

import org.beetl.sql.core.engine.PageQuery;

import com.ltsh.admin.mvc.sys.dict.SysDict;

import ${basepackage}.mvc.base.BaseService;
/**
 * ${table.remarks} service
 */
public interface ${table.modelName}Service extends BaseService<${table.modelName}>{
	public PageQuery<${table.modelName}> page(PageQuery<${table.modelName}> query);
}
