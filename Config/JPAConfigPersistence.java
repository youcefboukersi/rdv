package Config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfigPersistence {
	
	@Bean(name="entityFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
			{
				LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
				emf.setDataSource(dataSource());
				emf.setPackagesToScan("com.rdvmedicaux.Entities");
				
				JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
				emf.setJpaVendorAdapter(vendor);
				emf.setJpaProperties(jpaProperties());
				return emf;
			}

	@Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   
	   Properties jpaProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.show_sql", "true");
	      properties.setProperty("hibernate.hbm2ddl.auto", "create");
	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	      return properties;
	   }

	   @Bean(name="DataSource")
	   public DataSource dataSource() {
		   DriverManagerDataSource datasource = new DriverManagerDataSource();
		   datasource.setDriverClassName("com.mysql.jdbc.Driver");
		   datasource.setUsername("root");
		   datasource.setPassword("");
		   datasource.setUrl("jdbc:mysql://localhost:3306/RDV_Medicale");
		   return datasource;
	}
	
}
