package ru.eugene.java.learn.config;

import org.hibernate.cfg.Environment;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.eugene.java.learn.repository")
public class DataConfiguration {
    private final String driverClassName = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://localhost:5432/web?currentSchema=orm_test";
    private final String username = "web_user";
    private final String password = "web_user";

    private final String[] packagesToScan = new String[]{"ru.eugene.java.learn.data"};

    private final String dialect = "org.hibernate.dialect.PostgresPlusDialect";
    private final String showSql = "true";
    private final String hbm2ddlAuto = "create";

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(packagesToScan);
        entityManagerFactoryBean.setJpaProperties(getJpaProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties getJpaProperties(){
        Properties jpa = new Properties();
        jpa.put(Environment.DIALECT, dialect);
        jpa.put(Environment.SHOW_SQL, showSql);
        jpa.put(Environment.HBM2DDL_AUTO, hbm2ddlAuto);
        return jpa;
    }
}
