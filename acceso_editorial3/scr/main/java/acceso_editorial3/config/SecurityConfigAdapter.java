package acceso_editorial3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	/**
	 * @param auth
	 * @throws Exception
	 */
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	} 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.antMatchers("/empleado/**").hasRole("EMPLEADO")
			.antMatchers("/").permitAll()
			.antMatchers("/colaborador/**").hasRole("COLABORADOR")
			.antMatchers("/administrador/**").hasRole("ADMINISTRADOR")
			.antMatchers("/editor/**").hasRole("EDITOR")
			.and().formLogin().loginPage("/formlogin")
// 			.and().formLogin().loginPage("/")
			.loginProcessingUrl("/authenticateTheUser").permitAll().defaultSuccessUrl("/checkrol", true) 
//			.loginProcessingUrl("/authenticateTheUser").permitAll()
			.and().logout().permitAll();
// 			.and().formLogin().loginPage("/")
// 			.loginProcessingUrl("/index").permitAll();
	}
	
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	*/
		
}
