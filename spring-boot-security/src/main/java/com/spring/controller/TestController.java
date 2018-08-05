package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.UserDetails;
import com.spring.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController
{
	@Autowired
	private TestService testService;
	
	@PostMapping("/save")
	public UserDetails saveUser(@RequestBody UserDetails user) {
		return testService.saveUser(user);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/{id}")
	public UserDetails get(@PathVariable("id") int id) {
		return testService.getUserById(id);
	}
	
	@GetMapping("/admin/all")
	public List<UserDetails> getAll() {
		return testService.getAllUsers();
	}

}
