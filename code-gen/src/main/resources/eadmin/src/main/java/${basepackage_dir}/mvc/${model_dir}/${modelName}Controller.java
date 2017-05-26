package ${basepackage}.mvc.${modelpackage};


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;












import com.fjz.util.BaseMsg;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.util.Beans;

import ${basepackage}.mvc.${table.package}.${table.modelName};
import ${basepackage}.util.Beans;
import ${basepackage}.mvc.base.BaseController;

/**
 * ${table.remarks} Controller
 */
@Controller
@RequestMapping("/${table.dir}")
public class ${table.modelName}Controller extends BaseController {
	public final static String ADD_TITLE = "添加"+${table.modelName}.tableRemarks;
	public final static String UPDATE_TITLE = "编辑"+${table.modelName}.tableRemarks;
	public final static String viewPath = "${table.dir}";
	@Autowired
	private ${table.modelName}Service ${table.modelNamefirstLower}Service;
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "${table.dir}/${table.modelNamefirstLower}";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public PageQuery<${table.modelName}> list(HttpServletRequest request,HttpServletResponse response,${table.modelName} queryEntity,PageQuery<${table.modelName}> query) {
		query.setParas(queryEntity);
		query=${table.modelNamefirstLower}Service.page(query);
		return query;
	}
	@RequestMapping("/save")
	@ResponseBody
	public BaseMsg<Object> save(HttpServletRequest request,HttpServletResponse response,${table.modelName} ${table.modelNamefirstLower}) {
		${table.modelNamefirstLower}Service.insert(${table.modelNamefirstLower});
		return BaseMsg.successMsg;
	}
	@RequestMapping("/update")
	@ResponseBody
	public BaseMsg<Object> update(HttpServletRequest request,HttpServletResponse response,${table.modelName} ${table.modelNamefirstLower}) {
		${table.modelName} dbEntity =${table.modelNamefirstLower}Service.unique(${table.modelNamefirstLower}.getId());
		Beans.copyProperties(${table.modelNamefirstLower}, dbEntity);
		${table.modelNamefirstLower}Service.updateById(dbEntity);
		return BaseMsg.successMsg;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public BaseMsg<Object> delete(HttpServletRequest request,HttpServletResponse response,@RequestParam String ids) {
		${table.modelNamefirstLower}Service.deleteById(ids.split(","));
		return BaseMsg.successMsg;
	}
	
	@RequestMapping("/add.html")
	public String add(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("title", ADD_TITLE);
		request.setAttribute("idDisplayNone", true);
		request.setAttribute("nameDisabled", true);
		return viewPath+"/${table.modelNamefirstLower}AddOrEdit";
	}
	@RequestMapping("/edit.html")
	public String edit(HttpServletRequest request,HttpServletResponse response,${table.modelName} ${table.modelNamefirstLower}) {
		${table.modelName} dbEntity=${table.modelNamefirstLower}Service.unique(${table.modelNamefirstLower}.getId());
		request.setAttribute("obj", dbEntity);
		request.setAttribute("title", UPDATE_TITLE);
		//控制编辑框是否不可见
		<%
	   	for(colunm in table.columns){ 
	   	%>
	   	request.setAttribute("${colunm.attrName}DisplayNone", true);
	   <%
	   	}
	   %>
	   //控制编辑框是否不可用
		<%
	   	for(colunm in table.columns){ 
	   	%>
	   	request.setAttribute("${colunm.attrName}Disabled", true);
	   <%
	   	}
	   %> 
		return viewPath+"/${table.modelNamefirstLower}AddOrEdit";
	}
}





