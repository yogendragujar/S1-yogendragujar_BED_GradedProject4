package com.greatlearning.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employee.service.DomainUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	private final DomainUserDetailsService userDetailsService;

	// Authentication
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(bcryptPasswordEncoder());
		return provider;

	}

	@Bean
	public PasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DomainUserDetailsService userDetailsService() {
		return userDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**", "/configuration/ui", "/swagger-resources/**", "/configuration/**",
				"/swagger-ui**", "/webjars/**");

//		web.ignoring().antMatchers("/h2-console/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
//		http.headers().frameOptions().disable();
//		http.authorizeRequests().antMatchers("/login**").permitAll()
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/employees/**").hasAnyAuthority("USER", "ADMIN").and()
				.authorizeRequests().antMatchers(HttpMethod.POST, "/api/employees/addEmployee/**").hasAnyAuthority("ADMIN")
//				.authorizeRequests().antMatchers(HttpMethod.POST, "/api/employees/addEmployee/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/employees/delete/**").hasAnyAuthority("ADMIN")
				.and()
				.authorizeRequests().antMatchers("/registration/**").hasAnyAuthority("USER", "ADMIN")
//				.anyRequest()
//				.authenticated()
				.and().httpBasic().and()
				.formLogin()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
	
	
}
