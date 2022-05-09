package com.hr.springboot.oauth2.authserver.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
		return authenticate(authentication,userDetails);
	}

	private Authentication authenticate(Authentication authentication, UserDetails userDetails)
	{
		if(passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword()))
		{
			return new UsernamePasswordAuthenticationToken(
					userDetails.getUsername(), 
					userDetails.getPassword(), 
					userDetails.getAuthorities());
		}
		else
		{
			throw new BadCredentialsException("Bad credentials"); 
		}
	}

	@Override
	public boolean supports(Class<?> authentication) 
	{
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

	
}
