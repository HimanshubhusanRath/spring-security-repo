package com.hr.oauth.resource.server.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured-data")
public class UsersController {

	@GetMapping("/users")
	public String[] users(Principal principal)
	{
		System.out.println("PRINCIPAL ----->> "+principal.getName());
		return new String[] {"Himanshu","Harman","Rajesh"};
	}
	
}
