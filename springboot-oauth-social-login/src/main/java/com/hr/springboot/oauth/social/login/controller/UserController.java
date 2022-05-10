package com.hr.springboot.oauth.social.login.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/hello")
	public String hello(Principal principal)
	{
		return "Hello user : "+principal.getName();
	}

}
