package com.project.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.sessions.factories.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class JPAConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource());
		lef.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lef.setJpaProperties(getProperties());
		lef.setPackagesToScan("com.project.entity");
		return lef;
	}

	@Bean
	public DataSource dataSource() {
		// Connection Pooling data source
		ComboPooledDataSource driver = new ComboPooledDataSource();
		try {
			driver.setDriverClass("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.setJdbcUrl("jdbc:mysql://localhost:3306/pr0ject?useSSL=false");
		driver.setUser("murali101002");
		driver.setPassword("murali101002");
		driver.setMinPoolSize(5);
		driver.setMaxPoolSize(20);
		driver.setMaxIdleTime(30000);
		return driver;
	}

	@Bean
	public PlatformTransactionManager txnMgr(EntityManagerFactory emf) {
		JpaTransactionManager txnMgr = new JpaTransactionManager(emf);
		return txnMgr;
	}

	@Bean
	public Properties getProperties() {
		Properties props = new Properties();
		props.setProperty(PersistenceUnitProperties.WEAVING, "false");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
		props.setProperty("hibernate.show_sql", "true");
		return props;
	}
}
