package com.rivergame.fvgm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.io.IOException;


@Configuration
@MapperScan(basePackages = "com.rivergame.fvgm.dao.farmtime", sqlSessionTemplateRef = "farmTimeSqlSessionTemplate")
public class DataSource4Config {
    @Bean(name = "farmTimeDataSource")
    public DruidDataSource dataSource() {
        String prefix = "datasource_farm_time_";
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
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("*ServiceImpl");

        beanNameAutoProxyCreator.setInterceptorNames("transactionInterceptor");
        return beanNameAutoProxyCreator;
    }

    @Bean(name = "farmTimeTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean(name = "farmTimeSqlSessionFactory")
    public SqlSessionFactoryBean mybatisSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/farmtime/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }

    @Bean(name = "farmTimeSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(mybatisSqlSessionFactory().getObject());
    }
}
