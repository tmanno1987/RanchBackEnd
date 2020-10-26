package com.ranch.payload.request;

import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ranch.model.UserCategory;
import com.ranch.model.enums.StateCodes;

public class SignupRequest {
	@NotBlank
	@Size(min=6, max=20)
	private String username;
	
	@NotBlank
	@Size(min=6, max=20)
	private String password;
	
	@NotBlank
	@Size(max=50)
	@Email
	private String email;
	
	@NotBlank
	private UserCategory position;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private StateCodes state;
	
	@NotBlank
	@Size(min=5,max=5)
	private String zip;
	
	@NotBlank
	@Digits(fraction=2,integer=10)
	private double salary;
	
	@NotBlank
	@Size(min=10,max=13)
	private String phone;
	
	private Set<String> role;

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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the position
	 */
	public UserCategory getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(UserCategory position) {
		this.position = position;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public StateCodes getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(StateCodes state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the role
	 */
	public Set<String> getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Set<String> role) {
		this.role = role;
	}
}





