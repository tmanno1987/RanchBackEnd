package com.ranch.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private long id;
	private String username;
	private String email;
	private List<String> roles;
	
	/**
	 * @param token
	 * @param id
	 * @param username
	 * @param email
	 * @param roles
	 */
	public JwtResponse(String token, long id, String username, String email, List<String> roles) {
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	/**
	 * @return the token
	 */
	public String getAccessToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setAccessToken(String token) {
		this.token = token;
	}

	/**
	 * @return the type
	 */
	public String getTokenType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setTokenType(String type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}
}