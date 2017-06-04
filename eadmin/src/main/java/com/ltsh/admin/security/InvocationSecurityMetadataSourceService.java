package com.ltsh.admin.security;


import com.fjz.util.log.Logs;
import com.ltsh.admin.config.GlobalConf;
import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.util.Caches;
import com.ltsh.admin.util.SysCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Random on 2017/4/24.
 */
@Service
public class InvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    public InvocationSecurityMetadataSourceService() {
    }



    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    // 根据URL，找到相关的权限配置。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        // object 是一个URL，被用户请求的url。
        String url = filterInvocation.getRequestUrl();
        Logs.info("请求地址是:{}",url);
//        if()
        SecurityContext securityContext = SecurityContextHolder.getContext();

        if(securityContext != null && securityContext.getAuthentication() != null) {

            Collection<? extends GrantedAuthority> authorities = securityContext.getAuthentication().getAuthorities();

            Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
            for (GrantedAuthority grantedAuthority: authorities) {
                ConfigAttribute ca = new SecurityConfig(grantedAuthority.getAuthority());
                atts.add(ca);
            }
            return atts;
        }

        return null;

    }

    @Override
    public boolean supports(Class<?> arg0) {

        return true;
    }
}
