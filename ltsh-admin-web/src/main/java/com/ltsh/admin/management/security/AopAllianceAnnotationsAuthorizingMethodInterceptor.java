//package com.ltsh.admin.management.security;
//
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//
//import com.fjz.util.exception.CheckException;
//import com.ltsh.admin.management.security.annotation.RequiresPermissions;
//
//public class AopAllianceAnnotationsAuthorizingMethodInterceptor implements MethodInterceptor{
//
//	@Override
//	public Object invoke(MethodInvocation invocation) throws Throwable {
////		System.out.println("###########AopAllianceAnnotationsAuthorizingMethodInterceptor");
////		System.out.println("###########"+JsonUtil.toJsonString(invocation.getMethod().getAnnotations()));
////		System.out.println(invocation.getMethod().getAnnotation(RequiresPermissions.class));
////		System.out.println("###########"+JsonUtil.toJsonString(invocation.getThis()));
////		System.out.println("###########"+JsonUtil.toJsonString(invocation.getStaticPart()));
//		if(!checkAuth(invocation)){
//			throw new CheckException("没有这个权限！");
////			return BaseMsg.me().setMsg("没有这个权限！");
//		}
//        Object result = invocation.proceed();  
//        return result;  
//	}
//	/**
//	 * 检查是否有权限使用该方法
//	 * @return
//	 */
//	private boolean checkAuth(MethodInvocation invocation){
//		RequiresPermissions ano=invocation.getMethod().getAnnotation(RequiresPermissions.class);
//		String[] values=ano.value();
//		SysTenantBo bo=Webs.getSysTenantBo();
//		for (String string : values) {
//			for (SysMenu  menu: bo.getSysMenus()) {
//				if(string.equals(menu.getPermission())){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//}
