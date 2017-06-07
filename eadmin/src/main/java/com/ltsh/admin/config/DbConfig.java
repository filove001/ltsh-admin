package com.ltsh.admin.config;

import javax.sql.DataSource;

import com.ltsh.admin.mvc.sys.menu.SysMenu;
import com.ltsh.admin.mvc.sys.privilege.SysPrivilege;
import com.ltsh.admin.mvc.sys.role.SysRole;
import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.SimpleCacheInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.ArrayList;
import java.util.List;

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

	static final List<String> lcs = new ArrayList<String>(){{
		add(SysMenu.class.getSimpleName().toLowerCase());
		add(SysPrivilege.class.getSimpleName().toLowerCase());
		add(SysRole.class.getSimpleName().toLowerCase());
	}};
	//缓存  同DebugInterceptor构造方式一样， SimpleCacheInterceptor能缓存指定的sql查询结果
	//指定所有namespace为 SysMenu,SysPrivilege,SysRole等查询都讲被缓存，如果此namepace有更新操作，则缓存清除，输出如下
    public static final SimpleCacheInterceptor cache=new SimpleCacheInterceptor(lcs);

    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean getSqlManagerFactoryBean() {
		SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
    	BeetlSqlDataSource  source = new BeetlSqlDataSource();
    	source.setMasterSource(dataSource);;
    	factory.setCs(source);
    	factory.setDbStyle(new MySqlStyle());


//		lcs.add(SysMenu.class.getSimpleName().toLowerCase());
//		lcs.add(SysPrivilege.class.getSimpleName().toLowerCase());
//		lcs.add(SysRole.class.getSimpleName().toLowerCase());

    	factory.setInterceptors(new Interceptor[]{
    			new DebugInterceptor(),
				cache});
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
