**Project Tech Stack:**

* Spring Boot 
* Spring Security
* Spring Oauth2 with OpenID connect


**Project Structure:**

* Oauth2 authorization server
* Oauth2 resource server
* Client application

**Project Scope:**

1. Authentication method : BASIC
2. Scopes : OPENID and API.READ 


**PROJECT FLOW:**

(USER) -----------------------> http://localhost:8080/home/users

		---- redirected to ---> http://localhost:8080/oauth2/authorization/api-client-oidc  [here 'api-client-oidc' is the client-id for this client] - mentioned in client-config
		---- redirected to ---> http://auth-server:9000/oauth2/authorize?response_type=code&client_id=hr-api-client
					  		      &scope=openid&state=bF4-npIVa7_W1UPG4uvxrB0YxvFB464v-l-lUyMJYlw%3D
 								  &redirect_uri=http://127.0.0.1:8080/login/oauth2/code/api-client-oidc&nonce=BeL-F-0j8d0rr4T_U2JO88XV5w_qpPpnunLhS7oK1_4
		---- redirected to ---> http://auth-server:9000/login
		
		[ LOG-IN PAGE IS DISPLAYED NOW ] --> Enter credentials
		
		---- redirected to ---> http://auth-server:9000/login
		---- redirected to ---> http://auth-server:9000/oauth2/authorize?
									response_type=code&client_id=hr-api-client&scope=openid
									&state=i3q5NWmD4gPZayWqBtRr08k16Hv2Tw0Wb6QtdcWYEwE%3D
									&redirect_uri=http://localhost:8080/login/oauth2/code/api-client-oidc
									&nonce=WQEUEMLyshnaakCZDvDXgtlNjA6_fPz30X-mQwXtSlc
		---- redirected to ---> http://localhost:8080/login/oauth2/code/api-client-oidc?
									code=GDR_y5aXxF7x-yAaBmE_17toez7KDPPXzSqA_j1RFT0WPO3HGkjTA_eLKCKjkxHW1i85y-uUzCO8vUi59hbqL6FAa2wP25DNUiLoqHzph-an8IKOr2Sv_J8d8KAFV0GA
									&state=i3q5NWmD4gPZayWqBtRr08k16Hv2Tw0Wb6QtdcWYEwE%3D
		---- redirected to ---> http://localhost:8080/home/users [ACTUAL SECURED URL]
		
		
		
		
		
		
		
		
		
	
