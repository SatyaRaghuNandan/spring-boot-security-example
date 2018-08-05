package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//https://github.com/kishanjavatrainer/SpringBootSecurityInMemoryAuthentication

/**
 * 
 * @author GUNA SEKHAR
 *
 * GET - http://localhost:8070/api/admin/all
 * login - dummy(username) & pass(password)
 * 
 * GET - http://localhost:8070/api/user/1
 * login - sekhar(username) & pass(password)
 * 
 * Post - http://localhost:8070/api/save
 * {
 * 		"userId":6,
 * 		"name":"ccc",
 * 		"salary":10000
 * }
 *
 */


@EnableWebSecurity
public class TestSecurityConfig extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
				.antMatchers("/api/user/**").hasAnyRole("admin","user")
				.and().formLogin();
		
		http.csrf().disable().authorizeRequests()
				.antMatchers("/api/admin/**").hasAnyRole("admin")
				.and().formLogin();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("dummy").password("pass").roles("user");
		auth.inMemoryAuthentication().withUser("sekhar").password("pass").roles("admin");
		
	}
	
}
