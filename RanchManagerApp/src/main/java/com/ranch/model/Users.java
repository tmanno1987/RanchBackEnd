package com.ranch.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ranch.model.enums.Position;
import com.ranch.model.enums.StateCodes;

@Entity
@Table(name="Users", uniqueConstraints= {
		@UniqueConstraint(columnNames="username"),
		@UniqueConstraint(columnNames="email")
})
public class Users implements Serializable {
	private static final long serialVersionUID = 101L;

	@Id @Column(name="user_id", nullable=false)
	@NotBlank
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min=6, max=40)
	@Column(name="username", nullable=false)
	private String user;
	
	@NotBlank
	@Size(min=6, max=40)
	@Column(name="password", nullable=false)
	private String pass;
	
	@NotBlank
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@NotBlank
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@NotBlank
	@Column(name="position")
	@Enumerated(EnumType.STRING)
	private Position pos;
	
	@NotBlank
	@Digits(integer=10,fraction=2)
	@Column(name="salary", nullable=false)
	private double salary;
	
	@Column(name="email", nullable=false)
	@Email
	@NotBlank
	private String email;

	@Column(name="phone", nullable=false)
	@NotBlank @Size(min=10, max=13)
	private String phone;
	
	@Column(name="ssn", nullable=false)
	@NotBlank @Size(min=9, max=11)
	private String socialSecurityNumber;
	
	@Column(name="address", nullable=false)
	@NotBlank
	private String addr;
	
	@Column(name="city", nullable=false)
	@NotBlank
	private String city;
	
	@Column(name="state", nullable=false)
	@NotBlank
	@Enumerated(EnumType.STRING)
	private StateCodes state;
	
	@Column(name="zip_code", nullable=false)
	@NotBlank @Size(min=5, max=5)
	private String zip;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="Progress", joinColumns= @JoinColumn(name="user_id"), inverseJoinColumns= @JoinColumn(name="task_id"))
	private Set<Tasks> taskSet = new HashSet<>();
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_positions", joinColumns= @JoinColumn(name="id"), inverseJoinColumns= @JoinColumn(name="role_id"))
	private Set<Roles> roles = new HashSet<>();
	
	public Users() {}
	
	/**
	 * @param user
	 * @param pass
	 * @param firstName
	 * @param lastName
	 * @param salary
	 * @param email
	 * @param phone
	 * @param addr
	 * @param city
	 * @param state
	 * @param zip
	 */
	public Users(@NotBlank @Size(min = 6, max = 40) String user, @NotBlank @Size(min = 6, max = 40) String pass,
			@NotBlank String firstName, @NotBlank String lastName,
			@NotBlank @Digits(integer = 10, fraction = 2) double salary, @Email @NotBlank String email,
			@NotBlank @Size(min = 10, max = 13) String phone, @NotBlank String addr, @NotBlank String city,
			@NotBlank StateCodes state, @NotBlank @Size(min = 5, max = 5) String zip) {
		this.user = user;
		this.pass = pass;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.city = city;
		this.state = state;
		this.zip = zip;
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
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
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
	 * @return the socialSecurityNumber
	 */
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	/**
	 * @param socialSecurityNumber the socialSecurityNumber to set
	 */
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
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
	 * @return the taskSet
	 */
	public Set<Tasks> getTaskSet() {
		return taskSet;
	}

	/**
	 * @param taskSet the taskSet to set
	 */
	public void setTaskSet(Set<Tasks> taskSet) {
		this.taskSet = taskSet;
	}

	/**
	 * @return the roles
	 */
	public Set<Roles> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * @return the pos
	 */
	public Position getPos() {
		return pos;
	}
}














