package com.ltsh.admin;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ltsh.admin.management.interceptor.LogInterceptor;
import com.ltsh.admin.management.interceptor.SameUrlDataInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
@EnableCaching//启动缓存
public class EadminApplication implements WebMvcConfigurer {

	/**
	 * 使用 fastjson 转换为字符串
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		/**
		 * 1.需要定义一个convert转换消息的对象
		 * 2.创建配置信息，加入配置信息：比如是否需要格式化返回的json
		 * 3.converter中添加配置信息
		 * 4.convert添加到converters当中
		 */
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter =
				new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.PrettyFormat
		);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastJsonHttpMessageConverter);
	}



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
