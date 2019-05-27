package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.pojo.User;
import com.ss.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@RequestMapping(path="/getUser")
	public User getUser() {
		
		User user = new User();
		return user;
	}
	
	@RequestMapping(path="/create",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public User createUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	
	@RequestMapping(path="/view")
	public String viewUser() {
		return "view can possible";
	}
	
	
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	@RequestMapping(path="/user")
	public String byUser() {
		return "hii user";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(path="/secured/all")
	public String byAll() {
		
		return "hii all";
	}
}
