package com.ltsh.admin.security;


import com.ltsh.admin.mvc.sys.log.SysLogService;
import com.ltsh.admin.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by Random on 2017/4/20.
 */
@Service
public class LoginAuthenticationManager extends DaoAuthenticationProvider {
    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        Object salt = null;
//        if (getSaltSource() != null) {
//            salt = getSaltSource().getSalt(userDetails);
//        }
        if (authentication.getPrincipal() == null
                || "".equals(authentication.getPrincipal())) {
            logger.debug("-----用户名不能为空！-----");

            throw new BadCredentialsException("-----用户名不能为空！-----");
        }
        if (authentication.getCredentials() == null
                || "".equals(authentication.getCredentials())) {
            logger.debug("-----密码不能为空！-----");
            throw new BadCredentialsException("-----密码不能为空！-----");
        }

        String presentedPassword = authentication.getCredentials().toString();
        //密码校验
        boolean validResult = !userDetails.getPassword().equals(presentedPassword);//getPasswordEncoder().matches(userDetails.getPassword(), presentedPassword);//!getPasswordEncoder().isPasswordValid(userDetails.getPassword(), presentedPassword, salt);
        if (validResult) {
            logger.debug("---- 用户名或密码错误！-----");
            throw new BadCredentialsException("-----用户名或密码错误！-----");
        }
        SpringContextHolder.getBean(SysLogService.class).insert(SpringContextHolder.getRequest());//记录日志
//        UserInfo userInfo = userInfoMapper.selectByLoginName(authentication.getPrincipal().toString());
//        List<Role> roles = roleMapper.selectByUserId(userInfo.getId());
//        Set<Menu> menu = SysCache.getMenu(roles);

    }
}
