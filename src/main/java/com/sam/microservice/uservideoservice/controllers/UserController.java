package com.sam.microservice.uservideoservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.microservice.uservideoservice.entity.User;
import com.sam.microservice.uservideoservice.entity.UserGroup;
import com.sam.microservice.uservideoservice.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(path="/users")
	@ResponseBody
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(path="/users/groups")
	@ResponseBody
	public List<UserGroup> getGroups() {
		return userService.getAllUserGroups();
	}
	
}
