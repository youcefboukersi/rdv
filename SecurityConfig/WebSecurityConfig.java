package SecurityConfig;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity	
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	protected void configure(HttpSecurity http) throws Exception{
		
		http
			.authorizeRequests()
				.antMatchers("/Docteur").hasRole("ROLE_DOCTOR")
				.and()
			.formLogin();	
		
	}

}
