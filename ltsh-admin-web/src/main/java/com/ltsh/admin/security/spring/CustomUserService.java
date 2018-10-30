//package com.ltsh.admin.security;
//
//import com.ltsh.admin.mvc.sys.role.SysRole;
//import com.ltsh.admin.mvc.sys.role.SysRoleDao;
//import com.ltsh.admin.mvc.sys.user.SysUser;
//import com.ltsh.admin.mvc.sys.user.SysUserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by Random on 2017/4/20.
// */
//@Service("customUserService")
//public class CustomUserService implements UserDetailsService {
//    @Autowired
//    SysUserDao sysUserDao;
//    @Autowired
//    SysRoleDao sysRoleDao;
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        SysUser sysUser = sysUserDao.getByUsername(s);
//        List<SysRole> roles = null;
//        if(sysUser != null) {
//            roles = sysRoleDao.getRoleByUserId(sysUser.getId());
//        }else {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        UserDetailsImpl userDetails = new UserDetailsImpl(sysUser, roles);
//
//        return userDetails;
//    }
//}