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
// * 接口拦截(进行登录、权限认证)
// * 
// * @author fengjianzhong
// */
//public class ApiAuthInterceptor implements HandlerInterceptor {
//	private static final Logger logger = LoggerFactory
//			.getLogger(ApiAuthInterceptor.class);
//	private SysTenantService sysTenantService=SpringContextHolder.getBean(SysTenantService.class);;
//	@Override
//	public boolean preHandle(HttpServletRequest request,
//			HttpServletResponse response, Object handler) throws Exception {
//		logger.info("######接口拦截(进行登录、权限认证)#####");
//		// 判断是否登录了
//		SysUserBo sysUser = Webs.getSysUser();
//		if (sysUser == null) {
//			throw new CheckException("请登录后再请求！");
//		}
//		//用户的权限，看登录了哪个租户
//		SysTenantBo sysTenantBo=Webs.getSysTenantBo();
//		if (sysTenantBo == null) {//没有租户分为多种情况
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
//			response.sendRedirect(request.getContextPath()+"/tenant");
//			return false;
//		}
//		setUser(request,sysUser);
//		return true;
//	}
//	private void setUser(HttpServletRequest request,SysUserBo sysUser){
//		request.setAttribute("user", sysUser);
//		request.setAttribute("menus", sysUser.getSysTenantBo().getSysMenusByMenuType());
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