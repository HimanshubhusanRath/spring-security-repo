package com.hr.springboot.oauth2.authserver.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hr.springboot.oauth2.authserver.entity.User;
import com.hr.springboot.oauth2.authserver.repository.UserRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final User user = userRepository.getByEmail(userName);
		if(null==user)
		{
			throw new UsernameNotFoundException("User not found for the name : "+userName);
		}
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), 
				user.getPassword(), 
				user.isEnabled(), 
				true, 
				true,
				true, 
				getAuthorities(List.of(user.getRole())));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}

}
