package ApplicationConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//Déclaration du FilterChain

@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired(required=true)
	DataSource dataSource;

	// interception et vérification des droit d'accès au url
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**","/").permitAll().antMatchers("/docteur/**").hasRole("DOCTEUR")
				.antMatchers("/patient/**").hasRole("PATIENT").anyRequest().authenticated().and().formLogin()
				.permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/index").invalidateHttpSession(true)
				.and();
	}

	// Test authentication

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}

	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/doctolib");
		datasource.setUsername("root");
		datasource.setPassword("");
		return datasource;
	}
	
}
