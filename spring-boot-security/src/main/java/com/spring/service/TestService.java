package com.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.TestDao;
import com.spring.model.UserDetails;

@Service
@Transactional
public class TestService
{
	@Autowired
	private TestDao testDao;

	public UserDetails saveUser(UserDetails user) {
		return testDao.save(user);
	}
	
	public UserDetails getUserById(int userId) {
		return testDao.findOne(userId);
	}
	
	public List<UserDetails> getAllUsers() {
		return testDao.findAll();
	}
	
}
