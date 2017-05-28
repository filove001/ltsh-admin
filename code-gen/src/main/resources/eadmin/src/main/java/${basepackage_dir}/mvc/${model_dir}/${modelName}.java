package ${basepackage}.mvc.${modelpackage};

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fjz.util.Dates;
/**
 *  ${table.name} ${table.remarks} 
 * @author fjz
 */
public class ${table.modelName}{
	public static final String tableName="${table.name}";
	public static final String tableRemarks="${table.remarks}";
	<% for(colunm in table.columns){ %>
		<% if(strutil.startWith(colunm.type,'DATETIME(')){%>
	@JsonFormat(pattern = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
		<%}else if(strutil.startWith(colunm.type,'DATE(')){%>
	@JsonFormat(pattern = Dates.YYYY_MM_DD)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD)
		<%}%>
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
