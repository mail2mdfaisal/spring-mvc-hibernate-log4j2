package com.faisal.spring.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HibernateConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getBasicDataSource());
		sf.setPackagesToScan("com.faisal.spring.entity");
		sf.setHibernateProperties(getHibernateProperties());
		return sf;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.show_sql",env.getProperty("show_sql"));
		props.put("hibernate.dialect", env.getProperty("dialect"));
		return props;
	}

	private BasicDataSource getBasicDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setUsername(env.getProperty("user"));
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setPassword(env.getProperty("password"));
		return dataSource;
	}
}
