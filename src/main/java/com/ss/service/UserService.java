package com.ss.service;

import java.util.List;

import com.ss.pojo.User;

public interface UserService {

	User getOne(Integer id);
	List<User> getAll();
//	User getByEmail(String email);
	User login(String email,String password);
	User save(User user);
}
