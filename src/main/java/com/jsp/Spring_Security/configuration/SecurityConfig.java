package com.jsp.Spring_Security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user= User.withUsername("user")
				.password("{noop}user@123")
				.roles("USER")
				.build();
		
		UserDetails admin=User.withUsername("admin")
				.password("{noop}admin@123")
				.roles("ADMIN")
				.build();
	
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {

		http.authorizeHttpRequests(auth->auth.requestMatchers("/user").hasAnyRole("ADMIN","USER")
				.requestMatchers("/admin").hasRole("ADMIN")
//				.permitAll()
				.anyRequest()
				.authenticated()).httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
