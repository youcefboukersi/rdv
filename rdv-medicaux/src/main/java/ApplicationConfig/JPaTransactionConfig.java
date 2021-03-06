package ApplicationConfig;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rdvmedicaux.DAO.DaoImplements;

@Configuration
@EnableTransactionManagement
public class JPaTransactionConfig {

	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/doctolib");
		datasource.setUsername("root");
		datasource.setPassword("");
		return datasource;
	}
	
	 Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.hbm2ddl.auto", "update");
	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	      return properties;
	   }
	 
	 @Bean
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	 {
		 LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		 em.setDataSource(dataSource());
		 em.setPackagesToScan(new String[]{"com.rdvmedicaux"});
		 
		 JpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		 em.setJpaVendorAdapter(vendor);
		 em.setJpaProperties(additionalProperties());
		 return em;		 
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
	 
	   @Bean
	   public DaoImplements dao()
	   {
		   return new DaoImplements();
	   }	 
	   
	   
	   @Bean 
		public PasswordEncoder passWord()
		{
			return new BCryptPasswordEncoder(16);
		}
	   	 
	   
}
