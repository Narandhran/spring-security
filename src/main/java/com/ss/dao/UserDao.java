package com.ss.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ss.pojo.User;

@Component
public interface UserDao extends JpaRepository<User, Integer> {

	
	User findByEmail(String email);
//	Optional<User> findByEmail(String email);
	User findByEmailAndPassword(String email,String password);
	
}
