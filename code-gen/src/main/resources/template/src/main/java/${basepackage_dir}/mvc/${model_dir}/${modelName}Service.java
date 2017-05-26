package ${basepackage}.mvc.${modelpackage};

import org.beetl.sql.core.engine.PageQuery;

import ${basepackage}.mvc.base.BaseService;
/**
 * ${table.remarks} service
 */
public interface ${table.modelName}Service extends BaseService<${table.modelName}>{
	public void page(PageQuery query);
}
