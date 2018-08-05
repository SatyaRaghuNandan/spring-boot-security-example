package com.spring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.model.UserDetails;

public interface TestDao extends CrudRepository<UserDetails, Integer>
{

	UserDetails findOne(int userId);
	
	List<UserDetails> findAll();
}
