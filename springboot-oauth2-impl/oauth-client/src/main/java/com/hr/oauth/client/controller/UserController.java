package com.hr.oauth.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

	@GetMapping("/hello")
	public String loginss()
	{
		return "Hello unauthorized user !!";
	}

}
