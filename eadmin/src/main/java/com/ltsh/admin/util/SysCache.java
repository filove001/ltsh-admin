package com.ltsh.admin.util;

import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.menu.SysMenuDao;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilege;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilegeDao;
import com.ltsh.admin.mvc.sys.role.SysRole;

import com.ltsh.admin.mvc.sys.role.SysRoleDao;
import org.springframework.security.core.GrantedAuthority;

import java.util.*;

/**
 * Created by Random on 2017/4/21.
 */
public class SysCache {

    public final static String CACHE_MENUS_KEY = "LTSH_MENU_CACHE";
    public final static String CACHE_ROLES_KEY = "LTSH_ROLE_CACHE";
    public final static String CACHE_ROLE_MENU_KEY = "LTSH_ROLE_MENU_CACHE";

    static SysMenuDao sysMenuDao = SpringContextHolder.getBean(SysMenuDao.class);
    static SysPrivilegeDao sysPrivilegeDao = SpringContextHolder.getBean(SysPrivilegeDao.class);
    static SysRoleDao sysRoleDao = SpringContextHolder.getBean(SysRoleDao.class);
    public static List<SysMenu> getMenu(Collection<? extends GrantedAuthority> roleCodes) {
        SysMenu searchSysMenu = new SysMenu();
        searchSysMenu.setStatus(1);
        List<SysMenu> sysMenus = sysMenuDao.template(searchSysMenu);
        SysPrivilege searchSysPrivilege = new SysPrivilege();
        searchSysPrivilege.setAccess(SysMenu.tableName);
        List<SysPrivilege> sysPrivileges = sysPrivilegeDao.template(searchSysPrivilege);
        List<SysRole> sysRoles = sysRoleDao.all();
        List<SysMenu> tmpMenuList = new ArrayList<SysMenu>();
        Map<String, Object> menuIdMap = new HashMap<String, Object>();
        if (sysPrivileges != null && sysRoles != null && sysMenus != null) {
            for (SysPrivilege sysPrivilege : sysPrivileges) {
                for (SysRole role : sysRoles) {
                    for (GrantedAuthority grantedAuthority : roleCodes) {
                        if (grantedAuthority.getAuthority().equals(role.getCode()) && sysPrivilege.getMasterValue().equals(String.valueOf(role.getId()))) {
                            menuIdMap.put(sysPrivilege.getAccessValue(), sysPrivilege.getMasterValue());
                        }
                    }

                }
            }
            for (SysMenu menu :
                    sysMenus) {
                if (menuIdMap.get(String.valueOf(menu.getId())) != null) {
                    tmpMenuList.add(menu);
                }
            }
            Collections.sort(tmpMenuList, (o1, o2) -> {
                int compareResult = 0;
                if (o1.getSort() != null && o2.getSort() != null) {
                    if (o1.getSort() > o2.getSort()) {
                        compareResult = 1;
                    } else if (o1.getSort() < o2.getSort()) {
                        compareResult = -1;
                    }
                }
                return compareResult;
            });
        }
        return tmpMenuList;
    }
}
