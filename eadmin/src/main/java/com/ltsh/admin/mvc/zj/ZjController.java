package com.ltsh.admin.mvc.zj;


import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.cms.category.CmsCategoryDao;
import com.ltsh.admin.mvc.cms.category.CmsCategoryService;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import com.ltsh.admin.util.SpringSecuritys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * c Controller
 */
@Controller
@RequestMapping("/zj")
public class ZjController extends BaseController {

	@Autowired
	private CmsCategoryService cmsCategoryService;
	@RequestMapping({"/index","/"})
	public String index(HttpServletRequest request,HttpServletResponse response) {
		request.setAttribute("categorys",cmsCategoryService.all());

		return "zj/index";
	}
}





