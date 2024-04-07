package com.learn.codewithankur.springsec.model;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails  implements UserDetails {
	
	private static final long serialVersionUID = 7870832769645914796L;
	UserDTO user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Set<SimpleGrantedAuthority> set = new HashSet<>();
		
		set.add(new SimpleGrantedAuthority(user.getRole()));
		
		return set;
		
		
	}
	
	

	public CustomUserDetails(UserDTO user) {
		super();
		this.user = user;
	}



	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
	 return	user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
