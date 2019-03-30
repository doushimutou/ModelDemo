package com.example.mapper.ds;/**
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @author ayt
 * @date 2018/8/513:53E:\dispatch\demo\mapper\src\main\java\com\example\mapper\mappers
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author ayt  on 20180805
 */
@Configuration
@MapperScan(basePackages =MytestDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "mytestSqlSessionFactory")
public class MytestDataSourceConfig {

    static final String PACKAGE="com.example.mapper.mappers";
    static final String MAPPER_LOCATION="classpath:/mapper/*.xml";
    //@Value 获取全局配置文件 application.properties 的 kv 配置,并自动装配
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driverClassName}")
    private String driverClass;



    @Bean(name="mytestDataSource")
    public DataSource mytestDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean(name="mytestTransactionManager")
    public DataSourceTransactionManager mytestTransactionManager(){
        return new DataSourceTransactionManager(mytestDataSource());
    }


    @Bean(name="mytestSqlSessionFactory")
    public SqlSessionFactory mytestSqlSessionFactory (@Qualifier("mytestDataSource") DataSource mytestDataSource ) throws Exception {
        final SqlSessionFactoryBean sessionFactory=new SqlSessionFactoryBean();
        sessionFactory.setDataSource(mytestDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources(MytestDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();


    }












}
