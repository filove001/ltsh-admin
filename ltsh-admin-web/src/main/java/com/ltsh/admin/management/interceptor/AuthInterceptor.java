//package com.ltsh.admin.management.interceptor;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.xky.multi.tenant.mvc.sys.tenant.SysTenant;
//import com.xky.multi.tenant.mvc.sys.tenant.SysTenantBo;
//import com.xky.multi.tenant.mvc.sys.tenant.SysTenantService;
//import com.xky.multi.tenant.mvc.sys.user.SysUserBo;
//import com.xky.multi.tenant.util.Empty;
//import com.xky.multi.tenant.util.SpringContextHolder;
//import com.xky.multi.tenant.util.exception.CheckException;
//import com.xky.multi.tenant.util.web.Webs;
//
///**
// * 拦截(进行登录、权限认证)
// * 
// * @author fengjianzhong
// */
//public class AuthInterceptor implements HandlerInterceptor {
//	private static final Logger logger = LoggerFactory
//			.getLogger(AuthInterceptor.class);
//	private SysTenantService sysTenantService=SpringContextHolder.getBean(SysTenantService.class);;
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		logger.info("######web拦截(进行登录、权限认证)#####");
//		// 判断是否登录了
//		SysUserBo sysUser = Webs.getSysUser();
//		if (sysUser == null) {
//			response.sendRedirect(request.getContextPath()+"/login");
//			return false;
//		}
//		//用户的权限，看登录了哪个租户
//		SysTenantBo sysTenantBo=Webs.getSysTenantBo();
//		System.out.println("##333"+request.getServletPath());
//		if (sysTenantBo == null&&request.getServletPath().indexOf("/sys/tenant/optionView")==-1) {//没有租户分为多种情况
//			List<SysTenant> list=Webs.getSysTenantsBySysUserId(sysUser.getId());
//			if(Empty.is(list)){
//				throw new CheckException("当前用户没有租户请注册一个租户！");
//			}
//			if(list.size()==1){
//				//获取租户所有权限
//				SysTenantBo bo=sysTenantService.getSysTenantBo(list.get(0));
//				sysUser.setSysTenantBo(bo);
//				setUser(request,sysUser);
//				return true;
//			}
//			//判断所有租户都是患者类型则，登录患者租户
////			request.setAttribute("tenants", list);
////			request.getSession().setAttribute("tenants", list);
////			request.getRequestDispatcher(request.getContextPath()+"/sys/tenant/optionTenant.html").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/sys/tenant/optionView");
//			return false;
//		}else if(sysTenantBo != null){
//			setUser(request,sysUser);
//		}
//		return true;
//	}
//	private void setUser(HttpServletRequest request,SysUserBo sysUser){
//		request.setAttribute("user", sysUser);
//		request.setAttribute("menus", sysUser.getSysTenantBo().getSysMenusByMenuType());
//		request.setAttribute("apps", sysUser.getSysTenantBo().getSysApps());
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest request,
//			HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//	}
//
//}