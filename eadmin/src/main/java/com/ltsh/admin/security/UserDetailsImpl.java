package com.ltsh.admin.security;

import com.fjz.util.Empty;
import com.ltsh.admin.mvc.sys.role.SysRole;
import com.ltsh.admin.mvc.sys.user.SysUser;
import com.ltsh.admin.util.SpringSecuritys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Random on 2017/4/20.
 */
public class UserDetailsImpl implements UserDetails {

    private List<GrantedAuthority> auths;
    private String password;
    private String username;
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public UserDetailsImpl(){

    }

    public UserDetailsImpl(SysUser userInfo, List<SysRole> roles){
        this.password =userInfo.getPassword();
        this.username = userInfo.getLoginName();
        this.sysUser=userInfo;
        auths = SpringSecuritys.getGrantedAuthoritys(roles);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auths;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
