package club.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan(basePackages="club")
@EnableWebSecurity
public class SeguridadConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.antMatchers("/").hasRole("TODOS")
				.antMatchers("/socio/**").hasRole("SOCIO")
				.antMatchers("/simpatizante/**").hasRole("SIMPATIZANTE")
				.antMatchers("/administrador/**").hasRole("ADMINISTRADOR")
				.and().formLogin().loginPage("/formlogin")
//				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll().and()
				.loginProcessingUrl("/authenticateTheUser").permitAll().defaultSuccessUrl("/checkrol", true)
				.and().exceptionHandling().accessDeniedPage("/prohibido");
	}

}
