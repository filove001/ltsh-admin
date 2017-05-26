package com.ltsh.admin.config;

import javax.sql.DataSource;

import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class DbConfig{

	@Autowired
    private DataSource dataSource;
	
	@Bean(name = "beetlSqlScannerConfigurer")
    public static BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
    	BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
    	conf.setBasePackage("com.ltsh.admin.mvc");
    	conf.setDaoSuffix("Dao");
    	conf.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
    	return conf;
    }
	
    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean getSqlManagerFactoryBean() {
    	SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
    	BeetlSqlDataSource  source = new BeetlSqlDataSource();
    	source.setMasterSource(dataSource);;
    	factory.setCs(source);
    	factory.setDbStyle(new MySqlStyle());
    	factory.setInterceptors(new Interceptor[]{new DebugInterceptor()});
    	factory.setNc(new UnderlinedNameConversion());
    	factory.setSqlLoader(new ClasspathLoader("/sql"));
    	return factory;
    }
    @Bean(name="txManager")  
    public DataSourceTransactionManager getDataSourceTransactionManager() {  
    	DataSourceTransactionManager dsm = new DataSourceTransactionManager();
    	dsm.setDataSource(dataSource);
    	return dsm;
    }


}
