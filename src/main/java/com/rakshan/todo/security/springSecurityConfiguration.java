package com.rakshan.todo.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class springSecurityConfiguration {

	//LDAP or database
	
//	InMemoryUserDetailsManager
//	InMemoryUderDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetaislManager() {
		UserDetails userDetails1 = createnewUser("rakshan", "dummy");
		UserDetails userDetails2 = createnewUser("wolkop", "dummy2");
		
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createnewUser(String username, String password) {
		Function<String, String> passwordEnchoder
			= input -> passwordEncoder().encode(input);
			
			

		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEnchoder)
									.username(username)
									.password(password)
									.roles("USER", "ADMIN")
									.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf(csrf -> csrf.disable());
		// OR
		// http.csrf(AbstractHttpConfigurer::disable);

		http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)); // Starting from SB 3.1.x
		
		return http.build();
	}
	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    // Configure security to authorize any request to be authenticated
//	    http
//	        .authorizeHttpRequests(authorize -> authorize
//	            .anyRequest().authenticated()
//	        )
//	        // Enable form-based login with default settings
//	        .formLogin(Customizer.withDefaults())
//	        // Disable CSRF protection
//	        .csrf(csrf -> csrf.disable())
//	        // Disable frame options to allow the use of frames
//	        .headers(headers -> headers
//	            .frameOptions(frameOptions -> frameOptions.disable())
//	        );
//
//	    return http.build();
//	}


}
