package ${basepackage}.mvc.${modelpackage};


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import ${basepackage}.unifiedManagement.security.annotation.RequiresPermissions;

import ${basepackage}.mvc.base.BaseMsg;
import ${basepackage}.mvc.base.Pager;
import ${basepackage}.mvc.${table.package}.${table.modelName};
import ${basepackage}.mvc.${table.package}.${table.modelName}AutoIds;
import ${basepackage}.util.Beans;
import ${basepackage}.mvc.base.BaseController;

/**
 * ${table.remarks} Controller
 */
@Controller
@RequestMapping("/${table.dir}")
public class ${table.modelName}Controller extends BaseController {
	@Autowired
	private ${table.modelName}Service ${table.modelNamefirstLower}Service;
	@RequestMapping("/index")
	@RequiresPermissions("${table.modelName}:view")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "${table.dir}/${table.modelNamefirstLower}";
	}
	/** 
	 * 执行搜索 
	 **/
	@RequestMapping("/list")
	@ResponseBody
	public Pager list(HttpServletRequest request,HttpServletResponse response) {
		PageQuery query=this.getPageQuery(request, response);
		${table.modelNamefirstLower}Service.page(query);
		return new Pager(query);
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	@RequiresPermissions("${table.modelName}:insert")
	public BaseMsg insert(HttpServletRequest request,HttpServletResponse response,${table.modelName} ${table.modelNamefirstLower}) {
		${table.modelNamefirstLower}.setId(${table.modelName}AutoIds.getId());
		${table.modelNamefirstLower}Service.insert(${table.modelNamefirstLower});
		return BaseMsg.success;
	}
	@RequestMapping("/update")
	@ResponseBody
	@RequiresPermissions("${table.modelName}:update")
	public BaseMsg update(HttpServletRequest request,HttpServletResponse response,${table.modelName} ${table.modelNamefirstLower}) {
		${table.modelName} entry =${table.modelNamefirstLower}Service.unique(${table.modelNamefirstLower}.getId());
		Beans.copyProperties(${table.modelNamefirstLower}, entry);
		${table.modelNamefirstLower}Service.updateById(entry);
		return BaseMsg.success;
	}
	@RequestMapping("/delete")
	@ResponseBody
	@RequiresPermissions("${table.modelName}:delete")
	public BaseMsg delete(HttpServletRequest request,HttpServletResponse response) {
		${table.modelNamefirstLower}Service.deleteById(request.getParameter("id").split(","));
		return BaseMsg.success;
	}
}





