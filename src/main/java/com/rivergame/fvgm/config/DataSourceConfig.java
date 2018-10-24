package com.rivergame.fvgm.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;


import java.io.IOException;
import java.util.Properties;


@Configuration
@MapperScan(basePackages = "com.rivergame.fvgm.dao", sqlSessionTemplateRef = "baseSqlSessionTemplate")
public class DataSourceConfig {
    @Bean(name = "baseDataSource")
    @Primary
    public DruidDataSource dataSource() {
        String prefix = "datasource_";
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(DBSettings.getProperty(prefix + "url"));
        dataSource.setUsername(DBSettings.getProperty(prefix + "username"));
        dataSource.setPassword(DBSettings.getProperty(prefix + "password"));
        dataSource.setInitialSize(DBSettings.getIntProperty(prefix + "initial_size"));
        dataSource.setMinIdle(DBSettings.getIntProperty(prefix + "min_idle"));
        dataSource.setMaxActive(DBSettings.getIntProperty(prefix + "max_active"));
        dataSource.setMaxWait(DBSettings.getIntProperty(prefix + "max_wait"));
        dataSource.setTimeBetweenEvictionRunsMillis(DBSettings.getIntProperty(prefix + "time_between_eviction_runs_millis"));
        dataSource.setMinEvictableIdleTimeMillis(DBSettings.getIntProperty(prefix + "min_evictable_idle_time_millis"));
        dataSource.setValidationQuery(DBSettings.getProperty(prefix + "validation_query"));
        dataSource.setTestWhileIdle(DBSettings.getBooleanProperty(prefix + "test_while_idle"));
        dataSource.setTestOnBorrow(DBSettings.getBooleanProperty(prefix + "test_on_borrow"));
        dataSource.setTestOnReturn(DBSettings.getBooleanProperty(prefix + "test_on_return"));
        return dataSource;
    }

    @Bean
    @Primary
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("*ServiceImpl");

        beanNameAutoProxyCreator.setInterceptorNames("transactionInterceptor");
        return beanNameAutoProxyCreator;
    }

    @Bean(name = "baseTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    @Primary
    public TransactionInterceptor transactionInterceptor() {
        TransactionInterceptor interceptor = new TransactionInterceptor();
        interceptor.setTransactionManager(transactionManager());
        Properties pro = new Properties();
        pro.put("select*", "PROPAGATION_REQUIRES_NEW,ISOLATION_DEFAULT,readOnly,-java.lang.Exception");
        pro.put("select*", "PROPAGATION_REQUIRES_NEW,ISOLATION_DEFAULT,-java.lang.Exception");
        pro.put("select*", "PROPAGATION_REQUIRES_NEW,ISOLATION_DEFAULT,-java.lang.Exception");
        pro.put("select*", "PROPAGATION_REQUIRES_NEW,ISOLATION_DEFAULT,-java.lang.Exception");
        interceptor.setTransactionAttributes(pro);
        return interceptor;
    }

    @Bean(name = "baseSqlSessionFactory")
    @Primary
    public SqlSessionFactoryBean mybatisSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }

    @Bean(name = "baseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(mybatisSqlSessionFactory().getObject());
    }
}
