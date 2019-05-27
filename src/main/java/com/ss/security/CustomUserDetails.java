package com.ss.security;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ss.pojo.Role;
import com.ss.pojo.User;
import com.ss.pojo.UserRole;


public class CustomUserDetails extends User implements UserDetails{


	private static final long serialVersionUID = 1L;
	private User user;
	
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
//
//
//	public CustomUserDetails(final User user) {
//		super(user);
//	}
	
	
	public CustomUserDetails() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
//		System.out.println("superPass: " + user.getPassword());
//		System.out.println("superuser: " + user.getEmail());
	
		for(UserRole role : user.getUserRoles()) {
			System.out.println(role.getRole());
		}
		
		
		return user.getUserRoles().stream().map(
				role -> new SimpleGrantedAuthority(
						role.getRole().toString())).collect(Collectors.toList());
				
//		return getUserRoles().stream()
//					.map(role -> new SimpleGrantedAuthority(role.getRole().toString()))
//						.collect(Collectors.toList());
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}




	
}
