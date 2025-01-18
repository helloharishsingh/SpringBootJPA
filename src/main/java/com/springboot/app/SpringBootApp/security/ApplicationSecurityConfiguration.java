package com.springboot.app.SpringBootApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class ApplicationSecurityConfiguration {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		/*
		 * UserDetails normalUser =
		 * User.withUsername("NORMAL").password(passwordEncoder().encode("NORMAL"))
		 * .roles("NORMAL").build(); UserDetails adminUser =
		 * User.withUsername("ADMIN").password(passwordEncoder().encode("ADMIN")).roles(
		 * "ADMIN") .build(); UserBuilder users = User.withDefaultPasswordEncoder();
		 * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(normalUser, adminUser);
		 * manager.createUser(users.username("user").password("password").roles("USER").
		 * build());
		 * manager.createUser(users.username("admin").password("password").roles("USER",
		 * "ADMIN").build()); return manager;
		 */
		  
		UserBuilder users = User.builder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(users.username("NORMAL").password("NORMAL").roles("NORMAL").build());
		manager.createUser(users.username("ADMIN").password(passwordEncoder().encode("ADMIN")).roles("ADMIN").build());
		return manager;

		
		
		 
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		
		/*
		 * security.csrf(customizer->customizer.disable());
		 * //security.authorizeHttpRequests(request->request.anyRequest().authenticated(
		 * ));
		 * security.authorizeHttpRequests(request->request.requestMatchers("/admin/api")
		 * .hasRole("ADMIN"));
		 * 
		 * security.authorizeHttpRequests(request->request.requestMatchers(
		 * "/employee/api").hasRole("USER"));
		 * security.authorizeHttpRequests(request->request.anyRequest().authenticated())
		 * ; security.sessionManagement(session->session.sessionCreationPolicy(
		 * SessionCreationPolicy.STATELESS));
		 * security.formLogin(Customizer.withDefaults());
		 * security.httpBasic(Customizer.withDefaults()); return security.build();
		 */
		
		
		  security.csrf().disable().authorizeHttpRequests().requestMatchers(
		  "/employee/api").hasRole("NORMAL")
		  .requestMatchers("/admin/api").hasRole("ADMIN") // .permitAll()
		  .anyRequest().authenticated()
		  .and().formLogin(Customizer.withDefaults());
		  security.httpBasic(Customizer.withDefaults());
		  // .and() // .formLogin(); return
		  return security.build();
		 

	}

}
