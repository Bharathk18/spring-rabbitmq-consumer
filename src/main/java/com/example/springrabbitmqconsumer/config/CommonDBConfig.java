package com.example.springrabbitmqconsumer.config;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.example.springrabbitmqconsumer.repository" })
@EntityScan(basePackages = { "com.example.springrabbitmqconsumer.entity"})
public class CommonDBConfig {

	/**
	 * @return
	 */
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.common")
	public DataSourceProperties primaryDataSourceProperties() {
		return new DataSourceProperties();
	}

	/**
	 * @return
	 */
	@Primary
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource.common")
	public DataSource configurePrimaryDataSource() {
		return primaryDataSourceProperties().initializeDataSourceBuilder().build();
	}

	/**
	 * @return
	 */
	@Primary

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(configurePrimaryDataSource());
		entityManagerFactoryBean.setPackagesToScan("com.example.springrabbitmqconsumer.entity");
		entityManagerFactoryBean.setPersistenceUnitName("primaryPersistenceUnit");
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return entityManagerFactoryBean;
	}

	/**
	 * @return
	 */
	@Primary

	@Bean(name = {"transactionManager"})
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}


}
