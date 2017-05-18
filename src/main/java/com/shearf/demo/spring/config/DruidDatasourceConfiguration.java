package com.shearf.demo.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by xiahaihu2009@gmail on 2017/4/5.
 */
@Configuration
@PropertySource("classpath:database.properties")
public class DruidDatasourceConfiguration implements EnvironmentAware {

    @Value("${database.driver-class-name}")
    private String driverClassName;

    @Value("${database.username}")
    private String username;

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() {

//        PropertyResolver propertyResolver = new PropertySourcesPropertyResolver();

        System.out.println(driverClassName);
        System.out.println(username);

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getProperty("database.driver-class-name"));
        dataSource.setUrl(environment.getProperty("database.url"));
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setName(environment.getProperty("database.name"));

        try {
            dataSource.setFilters(environment.getProperty("database.filters"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSource.setMaxActive(Integer.parseInt(environment.getProperty("database.maxActive")));
        dataSource.setInitialSize(Integer.parseInt(environment.getProperty("database.initialSize")));
        dataSource.setMaxWait(Long.parseLong(environment.getProperty("database.maxWait")));
        dataSource.setMinIdle(Integer.parseInt(environment.getProperty("database.minIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(
                Long.parseLong(environment.getProperty("database.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(
                Long.parseLong(environment.getProperty("database.minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(environment.getProperty("database.validationQuery"));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(environment.getProperty("database.testOnBorrow")));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(environment.getProperty("database.testWhileIdle")));
        dataSource.setTestOnReturn(Boolean.parseBoolean(environment.getProperty("database.testOnReturn")));
        dataSource.setPoolPreparedStatements(
                Boolean.parseBoolean(environment.getProperty("database.poolPreparedStatements")));
        dataSource.setMaxOpenPreparedStatements(
                Integer.parseInt(environment.getProperty("database.maxOpenPreparedStatements")));

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager txManager(DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:dal/mapper/*Mapper.xml"));
        sessionFactory.setTypeAliasesPackage("com.shearf.demo.spring.domain.entity");
        return sessionFactory;
    }

    @Bean
    @Lazy
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setAnnotationClass(org.springframework.stereotype.Repository.class);
        mapperScannerConfigurer.setBasePackage("com.shearf.demo.spring.dal.mapper");
        return mapperScannerConfigurer;
    }

//    @Autowired
    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
