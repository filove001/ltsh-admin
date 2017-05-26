//package com.ltsh.admin.management.security;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Method;
//
//import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
//import org.springframework.core.annotation.AnnotationUtils;
//
//import com.ltsh.admin.management.security.annotation.RequiresPermissions;
//
//@SuppressWarnings({"unchecked"})
//public class AuthorizationAttributeSourceAdvisor extends StaticMethodMatcherPointcutAdvisor {
//
//	private static final long serialVersionUID = 1L;
////	private static final Logger log = LoggerFactory.getLogger(AuthorizationAttributeSourceAdvisor.class);
//
//    private static final Class<? extends Annotation>[] AUTHZ_ANNOTATION_CLASSES =
//            new Class[] {
//                    RequiresPermissions.class
//            };
//    /**
//     * Create a new AuthorizationAttributeSourceAdvisor.
//     */
//    public AuthorizationAttributeSourceAdvisor() {
//        setAdvice(new AopAllianceAnnotationsAuthorizingMethodInterceptor());
//    }
//
//    /**
//     * Returns <tt>true</tt> 表示有下面的权限注解, false表示没有.
//     * <ul>
//     * <li>{@link com.xky.multi.tenant.unifiedManagement.security.annotation.RequiresPermissions RequiresPermissions}</li>
//     * </ul>
//     *
//     * @param method      the method to check for a annotation
//     * @param targetClass the class potentially declaring annotations
//     * @return <tt>true</tt> 如果方法有 annotation, false otherwise.
//     * @see org.springframework.aop.MethodMatcher#matches(java.lang.reflect.Method, Class)
//     */
//    public boolean matches(Method method, Class<?> targetClass) {
//        Method m = method;
//        if ( isAuthzAnnotationPresent(m) ) {
//            return true;
//        }
//        //这方法参数可能来自接口 ，可能没有注解
//        //检查其实现看是否有
//        if ( targetClass != null) {
//            try {
//                m = targetClass.getMethod(m.getName(), m.getParameterTypes());
//                if ( isAuthzAnnotationPresent(m) ) {
//                    return true;
//                }
//            } catch (NoSuchMethodException ignored) {
//            	//默认返回flase
//            }
//        }
//        return false;
//    }
//
//    private boolean isAuthzAnnotationPresent(Method method) {
//        for( Class<? extends Annotation> annClass : AUTHZ_ANNOTATION_CLASSES ) {
//            Annotation a = AnnotationUtils.findAnnotation(method, annClass);
//            if ( a != null ) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}
