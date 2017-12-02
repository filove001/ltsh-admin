package ${basepackage}.mvc.${modelpackage};

import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.engine.PageQuery;

import ${basepackage}.mvc.base.BaseDaoMapper;
public interface ${table.modelName}Dao extends BaseDaoMapper<${table.modelName}>{
	public void page(PageQuery<${table.modelName}> query);
}
