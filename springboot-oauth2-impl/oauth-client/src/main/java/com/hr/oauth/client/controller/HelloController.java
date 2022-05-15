package com.hr.oauth.client.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Authentication is required to access these apis. (Consent is not required here)  
 * 
 */
@RestController
@RequestMapping("/home")
public class HelloController {

	@GetMapping("/default")
	public String defaultMessage()
	{
		return "defaultMessage";
	}
	
	@GetMapping
	public String hello(Principal principal) {
        return "Hello " +principal.getName()+", Welcome to Spring Boot with Oauth integration project";
    }
	
}
