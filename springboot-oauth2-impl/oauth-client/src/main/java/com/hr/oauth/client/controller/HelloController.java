package com.hr.oauth.client.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/home")
public class HelloController {

	@Autowired
	private WebClient webClient;
	
	@GetMapping
	public String hello(Principal principal) {
        return "Hello " +principal.getName()+", Welcome to Spring Boot with Oauth integration project";
    }
	
	@GetMapping("/users")
	public String[] getUsers(@RegisteredOAuth2AuthorizedClient("api-client-authorization-code") OAuth2AuthorizedClient authClient)
	{
		System.out.println("ACCESS TOKEN >>> "+authClient.getAccessToken().getTokenValue());
		return webClient
					.get()
					.uri("http://localhost:8090/secured-data/users")
					.attributes(ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(authClient))
					.retrieve()
					.bodyToMono(String[].class)
					.block();
	}
}
