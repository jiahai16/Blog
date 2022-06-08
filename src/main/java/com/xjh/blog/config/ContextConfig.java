package com.xjh.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootConfiguration
public class ContextConfig {
    private String typeHandlersPackage = "com.xjh.blog.enums.handler";

    private String mapperLocations = "classpath*:/mapper/*.xml";

    private static final Logger logger = LoggerFactory.getLogger(ContextConfig.class);

    @Resource
    private SingleDBConfig dbConfig;


    @Bean
    @Lazy
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setInitialSize(dbConfig.getInitialSize());
        dataSource.setMinIdle(dbConfig.getMinIdle());
        dataSource.setMaxActive(dbConfig.getMaxActive());
        dataSource.setMaxWait(dbConfig.getMaxWait());
        dataSource.setDriverClassName(dbConfig.getDriverClassName());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);

        // 设置配置文件及mapper文件地址
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources(mapperLocations));
        factory.setTypeHandlersPackage(typeHandlersPackage);
        factory.setTypeAliasesPackage("com.xjh.bean");
        return factory.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory, ExecutorType.SIMPLE);
    }
}
