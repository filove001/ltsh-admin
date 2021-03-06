package ${basepackage}.mvc.${modelpackage};
<% for(colunm in table.columns){ %>
	<% if(strutil.startWith(colunm.type,'DATE')){%>
import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.fjz.util.Dates;
	<%
		break;
		}
	%>
<%}%>

import ${basepackage}.mvc.base.BaseBean;
/**
 *  ${table.name} ${table.remarks} 
 * @author fjz
 */
public class ${table.modelName} extends BaseBean{
	public static final String tableName="${table.name}";
	public static final String tableRemarks="${table.remarks}";
	<% for(colunm in table.columns){ %>
		<% if(strutil.startWith(colunm.type,'DATETIME(')){%>
	@JSONField(format = Dates.YYYY_MM_DD_HH_MM_SS)
	@DateTimeFormat(pattern=Dates.YYYY_MM_DD_HH_MM_SS)
		<%}else if(strutil.startWith(colunm.type,'DATE(')){%>
	@JSONField(format=  Dates.YYYY_MM_DD)
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
