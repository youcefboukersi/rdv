package ApplicationConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//Déclaration du FilterChain


@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	// interception et vérification des droit d'accès au url
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.authorizeRequests()
				.antMatchers("/resources/**").permitAll() 
				.antMatchers("/docteur/**").hasRole("DOCTEUR")
				.antMatchers("/patient/**").hasRole("PATIENT")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/index")
				.invalidateHttpSession(true)
				.and();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("docteur").password("docteur").roles("DOCTEUR").build());
		manager.createUser(User.withUsername("patient").password("patient").roles("PATIENT").build());
		return manager;
	}
	
	
	
}
