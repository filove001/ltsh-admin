package com.ltsh.admin;

import com.ltsh.admin.management.interceptor.LogInterceptor;
import com.ltsh.admin.management.interceptor.SameUrlDataInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableCaching//启动缓存
public class EadminApplication implements WebMvcConfigurer {
	/**
	 * 继承WebMvcConfigurer
	 * 添加拦截器
	 * @author lance
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor());
		registry.addInterceptor(new SameUrlDataInterceptor());
	}

	public static void main(String[] args) {
		SpringApplication.run(EadminApplication.class, args);
	}
	
}
