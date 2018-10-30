package com.ltsh.admin.security.shiro;

import com.ltsh.admin.mvc.sys.role.SysRole;
import com.ltsh.admin.mvc.sys.role.SysRoleService;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.mvc.sys.user.SysUserService;
import com.ltsh.admin.security.constant.UserConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public PermissionResolver getPermissionResolver() {
        return new UrlPermissionResolver();
    }

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        SysUser sysUser = sysUserService.getByUsername(token.getUsername());

        if (null == sysUser) {
            throw new AccountException("用户名不正确");
        } else if (!sysUser.getPassword().equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        SecurityUtils.getSubject().getSession().setAttribute(UserConstant.USER_INFO_TOKEN, sysUser);
        return new SimpleAuthenticationInfo(token.getPrincipal(), sysUser.getPassword(), getName());
    }
    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色

//        sysRoleService.getOne()
        List<SysRole> sysRoles = sysRoleService.getRoleByUserName(username);
        Set<String> set = new HashSet<>();
        if(sysRoles != null && !sysRoles.isEmpty()) {
            //需要将 role 封装到 Set 作为 info.setRoles() 的参数
            for (SysRole sysRole :sysRoles) {
                set.add(sysRole.getCode());
            }
        }
        //设置该用户拥有的角色
        info.setRoles(set);
        // 如果用户角色包含管理员则不拦截
        if(set.contains("admin")) {
            Set<String> stringPermissions = new HashSet<>();
            stringPermissions.add("/**");
            info.setStringPermissions(stringPermissions);
        }
        return info;
    }
}