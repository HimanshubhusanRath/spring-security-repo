package com.hr.springboot.oauth2.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.hr.springboot.oauth2.authserver.service.CustomAuthenticationProvider;

@EnableWebSecurity
public class DefaultSpringSecurityConfig {

	@Autowired
	private CustomAuthenticationProvider authProvider;
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(final HttpSecurity http) throws Exception
	{
		return http.authorizeRequests(
				request->request.anyRequest().authenticated()
			)
			.formLogin(Customizer.withDefaults())
			.build();
	}
	
	@Autowired
	public void bindAuthenticationProvider(final AuthenticationManagerBuilder authenticationManagerBuilder)
	{
		authenticationManagerBuilder.authenticationProvider(authProvider);
	}
}
