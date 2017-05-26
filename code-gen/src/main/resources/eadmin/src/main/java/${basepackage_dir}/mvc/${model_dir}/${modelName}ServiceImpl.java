package ${basepackage}.mvc.${modelpackage};

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${basepackage}.mvc.base.BaseServiceImpl;
/**
 * ${table.remarks} service
 */
@Service
public class ${table.modelName}ServiceImpl extends BaseServiceImpl<${table.modelName}> implements ${table.modelName}Service{
	@Autowired
	private ${table.modelName}Dao ${table.modelNamefirstLower}Dao;
	@Override
	public BaseMapper<${table.modelName}> getDao(){
		return ${table.modelNamefirstLower}Dao;
	}
	@Override
	public PageQuery<${table.modelName}> page(PageQuery<${table.modelName}> query) {
		${table.modelNamefirstLower}Dao.page(query);
		return query;
	}
}
