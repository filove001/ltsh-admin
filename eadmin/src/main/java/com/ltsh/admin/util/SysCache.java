package com.ltsh.admin.util;

import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilege;
import com.ltsh.admin.mvc.sys.role.SysRole;

import org.springframework.security.core.GrantedAuthority;

import java.util.*;

/**
 * Created by Random on 2017/4/21.
 */
public class SysCache {

    public static String CACHE_MENUS_KEY = "LTSH_MENU_CACHE";
    public static String CACHE_ROLES_KEY = "LTSH_ROLE_CACHE";
    public static String CACHE_ROLE_MENU_KEY = "LTSH_ROLE_MENU_CACHE";
    public static List<SysMenu> getMenu(Collection<? extends GrantedAuthority> roleCodes) {
        List<SysMenu> sysMenus = (List<SysMenu>)Caches.get(CACHE_MENUS_KEY);
        List<SysPrivilege> sysPrivileges = (List<SysPrivilege>)Caches.get(CACHE_ROLE_MENU_KEY);
        List<SysRole> sysRoles = (List<SysRole>)Caches.get(CACHE_ROLES_KEY);
        List<SysMenu> tmpMenuList = new ArrayList<SysMenu>();
        Map<String, Object> menuIdMap = new HashMap<String, Object>();
        for (SysPrivilege sysPrivilege :
                sysPrivileges) {
            for (SysRole role :
                    sysRoles) {
                for (GrantedAuthority grantedAuthority:
                     roleCodes) {
                    if(grantedAuthority.getAuthority().equals(role.getCode()) && sysPrivilege.getMasterValue().equals(role.getId())) {
                        menuIdMap.put(sysPrivilege.getAccessValue(), sysPrivilege.getMasterValue());
                    }
                }

            }
        }
        for (SysMenu menu :
                sysMenus) {
            if(menuIdMap.get(menu.getId()) != null) {
                tmpMenuList.add(menu);
            }
        }
        Collections.sort(tmpMenuList,(o1,o2)->{
            int compareResult = 0;
            if(o1.getSort() > o2.getSort()) {
                compareResult = 1;
            } else if(o1.getSort() < o2.getSort()) {
                compareResult = -1;
            }
            return compareResult;
        });
//        Collections.sort(tmpMenuList, new Comparator<SysMenu>(){
//            @Override
//            public int compare(SysMenu o1, SysMenu o2) {
//                int compareResult = 0;
//                if(o1.getSort() > o2.getSort()) {
//                    compareResult = 1;
//                } else if(o1.getSort() < o2.getSort()) {
//                    compareResult = -1;
//                }
//                return compareResult;
//            }
//        });
        return tmpMenuList;
    }
}
