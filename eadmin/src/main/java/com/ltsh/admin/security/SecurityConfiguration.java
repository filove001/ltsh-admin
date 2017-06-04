package com.ltsh.admin.security;

import com.ltsh.admin.config.GlobalConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.DefaultWebInvocationPrivilegeEvaluator;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////            auth.inMemoryAuthentication()
////                .withUser("admin").password("admin").roles("USER"); // ... etc.
//    }
    @Autowired
    private LoginAuthenticationManager loginAuthenticationManager;
//    @Autowired
//    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserService);
        auth.authenticationProvider(loginAuthenticationManager);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers(GlobalConf.NOT_INTERCEPT.split(","));
//        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
//        filterSecurityInterceptor.setSecurityMetadataSource(new InvocationSecurityMetadataSourceService());
//        web.securityInterceptor(filterSecurityInterceptor);
//        web.securityInterceptor()
//        new DefaultWebInvocationPrivilegeEvaluator();
    }

    // ... other stuff for application security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        "/resources/static/staticFile/**", "/resources/static/staticFile/bootstrap-3.3.7/**", "/staticFile/*", "/staticFile/**"
        http
            .authorizeRequests()
            .antMatchers(GlobalConf.NOT_INTERCEPT.split(",")).permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.csrf().disable().headers().frameOptions().sameOrigin();
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

}