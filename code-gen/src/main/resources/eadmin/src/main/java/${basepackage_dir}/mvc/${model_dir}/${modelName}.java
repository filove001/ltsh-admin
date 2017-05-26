package ${basepackage}.mvc.${modelpackage};
/**
 *  ${table.name} ${table.remarks} 
 * @author fjz
 */
public class ${table.modelName}{
	public static final String tableName="${table.name}";
	public static final String tableRemarks="${table.remarks}";
	<% for(colunm in table.columns){ %>
	private ${colunm.javaType} ${colunm.attrName};//${colunm.remarks} 
	<% } %>
	<% for(colunm in table.columns){ %>
	public void set${colunm.attrNameUpperCaseFirstOne}(${colunm.javaType} ${colunm.attrName}){
		this.${colunm.attrName}=${colunm.attrName};
	}
	/** ${colunm.name} ${colunm.type}：${colunm.remarks} **/
	public ${colunm.javaType} get${colunm.attrNameUpperCaseFirstOne}() {
		return ${colunm.attrName};
	}
	<% } %>

}
