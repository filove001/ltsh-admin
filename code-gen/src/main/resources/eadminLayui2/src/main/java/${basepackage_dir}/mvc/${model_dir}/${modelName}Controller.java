package ${basepackage}.mvc.${modelpackage};


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltsh.admin.mvc.base.CrudController;

/**
 * ${table.remarks} Controller
 */
@Controller
@RequestMapping("/${table.dir}")
public class ${table.modelName}Controller extends CrudController<${table.modelName}> {
	public final static String ADD_TITLE = "添加"+${table.modelName}.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+${table.modelName}.tableRemarks;
	public final static String viewPath = "${table.dir}";
	public final static String index="${table.dir}/${table.modelNamefirstLower}";//功能首页文件地址
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return index;
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		return viewPath+"/${table.modelNamefirstLower}AddOrEdit";
	}
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,${table.modelName} ${table.modelNamefirstLower}) {
		${table.modelName} dbEntity=service.unique(${table.modelNamefirstLower}.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
		<%
	   	for(colunm in table.columns){ 
	   	%>
	   	request.setAttribute("${colunm.attrName}DisplayNone", true);//${colunm.remarks}
	   <%
	   	}
	   %>
	   //控制编辑框是否不可用
		<%
	   	for(colunm in table.columns){ 
	   	%>
	   	request.setAttribute("${colunm.attrName}Disabled", true);//${colunm.remarks}
	   <%
	   	}
	   %> 
		return viewPath+"/${table.modelNamefirstLower}AddOrEdit";
	}
}





