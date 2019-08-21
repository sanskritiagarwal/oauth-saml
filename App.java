package com.javacodegeeks;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
	
	  @GetMapping("/login") public String welcomeUser(Principal principal) {
		 
		  
	  String temp="Welcome called ( /login)--->"+principal;
	  System.out.println(temp); 
	  return temp;  
	  //"Welcome "+principal.getName()+" to Spring Security Demo App for FSV"+"\n<H1>"+principal+"</H1>";
	     
	  }
	  
	  @GetMapping("/") public String defaultPage(Principal principal) {
		  OAuth2Authentication oa=(OAuth2Authentication) principal;
		  System.err.println(oa.getCredentials());
		  System.err.println(oa.getName());
		  System.err.println(oa.getPrincipal());
		  System.err.println(oa.getUserAuthentication());
		  System.err.println(oa.getOAuth2Request().getClientId());
		  
		  String temp="Welcome called (/)--->"+principal;
		  System.out.println(temp); 
		  return "Welcome "+oa.getName()+" , id: "+oa.getUserAuthentication()+" to Spring Security Demo App";
	  
	  }
	 
	
}
