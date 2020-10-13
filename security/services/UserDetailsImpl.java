package com.ranch.security.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ranch.model.Users;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String email;
	
	private Collection<? extends GrantedAuthority> auth;
	
	public UserDetailsImpl() { }
	
	public UserDetailsImpl(long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authority) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.auth = authority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return auth;
	}
	
	public static UserDetailsImpl build(Users user) {
		List<GrantedAuthority> auth = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()
				.name())).collect(Collectors.toList());
		
		return new UserDetailsImpl(user.getId(), user.getUser(), user.getEmail(), user.getPass(), auth);
	}
	
	public long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	public String getEmail() {
		return email;
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