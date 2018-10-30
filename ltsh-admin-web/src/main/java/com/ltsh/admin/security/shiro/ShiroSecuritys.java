package com.ltsh.admin.security.shiro;

import com.fjz.util.Empty;
import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.menu.SysMenuBo;
import com.ltsh.admin.mvc.sys.menu.SysMenuService;
import com.ltsh.admin.mvc.sys.role.SysRole;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.security.constant.UserConstant;
import com.ltsh.admin.util.SpringContextHolder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.Subject;

import java.util.*;

/**
 * Created by fengjianzhong on 2017/6/1.
 */
public class ShiroSecuritys {

    /**
     * 取得当前用户, 返回值为UserInfo类或其子类, 如果当前用户未登录则返回null.
     */
    @SuppressWarnings("unchecked")
    public static <T extends SysUser> T getCurrentUser() {

        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return null;
        }
        return (T)subject.getSession().getAttribute(UserConstant.USER_INFO_TOKEN);
    }
    private static SysMenuService sysMenuService = SpringContextHolder.getBean(SysMenuService.class);
    private static CustomRealm customRealm = SpringContextHolder.getBean(CustomRealm.class);
    /**
     * 取得当前用户的权限菜单树
     */
    public static List<SysMenuBo> getSysMenuBos() {
        AuthorizationInfo authorizationInfo = customRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        List<SysMenu> menus = sysMenuService.getMenu(authorizationInfo.getRoles());
        return sysMenuService.getSysMenuBoTree(menus);
    }
    /**
     * 取得当前用户的登录名, 如果当前用户未登录则返回空字符串.
     */
    public static String getCurrentUserName() {
        return (String)SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 取得当前用户的真实姓名, 如果当前用户未登录则返回空字符串.
     */
    public static String getCurrentName() {
        return getCurrentUser().getName();
    }

    /**
     * 取得当前用户登录IP, 如果当前用户未登录则返回空字符串.
     */
    public static String getCurrentUserIp() {
        return "";
    }

    /**
     * 判断用户是否拥有角色, 如果用户拥有参数中的任意一个角色则返回true.
     */
    public static boolean hasAnyRole(String... roles) {
        AuthorizationInfo authorizationInfo = customRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());


        if (authorizationInfo == null) {
            return false;
        }
        Collection<String> grantedAuthorities = authorizationInfo.getRoles();
        for (String role : roles) {
            for (String authority : grantedAuthorities) {
                if (role.equals(authority)) {
                    return true;
                }
            }
        }

        return false;
    }



    /**
     * 取得Authentication, 如当前SecurityContext为空时返回null.
     */
    public static AuthorizationInfo getAuthorizationInfo(CustomRealm customRealm) {
        return customRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
    /**
     //     * 通过角色组装对应的权限列表
     //     * @param roles
     //     * @return
     //     */
    public static Set<String> getGrantedAuthoritys(List<SysRole> roles){
        Set<String> as = new HashSet<>();
        if(Empty.not(roles)){
            for (SysRole role : roles) {
                as.add(role.getCode());
            }
        }
        return as;
    }

}
