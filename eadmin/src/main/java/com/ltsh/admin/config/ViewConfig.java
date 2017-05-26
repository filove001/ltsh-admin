package com.ltsh.admin.config;

import java.io.IOException;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.beetl.sql.core.ClasspathLoader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
@Configuration
public class ViewConfig {
	@Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        //			String root =  patternResolver.getResource("classpath:templates").getFile().toString();
		//			WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader(root);
		//			beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
        //将工程生成jar包后运行就找不到模板路径了 class path resource [templates/] cannot be resolved to absolute file path because it does not reside in the file system
        //所以用下面这种方式来加载模板路径
    	ClasspathResourceLoader classPathLoader= new ClasspathResourceLoader ("templates/");
		beetlGroupUtilConfiguration.setResourceLoader(classPathLoader);
        beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:beetl.properties"));
        return beetlGroupUtilConfiguration;
    }
 
    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        beetlSpringViewResolver.setSuffix(".html");
        return beetlSpringViewResolver;
    }
    
    
}
