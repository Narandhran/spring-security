package com.ss.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.dao.UserDao;
import com.ss.pojo.User;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		User user = userDao.findByEmail(email);
		
		
		
		CustomUserDetails userDetail = null;
		if(user!=null) {
			userDetail = new CustomUserDetails();
			userDetail.setUser(user);
			
			//System.out.println("cusUserService: " + user.getEmail());
		}
		else {
			throw new UsernameNotFoundException("user not found");
		}
		return userDetail;
		
	}
			
}
