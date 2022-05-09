**Project Tech Stack**

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

**Key Notes:**
- Spring-authorization-server project (>0.2.0) is not working properly when the urls (redirection, login, oauth/* etc.) contain 'localhost' but works with the ip (127.0.0.1). So, a filter is added to redirect localhost to 127.0.0.1



**PROJECT FLOW (source : https://auth0.com/docs/get-started/authentication-and-authorization-flow/authorization-code-flow):**
![auth-sequence-auth-code](https://user-images.githubusercontent.com/40859584/167460796-0f63940b-2000-4786-9407-c9717e830dc4.png)


**PROJECT FLOW (example):**

(USER) -----------------------> http://localhost:8080/home/users [SECURED URL]

       	---- redirected to ---> http://localhost:8080/oauth2/authorization/api-client-oidc  [here 'api-client-oidc' is the client-id for this client] -  mentioned in client-config
	---- redirected to ---> http://auth-server:9000/oauth2/authorize?response_type=code&client_id=hr-api-client
				  		      &scope=openid&state=bF4-npIVa7_W1UPG4uvxrB0YxvFB464v-l-lUyMJYlw%3D
 	 			  &redirect_uri=http://127.0.0.1:8080/login/oauth2/code/api-client-oidc&nonce=BeL-F-0j8d0rr4T_U2JO88XV5w_qpPpnunLhS7oK1_4
	---- redirected to ---> http://auth-server:9000/login
		
[ DEFAULT LOG-IN PAGE IS DISPLAYED NOW ] --> Enter credentials
		
	---- redirected to ---> http://auth-server:9000/login
	---- redirected to ---> http://auth-server:9000/oauth2/authorize?
						response_type=code&client_id=hr-api-client&scope=openid
						&state=i3q5NWmD4gPZayWqBtRr08k16Hv2Tw0Wb6QtdcWYEwE%3D
						&redirect_uri=http://localhost:8080/login/oauth2/code/api-client-oidc
						&nonce=WQEUEMLyshnaakCZDvDXgtlNjA6_fPz30X-mQwXtSlc
	---- redirected to ---> http://localhost:8080/login/oauth2/code/api-client-oidc?
			code=GDR_y5aXxF7x-yAaBmE_17toez7KDPPXzSqA_j1RFT0WPO3HGkjTA_eLKCKjkxHW1i85y-uUzCO8vUi59hbqL6FAa2wP25DNUiLoqHzph
					&state=i3q5NWmD4gPZayWqBtRr08k16Hv2Tw0Wb6QtdcWYEwE%3D
	---- redirected to ---> http://localhost:8080/home/users [ACTUAL SECURED URL]
		
		
		
		
		
		
		
		
	
