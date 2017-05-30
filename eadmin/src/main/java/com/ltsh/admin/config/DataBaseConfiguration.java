//package com.ltsh.admin.config;
//
///**
// * Created by fengjianzhong on 2017/5/29.
// */
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//@Configuration
//@EnableTransactionManagement
//public class DataBaseConfiguration {
//
////    private RelaxedPropertyResolver propertyResolver;
//    @Autowired
//    private Environment env;
////    @Override
////    public void setEnvironment(Environment env) {
////        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
////    }
//
//    @Bean(destroyMethod = "close", initMethod = "init")
//    public DataSource writeDataSource() {
//        System.out.println("注入druid！！！");
//
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(env.getProperty("url"));
//        datasource.setDriverClassName(env.getProperty("driver-class-name"));
//        datasource.setUsername(env.getProperty("username"));
//        datasource.setPassword(env.getProperty("password"));
//        datasource.setInitialSize(Integer.valueOf(env.getProperty("initialSize")));
//        datasource.setMinIdle(Integer.valueOf(env.getProperty("minIdle")));
//        datasource.setMaxWait(Long.valueOf(env.getProperty("maxWait")));
//        datasource.setMaxActive(Integer.valueOf(env.getProperty("maxActive")));
//        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getProperty("minEvictableIdleTimeMillis")));
//        return datasource;
//    }
//}