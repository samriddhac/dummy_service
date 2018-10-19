package com.sam.microservice.uservideoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.microservice.uservideoservice.dao.UserRepository;
import com.sam.microservice.uservideoservice.entity.User;
import com.sam.microservice.uservideoservice.entity.UserGroup;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> getAllUsers() {
		return repository.getUsers();
	}
	
	public List<UserGroup> getAllUserGroups() {
		return repository.getGroups();
	}
}
