package com.ss.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ss.dao.UserDao;
import com.ss.pojo.User;
import com.ss.service.UserService;

@Service
public class UserImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User getOne(Integer id) {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

//	@Override
//	public User getByEmail(String email) {
//		// TODO Auto-generated method stub
//		return userDao.findByEmail(email);
//	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.findByEmailAndPassword(email, password);
	}

	@Override
	public User save(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}

	
	
}
