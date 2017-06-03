package com.ltsh.admin.mvc.controller;


import com.fjz.util.log.Logs;
import com.ltsh.admin.mvc.base.BaseController;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import com.ltsh.admin.util.SpringSecuritys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * c Controller
 */
@Controller
public class ErrController extends BaseController implements ErrorController {
//	@RequestMapping("500")
//	public String toPage(){
//		return "err/500";
//	}
	private static final String ERROR_PATH = "/error";

	@RequestMapping(value=ERROR_PATH)
	public String handleError(){
		return "err/500";
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}





