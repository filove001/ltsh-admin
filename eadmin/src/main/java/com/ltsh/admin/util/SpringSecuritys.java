package com.ltsh.admin.util;

import com.fjz.util.log.Logs;
import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.menu.SysMenuBo;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by fengjianzhong on 2017/6/1.
 */
public class SpringSecuritys {
    /**
     * 取得当前用户, 返回值为UserInfo类或其子类, 如果当前用户未登录则返回null.
     */
    @SuppressWarnings("unchecked")
    public static <T extends UserDetailsImpl> T getCurrentUser() {
        Authentication authentication = getAuthentication();

        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
//        if (!(principal instanceof UserDetailsImpl)) {
//            return null;
//        }
        return (T) principal;
    }
    /**
     * 取得当前用户的权限菜单树
     */
    public static List<SysMenuBo> getSysMenuBos() {
        Collection<? extends GrantedAuthority> authorities = SpringSecuritys.getAuthentication().getAuthorities();
        List<SysMenu> menus = SysCache.getMenu(authorities);
        List<SysMenuBo> nodeList = new ArrayList();
        menus.forEach((e)->{nodeList.add(SysMenuBo.getSysMenuBo(e));});
        List<SysMenuBo> ztree=SysMenuBo.getSysMenuBos(nodeList);
        return ztree;
    }
    /**
     * 取得当前用户的登录名, 如果当前用户未登录则返回空字符串.
     */
    public static String getCurrentUserName() {
        Authentication authentication = getAuthentication();

        if (authentication == null || authentication.getPrincipal() == null) {
            return "";
        }

        return authentication.getName();
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
        Authentication authentication = getAuthentication();

        if (authentication == null) {
            return "";
        }

        Object details = authentication.getDetails();
        if (!(details instanceof WebAuthenticationDetails)) {
            return "";
        }

        WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
        return webDetails.getRemoteAddress();
    }

    /**
     * 判断用户是否拥有角色, 如果用户拥有参数中的任意一个角色则返回true.
     */
    public static boolean hasAnyRole(String... roles) {
        Authentication authentication = getAuthentication();

        if (authentication == null) {
            return false;
        }
        Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
        for (String role : roles) {
            for (GrantedAuthority authority : grantedAuthorities) {
                if (role.equals(authority.getAuthority())) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 将UserDetails保存到Security Context.
     *
     * @param userDetails
     *            已初始化好的用户信息.
     * @param request
     *            用于获取用户IP地址信息,可为Null.
     */
    public static void saveUserDetailsToContext(UserDetails userDetails,
                                                HttpServletRequest request) {
        PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails
                .getAuthorities());

        if (request != null) {
            authentication.setDetails(new WebAuthenticationDetails(request));
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * 取得Authentication, 如当前SecurityContext为空时返回null.
     */
    public static Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }
        return context.getAuthentication();
    }
}
